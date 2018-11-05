package com.yuyuda.controller;

import com.yuyuda.pojo.User;
import com.yuyuda.service.UserService;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.admin.indices.alias.Alias;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;
import org.elasticsearch.action.admin.indices.open.OpenIndexRequest;
import org.elasticsearch.action.admin.indices.open.OpenIndexResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.replication.ReplicationResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RestHighLevelClient client;

    @RequestMapping("/hello")
    public String hello() {
        return "Hello world";
    }

    @RequestMapping("/pojo")
    public User showUser() {
        User user = new User();
        user.setId(1);
        user.setName("刘志弦");
        user.setPassword("1234556");
        return user;
    }

    @RequestMapping("/map")
    public Map<String, Object> showMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("username", "张学友");
        map.put("address", "香港");
        return map;
    }

    @RequestMapping("/list")
    public List<User> showList() {
        List<User> list = new ArrayList<>();

        User user1 = new User();
        user1.setId(1);
        user1.setName("张学友");
        user1.setPassword("zxy");

        list.add(user1);
        User user2 = new User();
        user2.setId(2);
        user2.setName("刘德华");
        user2.setPassword("ldh");

        list.add(user2);
        return list;
    }

    @RequestMapping("/ssm")
    public String showUserList(Model model) {
        List<User> list = userService.findAll();
        model.addAttribute("list", list);
        return "show";
    }

    /**
     * 同步创建索引
     * @return
     */
    @RequestMapping("create_index")
    @ResponseBody
    public Map esCreateIndex() {
        CreateIndexRequest request = new CreateIndexRequest("people");
        request.settings(Settings.builder()
                .put("index.number_of_shards", 3)
                .put("index.number_of_replicas", 2)
                .build()
        );

        Map map = new HashMap();
        try {
            CreateIndexResponse createIndexResponse = client.indices().create(request);
            if (createIndexResponse.isAcknowledged()) {
                map.put("state", 200);
                map.put("msg", "索引创建成功！");
            } else {
                map.put("state", 400);
                map.put("msg", "索引创建失败！");
            }
        } catch (IOException e) {
            map.put("state", 500);
            map.put("msg", "服务器异常！");
        }
        return map;
    }

    /**
     * 异步创建索引
     * @return
     */
    @RequestMapping("asyn_create_index")
    @ResponseBody
    public Map esAsynCreateIndex() {
        CreateIndexRequest request = new CreateIndexRequest("yuyuda");
        request.settings(Settings.builder()
                .put("index.number_of_shards", 3)
                .put("index.number_of_replicas", 2)
                .build());
        request.mapping("yuyuda",
                "  {\n" +
                        "    \"yuyuda\": {\n" +
                        "      \"properties\": {\n" +
                        "        \"message\": {\n" +
                        "          \"type\": \"text\"\n" +
                        "        }\n" +
                        "      }\n" +
                        "    }\n" +
                        "  }",
                XContentType.JSON);
        request.alias(new Alias("yyd"));
        request.timeout(TimeValue.timeValueMinutes(2));
        //request.timeout("2m");
        request.masterNodeTimeout(TimeValue.timeValueMinutes(1));
        //request.masterNodeTimeout("1m");
        request.waitForActiveShards(2);
        Map<String, Object> map = new HashMap<>();
        ActionListener<CreateIndexResponse> listener = new ActionListener<CreateIndexResponse>() {
            @Override
            public void onResponse(CreateIndexResponse createIndexResponse) {

            }

            @Override
            public void onFailure(Exception e) {

            }
        };
        client.indices().createAsync(request, listener);
        return map;
    }

    /**
     * 删除索引
     * @return
     */
    @RequestMapping("del_index")
    @ResponseBody
    public Map<String, Object> delIndex() {
        Map<String, Object> map = new HashMap<>();
        DeleteIndexRequest request = new DeleteIndexRequest("book");
        try {
            DeleteIndexResponse deleteIndexResponse = client.indices().delete(request);
            if (deleteIndexResponse.isAcknowledged()) {
                map.put("state", 200);
                map.put("msg", "索引删除成功！");
            } else {
                map.put("state", 400);
                map.put("msg", "索引删除失败！");
            }
        } catch (IOException e) {
            map.put("state", 500);
            map.put("msg", "服务器异常！");
        }
        return map;
    }

    /**
     * 启用索引
     * @return
     */
    @RequestMapping("open_index")
    @ResponseBody
    public Map openIndex() {
        Map map = new HashMap();
        OpenIndexRequest request = new OpenIndexRequest("people");
        try {
            OpenIndexResponse openIndexResponse = client.indices().open(request);
            if (openIndexResponse.isAcknowledged() && openIndexResponse.isShardsAcknowledged()) {
                map.put("state", 200);
                map.put("msg", "索引打开成功！");
            } else {
                map.put("state", 200);
                map.put("msg", "索引打开失败！");
            }
        } catch (IOException e) {
            map.put("state", 500);
            map.put("msg", "服务器异常！");
        }
        return map;
    }

    @RequestMapping("ins_doc1")
    @ResponseBody
    public Map<String, Object> insertDocIndex1() {
        Map<String, Object> map = new HashMap<>();
        IndexRequest request = new IndexRequest("shopping", "doc", "1");
        String jsonString = "{" +
                "\"user\":\"刘志弦\"," +
                "\"postDate\":\"2013-01-30\"," +
                "\"message\":\"trying out Elasticsearch\"" +
                "}";
        request.source(jsonString, XContentType.JSON);
        try {
            IndexResponse indexResponse = client.index(request);
            String index = indexResponse.getIndex();
            String id = indexResponse.getId();
            String type = indexResponse.getType();
            long version = indexResponse.getVersion();
            System.out.println(index + "  " + type + "  " + id + "  " + version);
            if (indexResponse.getResult() == DocWriteResponse.Result.CREATED) {
                map.put("msg", "文档导入成功！");
                map.put("state", 200);
            } else if (indexResponse.getResult() == DocWriteResponse.Result.UPDATED){
                map.put("msg", "文档更新成功！");
                map.put("state", 200);
            }
            ReplicationResponse.ShardInfo shardInfo = indexResponse.getShardInfo();
            if (shardInfo.getTotal() != shardInfo.getSuccessful()) {
                map.put("msg", "处理成功分片数小于总分片数的情况！");
                map.put("state", 200);
            }

            if (shardInfo.getFailed() > 0) {
                String reason = "";
                for (ReplicationResponse.ShardInfo.Failure failure : shardInfo.getFailures()) {
                    reason.concat(failure.reason());
                }
                map.put("msg", reason);
                map.put("state", 400);
            }
        } catch (IOException e) {
            map.put("msg", "服务器异常！");
            map.put("state", 500);
        }
        return map;
    }

    @RequestMapping("get")
    @ResponseBody
    public Map<String, Object> getDoc() {
        Map<String, Object> map = new HashMap<>();
        GetRequest getRequest = new GetRequest("shopping", "doc", "1");
        try {
            GetResponse getResponse = client.get(getRequest);
            if (getResponse.isExists()) {
                Map<String, Object> sourceAsMap = getResponse.getSourceAsMap();
                map.put("state", 200);
                map.put("data", sourceAsMap);
            } else {
                map.put("state", 400);
                map.put("data", "数据不存在");
            }
        } catch (IOException e) {
            map.put("state", 500);
            map.put("data", "服务器异常");
        }
        return map;
    }

}

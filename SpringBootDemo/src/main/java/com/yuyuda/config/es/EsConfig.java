package com.yuyuda.config.es;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EsConfig  {
    //读取配置属性
    @Value("${spring.data.elasticsearch.cluster-nodes}")
    private String clusterNodes;

    @Bean
    public RestHighLevelClient client() {
        //获取主节点host
        String host = clusterNodes.split(":")[0];
        //获取主节点访问端口
        Integer port = Integer.parseInt(clusterNodes.split(":")[1]);
        //实例化RestHighLevelClient，返回
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost(host, port, "http"))
        );
        return client;
    }
}

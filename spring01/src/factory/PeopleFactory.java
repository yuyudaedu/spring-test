package factory;

import com.yuyuda.pojo.People;

public class PeopleFactory {
    public static People newInstance() {
        return new People();
    }
}

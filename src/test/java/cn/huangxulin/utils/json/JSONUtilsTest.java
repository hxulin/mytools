package cn.huangxulin.utils.json;

import cn.huangxulin.utils.json.bean.Address;
import cn.huangxulin.utils.json.bean.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述:
 *
 * @author hxulin
 */
public class JSONUtilsTest {

    private User user = new User(1L, "hxulin", "123456");
    private List<Address> addresses = new ArrayList<Address>();
    private Address a1 = new Address("hxulin's home", "hxulin's school", user);
    private Address a2 = new Address("hxulin's home2", "hxulin's school2", user);

    @Before
    public void init() {
        addresses.add(a1);
        addresses.add(a2);
        user.setAddresses(addresses);
    }


    @Test
    public void test1() {
        // 使用序列化策略可避免对象彼此引用造成无限递归
        SerializationStrategy strategy = SerializationStrategy.include(User.class, "name", "id", "password");
        String jsonText = JSONUtils.toJson(user, strategy);
        System.out.println(jsonText);
    }

    @Test
    public void test2() {
        SerializationStrategy[] strategies = new SerializationStrategy[] {
                SerializationStrategy.include(User.class, "name", "id", "addresses"),
                SerializationStrategy.exclude(Address.class, "user")
        };
        String jsonText = JSONUtils.toJson(user, strategies);
        System.out.println(jsonText);
    }

    @Test
    public void test3() {
        SerializationStrategy[] strategies = new SerializationStrategy[] {
                SerializationStrategy.include(Address.class, "school", "home", "user"),
                SerializationStrategy.exclude(User.class, "addresses", "password")
        };
        System.out.println(JSONUtils.toJson(a1, strategies));
    }

    @Test
    public void test4() {
        SerializationStrategy[] strategies = new SerializationStrategy[] {
                SerializationStrategy.include(Address.class, "school", "home", "user"),
                SerializationStrategy.include(User.class, "id", "name")
        };
        System.out.println(JSONUtils.toJson(a2, strategies));
    }
}

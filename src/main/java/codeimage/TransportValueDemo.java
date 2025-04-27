package codeimage;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class TransportValueDemo {





    public static void main(String[] args) {
        UserDemo user = new UserDemo();
        user.setAge(18);
        user.setSex(1);
        user.setName("张三");
        ;



        System.out.println("字符串修改前:"+ user.toString());
        changeStr(user);
        System.out.println("字符串修改后:"+user.toString());
    }

    private static void changeStr(UserDemo userDemo) {
        userDemo.setAge(22);
        userDemo.setSex(0);
        userDemo.setName("李四");
    }
}
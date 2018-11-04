package com.yuyuda.test;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        String res = (String) listToString(list);
        System.out.println(res);
    }

    public static String listToString(List<Integer> list) {
        if (list == null) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        boolean first = true;
        //第一个前面不拼接","
        for (Integer string : list) {
            if (first) {
                first = false;
            } else {
                result.append("");
            }
            result.append(string);
        }
        return result.toString();
    }
}

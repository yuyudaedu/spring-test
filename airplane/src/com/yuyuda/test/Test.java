package com.yuyuda.test;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        String s[][] = new String[2][];
        s[0] = new String[2];
        s[1] = new String[3];
        s[0][0] = new String("Good");
        s[0][1] = new String("Luck");
        s[1][0] = new String("to");
        s[1][1] = new String("you");
        s[1][2] = new String("!");
        s[0][0] = new String("hello");
        System.out.println(s[0][0]);
    }
}

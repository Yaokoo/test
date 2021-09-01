package com.nio;

import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

/**
 * @author yaokoo
 * @create 2021/8/17 19:05
 */
public class Charset {
    public static void main(String[] args) {
        Map map=java.nio.charset.Charset.availableCharsets();
        Set<Map.Entry<String,Charset>> set=map.entrySet();
        for (Map.Entry<String,Charset> entry:set){
            System.out.println(entry.getKey()+"=="+entry.getValue());
        }
    }
}

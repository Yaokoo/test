package com.test;

public class MainDemo {
    public static void main(String[] args) {
        MyLinkedList list=new MyLinkedList();
        list.add(0,"aaa");
        list.add(1,"bbb");
        list.update("aaa","ccc");
        System.out.println("bbb");
        System.out.println(list.getSize());
        list.display();
    }
}

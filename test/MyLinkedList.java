package com.test;


public class MyLinkedList<T>{

    public static class ListNode<T>{
        public T date;
        public ListNode<T> next;

        public ListNode(){}

        public ListNode(T date){
            this.date=date;
        }
    }

    private ListNode<T> head;
    private ListNode<T> tail;
    private int size=0;

    public MyLinkedList(){
        head=null;
        tail=null;
        size=0;
    }
    //------------------------------------
    //增
    public void add(int position,T date){
        if (position>size){
            return;
        }
        ListNode<T> newNode=new ListNode<>(date);
        if(position==0){
            newNode.next=head;
            head=newNode;
            if (tail==null){
                tail=newNode;
            }
            size++;
        }else if(position==size){
            if (tail==null){
                tail=newNode;
            }else {
                tail.next=newNode;
                tail=newNode;
            }
            size++;
        }else {
            ListNode<T> prev=head;
            for (int i=0;i<position-1;i++){
                prev=prev.next;
            }
            ListNode<T> current=prev.next;
            newNode.next=current;
            current=newNode;
            size++;
        }
    }
    //删
    public void delete(T date){
        //如果删除的是第一个节点
        if (head!=null&&head.date==date){
            head=head.next;
            size--;
            if(size==0){
                tail=head;
            }
        }else{
            ListNode<T> prev=head;
            ListNode<T> cur=head;
            while (prev!=null&&cur!=null){
                if(cur==tail) {
                    tail=prev;
                }
                prev.next=cur.next;
                size--;
                return;
            }
            prev=cur;
            cur=cur.next;
        }
    }

    //查找
    public int search(T date){
        ListNode<T> cur=head;
        for(int index=0;cur!=null;index++){
            if(cur.date==date){
                return index;
            }
            cur=cur.next;
        }
        return -1;
    }
    //改
    public void update(T oldDate,T newDate){
        ListNode<T> cur=head;
        for (int index=0;cur!=null;index++){
            if(cur.date==oldDate){
                cur.date=newDate;
            }
            cur=cur.next;
        }
    }


    public void display(){
        ListNode<T> cur=head;
        while (cur!=null){
            T value=cur.date;
            System.out.print(cur.date+"\t");
            cur=cur.next;
        }
    }
    public int getSize(){
        return size;
    }

}

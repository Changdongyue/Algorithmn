package com.nchu.primary.day04;
//单向链表实现栈
public class Code03_MyStack {
        public static class Node<T>{
            private T value;
            private Node<T> next;
            public Node(T val){
                value = val;
                next = null;
            }
        }
        public static class MyStack<T>{
            private int size;
            private Node<T> head;
            public MyStack(){
                size = 0;
                head = null;
            }
            public boolean isEmpty(){
                return size==0 ;
            }
            public int size(){
                return size;
            }
            //返回栈的栈顶元素
            public T peek(){
                if(head == null){
                    return null;
                }else {
                    return head.value;
                }
            }
            //删除栈顶元素并返回
            public T pool(){
                T res;
                if(head == null){
                   res = null;
                }else{
                    res = head.value;
                    head = head.next;
                    size--;
                }
                return res;
            }
            //压栈
            public void offer(T t){
                Node<T> node = new Node<>(t);
                if(head == null){
                    head = node;
                }else{
                    node.next = head;
                    head = node;
                }
                size++;
            }

        }

    public static void main(String[] args) {
        MyStack<Object> stack = new MyStack<>();
        stack.offer(1);
        stack.offer(2);
        stack.offer(3);
        System.out.println("栈的元素个数："+stack.size());
        System.out.println("删除栈顶元素："+stack.pool());
        System.out.println("栈的元素个数："+stack.size());
    }
}

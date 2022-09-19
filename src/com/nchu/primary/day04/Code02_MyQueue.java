package com.nchu.primary.day04;

//单向链表实现队列
public class Code02_MyQueue {
    public static class Node<T> {
         T value;
         Node<T> next;

        public Node(T val) {
            value = val;
            next = null;
        }
    }

    public static class MyQueue<T> {
       private  int size;
       private  Node<T> head;
       private  Node<T> tail;

        public MyQueue() {
            size = 0;
        }
        public int size(){
            return size;
        }
        public boolean isEmpty(){
            return size==0;
        }
        //val进入队列中
        public  void offer(T val) {
            Node<T> node = new Node<T>(val);
            //当前队列是空的
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
            size++;
        }

        //获取队列的头元素，但不删除出队列
        public  T peek( ) {
            if (head == null) {
                return null;
            }
            return head.value;
        }

        //出队,返回删除的元素
        public T poll( ) {
            T res ;
            if (head == null) {
               res = null;
            } else if (head == tail) {
                res = head.value;
                head = null;
                tail = null;
            } else {
                res = head.value;
                head = head.next;
            }
            size--;
            return res;
        }
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue<>();
        myQueue.offer(1.2);
        myQueue.offer(2.5);
        myQueue.offer(3.6);
        System.out.println("队列中元素的个数："+myQueue.size());
        System.out.println("队列是否为空："+myQueue.isEmpty());
        System.out.println("=============");
        System.out.println("删除第一个元素:"+myQueue.poll());
        System.out.println("删除第二个元素:"+myQueue.poll());
        System.out.println("删除第三个元素:"+myQueue.poll());
        System.out.println("=============");
        System.out.println("剩余的元素个数："+myQueue.size());
        System.out.println("队列是否为空："+myQueue.isEmpty());
    }

}

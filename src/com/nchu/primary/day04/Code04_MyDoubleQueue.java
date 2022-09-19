package com.nchu.primary.day04;

//双向链表实现双端队列
public class Code04_MyDoubleQueue {
    public static class DoubleLinkedList<T> {
        private T value;
        private DoubleLinkedList<T> pre;
        private DoubleLinkedList<T> next;

        public DoubleLinkedList(T val) {
            value = val;
            pre = null;
            next = null;
        }
    }

    public static class MyDoubleQueue<T> {
        private int size;
        private DoubleLinkedList<T> head;
        private DoubleLinkedList<T> tail;

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        //从头部添加元素
        public void addWitHead(T val) {
            DoubleLinkedList node = new DoubleLinkedList(val);
            if (head == null) {
                head = node;
                tail = node;
            } else {
                node.next = head;
                head.pre = node;
                head = node;
            }
            size++;
        }

        //从tail添加
        public void addWithTail(T val) {

            DoubleLinkedList node = new DoubleLinkedList(val);
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail.next.pre = tail;
                tail = node;
            }
            size++;
        }

        //从head删除
        public T delWithHead() {
            T res;
            if (head == null) {
                res = null;
            } else if (head == tail) {
                res = head.value;
                head = tail = null;
                size--;
            } else {
                res = head.value;
                head = head.next;
                head.pre = null;
                size--;
            }
            return res;
        }
        //从tail删除
        public T delWithTail(){
            T res;
            if (head == null) {
                res = null;
            } else if (head == tail) {
                res = head.value;
                head = tail = null;
                size--;
            } else {
                res = tail.value;
                tail = tail.pre;
                tail.next = null;
                size--;
            }
            return res;
        }

    }

    public static void main(String[] args) {
        MyDoubleQueue<Integer> doubleQueue = new MyDoubleQueue<>();
        doubleQueue.addWitHead(1);
        doubleQueue.addWitHead(2);
        doubleQueue.addWitHead(3);
        System.out.println(doubleQueue.delWithHead());
        System.out.println(doubleQueue.delWithHead());
        System.out.println(doubleQueue.delWithHead());
    }
}

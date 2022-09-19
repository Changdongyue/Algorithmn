package com.nchu.primary.day04;
//反转单向链表和双向链表
public class Code01_ReverseList {
    public static class Node {
        public int value;
        public Node next;
        public Node(int data) {
            value = data;
        }
    }
    public static class DoubleNode{
        public int value;
        public DoubleNode pre;
        public DoubleNode next;
        public DoubleNode(int val){
            value = val;
        }
    }
    // for test
    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        Node node1 = reverseList(node);
        while (node1 != null) {
            System.out.print(node1.value);
            node1 = node1.next;
        }
        System.out.println();
        DoubleNode DoubleNode = new DoubleNode(1);
        DoubleNode.next = new DoubleNode(2);
        DoubleNode.next.next = new DoubleNode(3);
        DoubleNode doubleNode1 = reverseDoubleList(DoubleNode);
        while (doubleNode1 != null) {
            System.out.print(doubleNode1.value);
            doubleNode1 = doubleNode1.next;
        }
    }
    //反转单向链表
    public static Node reverseList(Node node) {
        Node pre = null;
        Node next;
        while (node != null) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }
    //反转双向链表
    public static DoubleNode reverseDoubleList(DoubleNode cur){
        DoubleNode pre = null;
        DoubleNode next;
        while(cur != null){
            next = cur.next;
            cur.next = pre;
            cur.pre = next;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}

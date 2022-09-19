package com.nchu.primary.day04;
//合并两个有序链表
public class Code07_MergeTwoList {
    public static class ListNode{
        int value;
        ListNode next;
        public ListNode(int val){
            value = val;
        }
    }
    public static ListNode mergeTwoList(ListNode l1,ListNode l2){
        if(l1 == null || l2 == null){
            return (l1 == null) ? l2 : l1;
        }
        //指向两个链表中首元素中小的一个
        ListNode head = l1.value < l2.value ? l1 : l2;
        ListNode res = head;
        //指向大链表的第一个
        ListNode cur1 = (head == l1) ? l2 : l1;
        //指向小链表的下一个数据
        ListNode cur2 = head.next;
        while(cur1 != null && cur2 != null){
            if(cur1.value <= cur2.value){
                head.next = cur1;
                cur1 = cur1.next;
            }else{
                head.next = cur2;
                cur2 = cur2.next;
            }
            head = head.next;

        }
        head.next = (cur1 == null)? cur2 :cur1;
        return res;
    }
    //打印链表元素
    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.value+" ");
            node = node.next;
        }
        System.out.println();
    }

    //生成一个长度为length的链表长度大于等于1
    public static ListNode getList(int length) {
        ListNode head = new ListNode(1);
        ListNode res = head;
        for (int i = 1; i < length; i++) {
            ListNode listNode = new ListNode(i + 1);
            head.next = listNode;
            head = listNode;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode list = getList(4);
        ListNode list1 = getList(4);
        printList(list);
        printList(list1);
        ListNode listNode = mergeTwoList(list1, list);
        printList(listNode);
    }
}

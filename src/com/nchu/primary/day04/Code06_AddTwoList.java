package com.nchu.primary.day04;
/*
    两个链表相加 1—>2->3 和 2->2>4->8  ==》  3->4->7->1->1
    解：首先计算长短链表，分三种情况，短和长都有数据，短没有长有，短长都没有数据
 */

public class Code06_AddTwoList {
    public static class ListNode {
        private int value;
        private ListNode next;
        public ListNode(int val) {
            value = val;
        }
    }

    public static ListNode addList(ListNode l1, ListNode l2) {
        //ll是长链表 ss是短链表
        ListNode ll = getListSize(l1) >= getListSize(l2) ? l1 : l2;
        ListNode ss = (ll == l1) ? l2 : l1;
        //记录ll的最后一个节点，用于连接最后的进位使用
        ListNode preLl = ll;
        ListNode res = ll;
        //如果存在空链表，直接返回不为空的链表即可
        if (l1 == null || l2 == null) {
            return (l1 == null) ? l2 : l1;
        }
        //短长都存在元素
        int carry = 0;
        int sum;
        while (ss != null) {
            sum = ss.value + ll.value + carry;
            ll.value = sum % 10;
            carry = sum / 10;
            preLl = ll;
            ll = ll.next;
            ss = ss.next;
        }
        while (ll != null) {
            sum = ll.value + carry;
            ll.value = sum % 10;
            carry = sum / 10;
            preLl = ll;
            ll = ll.next;
        }
        if (carry != 0) {
            ListNode listNode = new ListNode(carry);
            preLl.next = listNode;
        }
        return res;
    }

    //获取链表的长度
    public static int getListSize(ListNode node) {
        int res = 0;
        while (node != null) {
            res++;
            node = node.next;
        }
        return res;
    }

    //打印链表元素
    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.value);
            node = node.next;
        }
        System.out.println();
    }

    //生成一个长度为length的链表
    public static ListNode getList(int length) {
        ListNode head = new ListNode(9);
        ListNode res = head;
        for (int i = 1; i < length; i++) {
            ListNode listNode = new ListNode(i + 6);
            head.next = listNode;
            head = listNode;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode list = getList(3);
        ListNode list1 = getList(4);
        printList(list);
        printList(list1);
        ListNode listNode = addList(list, list1);
        printList(listNode);
    }
}

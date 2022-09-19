package com.nchu.primary.day04;

//实现链表在大小为k的组内反转
// 测试链接：https://leetcode.com/problems/reverse-nodes-in-k-group/
public class Code05_ReverseNodesInKGroup {

    public static class ListNode {
        private int value;
        private ListNode next;

        public ListNode(int val) {
            value = val;
        }
    }

    //反转begin到end之间的链表
    public static void reverseList(ListNode begin, ListNode end) {
        ListNode pre = null;
        ListNode next;
        ListNode cur = begin;
        end = end.next;
        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        begin.next = end;
    }

    //获得一个组的最后一个元素
    public static ListNode getKGroupEnd(ListNode start, int k) {
        while (--k != 0 && start != null) {
            start = start.next;
        }
        return start;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head;
        ListNode end = getKGroupEnd(start, k);
        if (end == null) {
            return head;
        }
        //第一组凑齐了
        head = end;
        reverseList(start, end);
        //上一组的尾节点
        ListNode lastNode = start;
        while (lastNode.next != null) {
            start = lastNode.next;
            end = getKGroupEnd(start, k);
            if (end == null) {
                return head;
            }
            reverseList(start, end);
            lastNode.next = end;
            lastNode = start;
        }
        return head;
    }
}

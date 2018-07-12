package com;


/**
 * Decription:
 *
 * @author WangQiuWei
 * @since 2018/5/3
 */
public class ReverseList {
    public static class Node {
        int value;
        Node next;

        Node(int value){
            this.value = value;
        }
    }

    private static Node reverse(Node head) {
        //TODO:
        if (head == null || head.next == null){
            return head;
        }
        Node pre = null;
        Node next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);

        Node result = reverse(node);
        System.out.println(result.value);
        while (result.next!= null){
            System.out.println(result.next.value);
            result.next = result.next.next;
        }
    }
}

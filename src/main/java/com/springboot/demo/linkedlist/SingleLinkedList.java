package com.springboot.demo.linkedlist;

import org.springframework.messaging.handler.annotation.Header;

/**
 * description 删除时要考虑：只有一个结点时；有多个结点时
 *
 * @author gangping.liu <gangping.liu@ucarinc.com>
 * @version V1.0.0
 * @date 2019-10-22 16:33:52
 * @since 1.0
 */
public class SingleLinkedList {
    private int size;
    private Node head;

    public SingleLinkedList() {
        size = 0;
        head = null;
    }

    private class Node {
        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
        }
    }

    public Object addHead(Object data) {
        Node newHead = new Node(data);
        if (size == 0) {
            head = newHead;
        } else {
            newHead.next = head;
            head = newHead;
        }
        size++;
        return data;
    }

    public Object deleteHead() {
        if (size == 0) {
            System.out.println("链表为空，不能删除");
            return null;
        }
        Object data = head.data;
        head = head.next;
        size--;
        return data;
    }

    public Node find(Object data) {
        Node current = head;
        int tempSize = size;
        while (tempSize > 0) {
            if (data.equals(current.data)) {
                return current;
            } else {
                current = current.next;
            }
            tempSize--;
        }
        return null;
    }

    public boolean delete(Object data) {
        if (size == 0) {
            System.out.println("链表为空，不能删除");
            return false;
        }

        Node current = head;
        Node previous = head;
        int tempSize = size;
        while (tempSize > 0) {
            if (data.equals(current.data)) {
                previous.next = current.next;
                size --;
                return true;
            } else {
                previous = current;
                current = current.next;
            }
            tempSize --;
        }
        return false;
    }

    public void display() {
        if (size <= 0) {
            System.out.println("[]");
            return;
        }

        Node node = head;
        int tempSize = size;

        if (tempSize == 1) {
            System.out.println("[" + node.data + "]");
            return ;
        }

        while (tempSize > 0) {
            if (node.equals(head)) {
                System.out.print("[" + node.data + "->");
            } else if (node.next == null) {
                System.out.print(node.data + "]");
            } else {
                System.out.print(node.data + "->");
            }
            node = node.next;
            tempSize--;
        }
        System.out.println();
    }

    public Node reverse() {
        if (size == 0 || size == 1) {
            return head;
        }

        Node current = head;
        Node previous = null;
        Node temp;
        int tempSize = size;
        while (tempSize > 0) {
            temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
            tempSize --;
        }
        head = previous;
        return head;
    }

    public Node reverseBetween(int m, int n) {
        Node cur = head;
        Node pre = null;
        Node temp;
        int curNum = 0;
        while(cur != null) {
            curNum ++;
            while (curNum > m && curNum < n) {
                temp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = temp;
                curNum ++;
            }
            pre = cur;
            cur = cur.next;
        }
        return head;
    }

    public boolean isEmpty() {
        return size <= 0;
    }

    public static void main(String[] args) {
        SingleLinkedList singleList = new SingleLinkedList();
        singleList.addHead("A");
        singleList.addHead("B");
        singleList.addHead("C");
        singleList.addHead("D");
        singleList.addHead("E");
        singleList.reverseBetween(2, 4);
        singleList.display();
    }
}

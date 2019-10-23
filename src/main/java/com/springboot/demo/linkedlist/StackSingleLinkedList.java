package com.springboot.demo.linkedlist;

/**
 * description
 *
 * @author gangping.liu <gangping.liu@ucarinc.com>
 * @version V1.0.0
 * @date 2019-10-22 17:44:54
 * @since 1.0
 */
public class StackSingleLinkedList {
    private SingleLinkedList singleLinkedList;

    public StackSingleLinkedList() {
        singleLinkedList = new SingleLinkedList();
    }

    public void push(Object data) {
        singleLinkedList.addHead(data);
    }

    public Object pop() {
        return singleLinkedList.deleteHead();
    }

    public boolean isEmpty() {
        return singleLinkedList.isEmpty();
    }

    public void display() {
        singleLinkedList.display();
    }

    public static void main(String[] args) {
        StackSingleLinkedList stack = new StackSingleLinkedList();
        stack.push("hello");
        stack.push("world");
        stack.push("!");
        stack.display();

        System.out.println(stack.pop());

        stack.display();
    }
}

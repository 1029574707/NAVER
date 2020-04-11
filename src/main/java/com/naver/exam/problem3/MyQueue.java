package com.naver.exam.problem3;

/**
 * CreateDate：2020/4/11 <br/>
 * Author：WangHao <br/>
 * Description:
 **/
public class MyQueue {

    private int[] elements;

    private int elementsCount;

    private static final int DEFAULT_SIZE = 10;

    /**
     * constructor with given capacity
     *
     * @param capacity
     */
    public MyQueue(int capacity) {
        this.elements = new int[capacity];
    }

    public MyQueue() {
        this.elements = new int[DEFAULT_SIZE];
    }

    public void push(int element) {
        // judge if element count beyond elements' length
        if (elementsCount + 1 > elements.length) {
            // expansion
            int[] temp = new int[elements.length * 2];
            System.arraycopy(elements, 0, temp, 0, elements.length);
            elements = temp;
        }
        elements[elementsCount++] = element;
    }

    public int pop() {
        // no element in queue
        if (elementsCount == 0) {
            throw new NullPointerException();
        }
        // needn't remove element, will cover by push
        return elements[--elementsCount];
    }

    public int peek() {
        // only return, not change elementCount
        return elements[elementsCount - 1];
    }

    public boolean empty() {
        return elementsCount == 0;
    }
}

package com.naver.exam.problem3;

import org.junit.Test;

/**
 * CreateDate：2020/4/11 <br/>
 * Author：WangHao <br/>
 * Description:
 **/
public class QueueTest {

    @Test
    public void testQueue() {
        MyQueue queue = new MyQueue();
        for (int i = 0; i < 15; i++) {
            queue.push(i);
        }
        for (int i = 0; i < 5; i++) {
            System.out.print(queue.peek() + " ");
        }
        System.out.println();
        while (!queue.empty()) {
            System.out.print(queue.pop() + " ");
        }
    }
}

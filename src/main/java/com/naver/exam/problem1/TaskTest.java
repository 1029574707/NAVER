package com.naver.exam.problem1;

import org.junit.Test;

/**
 * CreateDate：2020/4/11 <br/>
 * Author：WangHao <br/>
 * Description:
 **/
public class TaskTest {

    @Test
    public void testTask() {
        TaskPool taskPool = new TaskPool();
        Task taskA = new Task("Task A", 0);
        Task taskB = new Task("Task B", 0);
        Task taskC = new Task("Task C", 0);
        Task taskD = new Task("Task D", 0);
        Task taskE = new Task("Task E", 0);
        Task taskF = new Task("Task F", 0);
        Task taskG = new Task("Task G", 0);
        Task taskH = new Task("Task H", 0);
        taskPool.addTask(taskA);
        taskPool.addTask(taskB);
        taskPool.addTask(taskC);
        taskPool.addTask(taskD);
        taskPool.addTask(taskE);
        taskPool.addTask(taskF);
        taskPool.addTask(taskG);
        taskPool.addTask(taskH);

        taskPool.addDependency(taskA, taskC);
        taskPool.addDependency(taskA, taskG);
        taskPool.addDependency(taskG, taskB);
        taskPool.addDependency(taskE, taskG);
        taskPool.addDependency(taskE, taskB);
        taskPool.addDependency(taskD, taskA);
        taskPool.addDependency(taskF, taskE);
        taskPool.addDependency(taskF, taskD);

        TaskExecutor taskExecutor = new TaskExecutor();
        taskExecutor.execution(taskPool);
    }
}

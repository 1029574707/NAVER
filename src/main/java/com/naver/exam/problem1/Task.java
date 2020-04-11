package com.naver.exam.problem1;

/**
 * CreateDate：2020/4/11 <br/>
 * Author：WangHao <br/>
 * Description:
 **/
public class Task {

    /** task name */
    private String name;

    /** task state, 0 for hasn't execute, 1 for has execute */
    private int state;

    public Task(String name, int state) {
        this.name = name;
        this.state = state;
    }

    /**
     * if task is done
     *
     * @return true - done, has executed; false - hasn't execute
     */
    public boolean isDone() {
        return this.state == 1;
    }

    /**
     * execute task
     */
    public void execute() {
        this.state = 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}

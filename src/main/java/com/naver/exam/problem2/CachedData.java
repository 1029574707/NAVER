package com.naver.exam.problem2;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * CreateDate：2020/4/11 <br/>
 * Author：WangHao <br/>
 * Description:
 **/
public class CachedData {

    private TestData data;
    volatile boolean cacheValid;
    final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    public void processCachedData() {
        rwl.readLock().lock();
        if (!cacheValid) {
            System.out.println(data.getName() + " is not valid, get new data");
            rwl.readLock().unlock();
            rwl.writeLock().lock();
            try {
                if (!cacheValid) {
                    setData();
                    System.out.println("get new data: " + data);
                }
                rwl.readLock().lock();
            } finally {
                rwl.writeLock().unlock();
            }
        }

        try {
            use(data);
        } finally {
            rwl.readLock().unlock();
        }
    }

    public void invalid() {
        this.cacheValid = false;
    }

    public void setData() {
        data = DataSource.newData();
        cacheValid = true;
    }

    private void use(TestData data) {
        System.out.println("use data:" + data.toString());
    }
}

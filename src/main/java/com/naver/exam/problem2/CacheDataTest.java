package com.naver.exam.problem2;

import org.junit.Test;

/**
 * CreateDate：2020/4/11 <br/>
 * Author：WangHao <br/>
 * Description:
 **/
public class CacheDataTest {

    @Test
    public void testCacheData() {
        CachedData cachedData = new CachedData();
        cachedData.setData();

        Thread invalidThread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(700);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                cachedData.invalid();
            }
        });
        invalidThread.start();

        while (true) {
            cachedData.processCachedData();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

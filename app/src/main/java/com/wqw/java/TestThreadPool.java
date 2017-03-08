package com.wqw.java;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池特性测试
 *
 * @author WangQiuWei
 * @since 2017/3/7
 */
public class TestThreadPool {

    public static void main(String[] args) {

        final ExecutorService executor = Executors.newCachedThreadPool();
        //final ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 10; ++i) {
            final int j = i;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(j + " currThread is " + Thread.currentThread());
                }
            });
        }

        final Timer time = new Timer();
        time.schedule(new TimerTask() {
            @Override
            public void run() {
                for (int i = 10; i < 20; ++i) {
                    final int j = i;
                    executor.execute(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println(j + " currThread is " + Thread.currentThread());
                        }
                    });
                }

//                System.out.println("timer run");
//                List<Runnable> runnables = executor.shutdownNow();
//                System.out.println("runnable size " + runnables.size());
//                System.gc();
            }
        }, 1000);
    }
}

package com.example.juslt.retorfitdemo.thread;

import java.util.List;
import java.util.concurrent.*;

/**
 * Created by Juslt on 2019/8/5
 */
public class ThreadExe {
    public static void main(String[] args) {

//        //核心线程数，最大线程数量，keepAliveTime，TimeUnit,
//
//        ThreadPoolExecutor excuter = new ThreadPoolExecutor(2,
//                10,
//                10,
//                TimeUnit.SECONDS,
//                new LinkedBlockingQueue());


        //线程如何捕获异常
//       Thread thread = new Thread(()->{
//           System.out.println("执行任务");
//           Integer.parseInt("TT");
//       });
//       thread.setUncaughtExceptionHandler((t, e) -> {
//           System.out.println("我捕获到了线程池的异常");
//           System.out.println(e.toString());
//       });
//       thread.start();

        //线程池如何捕获异常

        MyThreadFactory factory = new MyThreadFactory();
        ExecutorService executorService = Executors.newCachedThreadPool(factory);
        Future future = executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("执行任务");
                Integer.parseInt("TT");
            }
        });
        executorService.shutdownNow();
        try {
            Object o = future.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class MyThreadFactory implements ThreadFactory {

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                @Override
                public void uncaughtException(Thread t, Throwable e) {
                    System.out.println("我捕获到了线程池的异常");
                    System.out.println(e.toString());
                }
            });
            System.out.println("thread create:" + thread.getName());
            return thread;
        }
    }
}

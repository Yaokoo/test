package io.four;

import java.util.concurrent.*;

public class HandlerSocketServerPool {
    //1.创建一个线程池的成员变量用于储存一个线程池对象
    private ExecutorService executorService;
    //2.初始化线程池对象
   /* public ThreadPoolExecutor(int corePoolSize,
                              int maximumPoolSize,
                              long keepAliveTime,
                              TimeUnit unit,
                              BlockingQueue<Runnable> workQueue)*/
    public HandlerSocketServerPool(int maxThreadNums,int queueSize){
        executorService=new ThreadPoolExecutor(3,maxThreadNums,120,
                TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(queueSize));
    }
    //3.提供一个方法提交任务给线程池的任务队列
    public void execute(Runnable target){
        executorService.execute(target);
    }
}

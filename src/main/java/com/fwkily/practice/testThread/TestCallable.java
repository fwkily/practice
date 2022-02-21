package com.fwkily.practice.testThread;

import java.util.concurrent.*;

/**
 * 创建线程方式三，实现callable接口，重写call方法，创建服务，提交服务，获取结果
 * 好处：
 * 1。可以定义返回值
 * 2.可以抛出异常
 */
public class TestCallable implements Callable<Boolean> {

    private String url;

    private String fileName;

    public TestCallable(String url,String fileName){
        this.url = url;
        this.fileName = fileName;
    }


    @Override
    public Boolean call() throws Exception {

        WebDownLoader webDownLoader = new WebDownLoader();
        webDownLoader.downloader(url,fileName);
        System.out.println("图片下载完成！" + fileName);
        return true;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1 = new TestCallable("https://images.unsplash.com/photo-1628033892645-25983849cdaa?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80", "1.jpg");
        TestCallable t2 = new TestCallable("https://images.unsplash.com/photo-1627662057126-c963095e1db5?ixid=MnwxMjA3fDF8MHxlZGl0b3JpYWwtZmVlZHwxfHx8ZW58MHx8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60", "2.jpg");
        TestCallable t3 = new TestCallable("https://images.unsplash.com/photo-1628067630818-fa3e19d96b27?ixid=MnwxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHw0fHx8ZW58MHx8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60", "3.jpg");

        //创建服务
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        //提交服务
        Future<Boolean> rs1 = executorService.submit(t1);
        Future<Boolean> rs2 = executorService.submit(t2);
        Future<Boolean> rs3 = executorService.submit(t3);

        //获取结果
        Boolean res1 = rs1.get();
        Boolean res2 = rs2.get();
        Boolean res3 = rs3.get();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);

        //关闭服务
        executorService.shutdown();

    }


}



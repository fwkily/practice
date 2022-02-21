package com.fwkily.practice.testThread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * 多线程下载图片
 */
public class Thread1 implements Runnable {

    private String url;

    private String fileName;

    public Thread1(String url,String fileName){
        this.url = url;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        WebDownLoader webDownLoader = new WebDownLoader();
        webDownLoader.downloader(url,fileName);
        System.out.println("图片下载完成！" + fileName);
    }

    public static void main(String[] args) {
        Thread1 t1 = new Thread1("https://images.unsplash.com/photo-1628033892645-25983849cdaa?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80", "1.jpg");
        Thread1 t2 = new Thread1("https://images.unsplash.com/photo-1627662057126-c963095e1db5?ixid=MnwxMjA3fDF8MHxlZGl0b3JpYWwtZmVlZHwxfHx8ZW58MHx8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60", "2.jpg");
        Thread1 t3 = new Thread1("https://images.unsplash.com/photo-1628067630818-fa3e19d96b27?ixid=MnwxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHw0fHx8ZW58MHx8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60", "3.jpg");
        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();

    }

}

class WebDownLoader{
    public void downloader(String url,String fileName){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常！downloader方法出问题了！");
        }
    }

}

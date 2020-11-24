package org.other;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTest implements Callable {

    private String name;
    public CallableTest(String name){
        this.name = name;
    }
    @Override
    public Object call() throws Exception {
        System.out.println("调用Callable的call()方法进行逻辑处理开始1！");
        System.out.println("调用Callable的call()方法进行逻辑处理开始2！");
        System.out.println("调用Callable的call()方法进行逻辑处理开始3！");
        return name;//call()方法执行完后返回的数据
    }
    public static void main(String[] args) {
        //使用main方法模拟Callable的call()方法的调用
        CallableTest callableTest = new CallableTest("我是阿T");
        ExecutorService executorService = Executors.newCachedThreadPool();
        System.out.println("开始执行call()方法!");
        Future<String> future = executorService.submit(callableTest);
        try {
            System.out.println("这里是为了测试一下程序的执行。");
            System.out.println("调用call()方法返回的结果："+future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


}
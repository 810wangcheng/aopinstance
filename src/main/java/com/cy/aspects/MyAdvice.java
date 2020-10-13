package com.cy.aspects;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;
import java.util.Arrays;

public class MyAdvice {

    //前置通知
    public void before(JoinPoint joinPoint) throws ClassNotFoundException {
        System.out.println("-------------前置通知开始------------");
        String clazzName = joinPoint.getTarget().getClass().getName();
        System.out.println("代理类为："+clazzName);
        String methodName = joinPoint.getSignature().getName();
        System.out.println("增强方法名为："+methodName);
        Object[] args = joinPoint.getArgs();
        System.out.println("传入的参数为："+ Arrays.toString(args));
        Class<?> clazz = Class.forName(clazzName);
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if(method.getName().equals(methodName)){
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == args.length){
                    System.out.println("找到方法，开始处理一些业务！");
                    break;
                }
            }
        }
        System.out.println("-----------前置通知结束-----------");
    }

    //后置通知
    public void afterRunning(){
        System.out.println("----后置通知，发生异常不会调用---");
    }

    //环绕通知
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("-----环绕通知开始-----");
        String clazzName = joinPoint.getTarget().getClass().getName();
        System.out.println("获取到通知类为："+clazzName);
        Object[] args = joinPoint.getArgs();
        System.out.println("传入的参数为："+ Arrays.toString(args));
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("获取增强方法为："+method.getName());
        Class<?>[] parameterTypes = method.getParameterTypes();
        System.out.println("获取方法参数："+parameterTypes.toString());
        System.out.println("-----方法开始执行-----");
        Object proceed = joinPoint.proceed();
        System.out.println("-----方法执行结束-----");
        System.out.println("-------------环绕通知结束---------------");
        return proceed;
    }

    //异常通知
    public void afterException(){
        System.out.println("----执行异常通知，发生异常调用----");
    }

    //最终通知
    public void after(){
        System.out.println("----最终通知----");
    }
}

//package com.magic.common.aspectj;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.springframework.stereotype.Component;
//
///**
// * @author 罗璋||luozhang@cnpc.com.cn
// * Description TODO
// * @version 1.0
// * @ClassName TestAspectJ
// * @date 2020/1/20 15:21
// */
//
//@Aspect
//@Component
//public class TestAspectJ {
//
//    @Pointcut("execution(public * com.magic.service.UserService.*(..))")
//    public void aspect(){
//    }
//
//    @Before("aspect()")
//    public void doBefore(){
//        System.out.println("Before-方法之前");
//    }
//    @After("aspect()")
//    public void after(){
//        System.out.println("after-方法之后");
//    }
//
//    @AfterReturning("aspect()")
//    public void afterReturning(){
//        System.out.println("连接点执行之后执行的通知(返回通知)");
//    }
//
//    @AfterThrowing("aspect()")
//    public void afterThrow(){
//        System.out.println("抛出异常之后");
//    }
//
//    @Around("aspect()")
//    public void around(ProceedingJoinPoint point){
//        try {
//            System.out.println("around-方法之前");
//            point.proceed();
//            System.out.println("around-方法之后");
//        } catch (Throwable throwable) {
//            System.out.println("around-抛出异常之后");
//            throwable.printStackTrace();
//        }
//
//    }
//}

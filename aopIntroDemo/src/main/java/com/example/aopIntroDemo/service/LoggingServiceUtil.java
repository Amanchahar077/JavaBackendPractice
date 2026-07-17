package com.example.aopIntroDemo.service;

public class LoggingServiceUtil {
    public static void logStart(String className, String methodName){
        System.out.println("Initializing -> " + className + " : " + methodName);
    }
    public static void logFinish(String className, String methodName){
        System.out.println("Finishing -> " + className + " : " + methodName);
    }
}

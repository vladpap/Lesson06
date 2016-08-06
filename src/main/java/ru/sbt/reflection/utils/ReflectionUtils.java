package ru.sbt.reflection.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ReflectionUtils {
    public static void printHierarchy(Object o) {
        System.out.println("_________________________________");
        Class<?> clazz = o.getClass();
        while (clazz != null) {
            System.out.println(clazz);
            clazz = clazz.getSuperclass();
        }
    }

    public static List<String> printAllMetod(Object o) {
        List<String> result = new ArrayList<>();
        Class<?> clazz = o.getClass();
        while (clazz != null) {
            Method[] declaredMetod = clazz.getDeclaredMethods();
            for (Method method : declaredMetod) {
                result.add(method.getName());
            }
            clazz = clazz.getSuperclass();
        }
        return result;
    }

    public static void invokeAllGeters(Object o) {
        Class<?> clazz = o.getClass();
        while (clazz != null) {
            Method[] declaretedMetod = clazz.getDeclaredMethods();
            for (Method method : declaretedMetod) {
                if ((method.getName().matches("get[A-Z].+")) &&
                        (method.getParameterCount() == 0) &&
                        (method.getReturnType() != void.class)) {
                    invokeMedos(o, method);
                }
            }
            clazz = clazz.getSuperclass();
        }
    }

    public static void invokeMedos(Object o, Method method) {
        Class<?> clazz = o.getClass();
        method.setAccessible(true);
        try {
            System.out.println(method.invoke(o));
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Error ", e);
        }
    }
}

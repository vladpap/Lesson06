package ru.sbt.reflection;

import ru.sbt.reflection.domain.Person;
import ru.sbt.reflection.utils.ReflectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        List<String> allMetod = new ArrayList<>();
//        allMetod = ReflectionUtils.printAllMetod(new Date());
//        System.out.println(allMetod);
//        System.out.println(allMetod.size());
        ReflectionUtils.invokeAllGeters(new Person("Bob", 21));
        System.out.println("---------------------------------------------");
        ReflectionUtils.invokeAllGeters(new Date());
    }
}
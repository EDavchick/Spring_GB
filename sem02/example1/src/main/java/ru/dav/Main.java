package ru.dav;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.dav.config.ProjectConfig;
import ru.dav.domain.Car;

public class Main {
    public static void main(String[] args) {

    var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

    Car simpleCar = context.getBean(Car.class);

    System.out.println(simpleCar.getModel() + " " + simpleCar.getMade());

    String s = context.getBean(String.class);
    System.out.println(s);

    Integer i = context.getBean(Integer.class);
    System.out.println(i);


    }
}
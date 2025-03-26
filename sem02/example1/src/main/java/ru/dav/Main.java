package ru.dav;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.dav.config.ProjectConfig;
import ru.dav.domain.Car;

public class Main {
    public static void main(String[] args) {

    var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

    Car simpleCar1 = context.getBean("BMW",Car.class);
    Car simpleCar2 = context.getBean(Car.class);


    System.out.println(simpleCar1.getModel() + " " + simpleCar1.getMade());
    System.out.println(simpleCar2.getModel() + " " + simpleCar2.getMade());

    String s = context.getBean(String.class);
    System.out.println(s);

    Integer i = context.getBean(Integer.class);
    System.out.println(i);


    }
}
package ru.dav;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.dav.config.ProjectConfig;
import ru.dav.domain.Car;
import ru.dav.domain.DiselEngine;

public class Main {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Car c = context.getBean(Car.class);
        c.go();
        System.out.println("=========================");

        DiselEngine diselEngine = context.getBean(DiselEngine.class);
    }
}
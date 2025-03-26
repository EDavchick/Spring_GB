package ru.dav;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.dav.config.ProjectConfig;
import ru.dav.domain.Car;
import ru.dav.domain.DiselEngine;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Создан экземпляр GasolinEngine - у нас он @Primary
        // Автомобиль создан - вызывается конструктор
        // Запущен бензиновый двигатель - отработал метод startEngine()


        Car c = context.getBean(Car.class);
        c.go();
        // Запущен бензиновый двигатель
        System.out.println("=========================");

        DiselEngine diselEngine = context.getBean(DiselEngine.class);
        // Создан экземпляр DiselEngine
    }
}
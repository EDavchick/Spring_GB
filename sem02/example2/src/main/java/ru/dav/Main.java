package ru.dav;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.dav.config.ProjectConfig;
import ru.dav.domain.Car;
import ru.dav.domain.Engine;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Автомобиль создан
        // Двигатель создан

        Car c = context.getBean(Car.class);
        Engine e = context.getBean(Engine.class);

        System.out.println(c);
        // Car{model='X1', made='BMW', carEngine=Engine{typeEngine='Oil'}}

        System.out.println(e);
        // Engine{typeEngine='Oil'}
    }
}
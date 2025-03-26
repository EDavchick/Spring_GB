package ru.dav.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.dav.domain.Car;
import ru.dav.domain.Engine;

@Configuration
@ComponentScan(basePackages = "ru.dav.domain")
// аннотация @ComponentScan указывает, где искать данные для создания объекта
public class ProjectConfig {

    // этот код спринг будет игнорировать, т.к. basePackages = "ru.dav.domain"
//    @Bean
//    Engine engine(){
//        Engine eng = new Engine();
//        return eng;
//    }
//
//    @Bean
//    Car car(){
//        Car obCar = new Car();
//        obCar.setModel("S8");
//        obCar.setMade("Audi");
//        obCar.setCarEngine(engine());
//
//        return obCar;
//    }

}

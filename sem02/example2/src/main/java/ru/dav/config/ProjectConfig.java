package ru.dav.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.dav.domain.Car;
import ru.dav.domain.Engine;

@Configuration
@ComponentScan(basePackages = "ru.dav.domain")
public class ProjectConfig {

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

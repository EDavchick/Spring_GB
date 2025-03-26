package ru.dav.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
    private String model = "X1";
    private String made = "BMW";
    @Autowired
    private IEngine carEngine;

    public Car(IEngine engine) {
        this.carEngine = engine;;
        System.out.println("Автомобиль создан");
    }

    public String getMade() {
        return made;
    }

    public void setMade(String made) {
        this.made = made;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public IEngine getCarEngine() {
        return carEngine;
    }

    public void setCarEngine(IEngine carEngine) {
        this.carEngine = carEngine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", made='" + made + '\'' +'}';
    }

    public void go(){
        carEngine.startEngine();
    }
}

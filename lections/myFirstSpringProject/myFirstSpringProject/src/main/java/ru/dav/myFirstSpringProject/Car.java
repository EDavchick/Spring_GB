package ru.dav.myFirstSpringProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Car {
    @Autowired
    EngineProfile engineProfile;

    public void start(){
        engineProfile.go();
    }

    /*
    public Car(Engine engine) {
//        this.engine = engine;
//        engine.go();
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
        engine.go();
    }
     */
}

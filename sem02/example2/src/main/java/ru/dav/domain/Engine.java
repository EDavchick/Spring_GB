package ru.dav.domain;

import org.springframework.stereotype.Component;

@Component
public class Engine {
    private String typeEngine = "Oil";

    public Engine() {
        System.out.println("Двигатель создан");
    }

    public String getTypeEngine() {
        return typeEngine;
    }

    public void setTypeEngine(String typeEngine) {
        this.typeEngine = typeEngine;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "typeEngine='" + typeEngine + '\'' +
                '}';
    }
}

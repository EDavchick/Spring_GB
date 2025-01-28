package ru.dav.domain;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class GasolinEngine implements IEngine{

    public GasolinEngine() {
        System.out.println("Создан экземпляр GasolinEngine");
    }

    @Override
    public void startEngine() {
        System.out.println("Запущен бензиновый двигатель");
    }
}

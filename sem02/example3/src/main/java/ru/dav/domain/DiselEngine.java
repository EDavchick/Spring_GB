package ru.dav.domain;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Lazy
public class DiselEngine implements IEngine{
    public DiselEngine() {
        System.out.println("Создан экземпляр DiselEngine");
    }

    @Override
    public void startEngine() {
        System.out.println("Запущен дизельный двигатель");
    }
}

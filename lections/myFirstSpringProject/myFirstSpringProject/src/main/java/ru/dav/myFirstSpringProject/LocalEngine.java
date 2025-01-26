package ru.dav.myFirstSpringProject;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Primary
@Profile(("local"))
public class LocalEngine implements EngineProfile{
    public LocalEngine() {
        System.out.println("Двигатель запущен на моем ноутбуке");
    }

    public void go(){
        System.out.println("Поехали медленно");
    }
}

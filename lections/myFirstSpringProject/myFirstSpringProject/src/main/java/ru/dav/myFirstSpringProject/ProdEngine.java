package ru.dav.myFirstSpringProject;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile(("prod"))
public class ProdEngine implements EngineProfile{
    public ProdEngine() {
        System.out.println("Двигатель запущен на сервере");
    }

    public void go(){
        System.out.println("Поехали быстро");
    }
}

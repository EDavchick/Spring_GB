package ru.dav;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.dav.config.ProjectConfig;
import ru.dav.services.CommentService;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello, World!");
        var c = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var cs1 = c.getBean("commentService", CommentService.class);
        var cs2 = c.getBean("commentService", CommentService.class);

        boolean b1 = cs1 == cs2;
        System.out.println(b1);
        System.out.println(cs1);
        System.out.println(cs2);
    }
}
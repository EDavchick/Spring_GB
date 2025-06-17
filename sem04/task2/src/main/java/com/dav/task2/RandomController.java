package com.dav.task2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Random;

@Controller
public class RandomController {

    @GetMapping("/random")
    public String random(Model model){
        Random random = new Random();
        model.addAttribute("number", random.nextInt(100) + 1);
        return "random.html";
    }
}

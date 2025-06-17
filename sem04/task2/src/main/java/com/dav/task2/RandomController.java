package com.dav.task2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
public class RandomController {

    @Value("${data.parameter.min:25}")
    private int minDefault;
    @Value("${data.parameter.max:55}")
    private int maxDefault;

//    @GetMapping("/random") // http://localhost:8080/random
//    public String random(Model model){
//        Random random = new Random();
//        model.addAttribute("number", random.nextInt(100) + 1);
//        return "random.html";
//    }

    @GetMapping("/random/{min}/{max}")
    public String random(@PathVariable("min") int min,
                         @PathVariable("max") int max,
                         Model model){
        model.addAttribute("min", min);
        model.addAttribute("max", max);

        model.addAttribute("min_default", minDefault);
        model.addAttribute("max_default", maxDefault);

        model.addAttribute("number",
                new Random().nextInt(min, max + 1));

        model.addAttribute("number_default",
                new Random().nextInt(minDefault, maxDefault + 1));
        return "random";
    }

    // http://localhost:8080/random/25/555
    // http://localhost:8080/random/10/666
    // и т.д.

    @GetMapping("/random")
    public String getRandom(@RequestParam("min") int min,
                         @RequestParam("max") int max,
                         Model model){
        model.addAttribute("min", min);
        model.addAttribute("max", max);

        model.addAttribute("number",
                new Random().nextInt(min, max + 1));
        return "random";
    }

    // http://localhost:8080/random?min=12&max=321
}

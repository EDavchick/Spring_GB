package com.dav.hw04;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/home")
public class FormController {

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String showForm(Model model){
        model.addAttribute("user", new User());
        return "form.html";
    }
    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String submitForm(@ModelAttribute User user, Model model){
        model.addAttribute("message", "Hello, " + user.getName() + "!");
        return "result.html";
    }

}

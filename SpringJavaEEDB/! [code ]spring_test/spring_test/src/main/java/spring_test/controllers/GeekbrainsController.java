package spring_test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import spring_test.conf.SempleClass;
import spring_test.services.UserService;


@Controller
public class GeekbrainsController {
    @Autowired
    UserService service;

    @Autowired
    SempleClass sempleClass;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("users", service.getUsers());
        model.addAttribute("counter", sempleClass.getCounter());
        model.addAttribute("constructorCounter", sempleClass.getConstructorCounter());
        return "index";
    }
}

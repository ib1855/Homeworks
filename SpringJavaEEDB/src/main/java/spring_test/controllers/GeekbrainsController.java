package spring_test.controllers;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring_test.Semple;
import spring_test.services.UserService;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Controller
public class GeekbrainsController {
    @Autowired
    UserService service;


    @RequestMapping("/")
    public String index(
            @RequestParam(value = "str", required = false) String str,
            Model model){
        if (str != null) {
            model.addAttribute("str", str);
        }
        model.addAttribute("users", service.getUsers());
        return "index";
    }




}

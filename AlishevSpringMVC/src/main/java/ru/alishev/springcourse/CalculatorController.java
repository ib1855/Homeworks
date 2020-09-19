package ru.alishev.springcourse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class CalculatorController {

    @GetMapping("/calculator")
    public String calculate(@RequestParam(value = "a", required = false) Integer a,
                            @RequestParam(value = "b", required = false) Integer b,
                            @RequestParam(value = "action", required = false) String action,
                            Model model){
        if (action!=null && a!=null && b!=null){
            Integer result;
            switch (action){
                case "m":
                    result = a * b;
                    model.addAttribute("result", result);
                    break;
                case "a":
                    result = a + b;
                    model.addAttribute("result", result);
                    break;
                case "s":
                    result = a - b;
                    model.addAttribute("result", result);
                    break;
                case "d":
                    result = a/b;
                    model.addAttribute("result", result);
                    break;
                default:
                    model.addAttribute("result", "Error");
            }

        }
        model.addAttribute("result", "No parameters");
        return "CalculationResult";
    }

}

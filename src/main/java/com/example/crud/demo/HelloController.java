package com.example.crud.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

/** 
 * Hello Controller
*/
@Controller
public class HelloController {
    // @RequestMapping("/")
    @GetMapping(value = { "/", "/index" })
    public String index(Model model) {
        model.addAttribute("name", "Syahriza");
        return "index";
    }
}

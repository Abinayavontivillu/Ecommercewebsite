package com.example.product.demoprojectproduct.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MVCController {

    @GetMapping("/bill")
    public String getallbill(Model  model)
    {
        String name="aaa";
        model.addAttribute("name",name);
        return "index";
    }
}

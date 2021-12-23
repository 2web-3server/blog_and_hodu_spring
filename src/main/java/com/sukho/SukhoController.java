package com.sukho;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SukhoController {
    @GetMapping("/sukho")
    public String return_sukho (Model model) {
        return "sukho/index";
    }

    @GetMapping("/sukho/post")
    public String return_post (Model model) {

        model.addAttribute("title","제목이양");
        model.addAttribute("date","지금지금");
        model.addAttribute("contents","내용이지");

        return "sukho/post";
    }


}
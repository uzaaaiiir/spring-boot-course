package com.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    @RequestMapping("/processFormV2")
    public String addToModel(HttpServletRequest request, Model model) {
        // read request parameter
        String name = request.getParameter("studentName");

        name = "Yo! " + name.toUpperCase();

        model.addAttribute("message", name);

        return "helloworld";
    }
}

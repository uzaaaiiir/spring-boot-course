package com.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
    @GetMapping("/showForm")
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

    @PostMapping("/processFormV3")
    public String addToModel(@RequestParam("studentName") String name, Model model) {
        // read request parameter
        name = "Using Request Param: " + name.toUpperCase();

        model.addAttribute("message", name);

        return "helloworld";
    }
}

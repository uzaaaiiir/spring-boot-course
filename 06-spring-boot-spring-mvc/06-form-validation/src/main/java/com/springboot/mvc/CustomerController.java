package com.springboot.mvc;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {
    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("customer", new Customer());

        return "customer-form";
    }

    @InitBinder // Called before the API is called (used to trim input strings)
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @PostMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {
        System.out.println("Last Name: |" + customer.getLastName() + "|");

        System.out.println("Binding Results: " + bindingResult.toString());

        System.out.println("\n\n\n");

        if (bindingResult.hasErrors()) {
            return "customer-form";
        }

        return "customer-confirmation";
    }
}

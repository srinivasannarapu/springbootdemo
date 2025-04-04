package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

    @Autowired
    private DetailsRepository detailsRepository;

    @GetMapping("/webpage")
    public String showForm() {
        return "insert";
    }

    @PostMapping("/save")
    public String saveDetails(@RequestParam String firstname,
                              @RequestParam String lastname,
                              @RequestParam String designation,
                              @RequestParam String address,
                              Model model) {
        Details details = new Details();
        details.setFirstname(firstname);
        details.setLastname(lastname);
        details.setDesignation(designation);
        details.setAddress(address);

        detailsRepository.save(details);

        model.addAttribute("message", "Employee details saved successfully!");
        return "insert";
    }
}

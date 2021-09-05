package com.milab.stfstatus.controller;

import com.milab.stfstatus.entity.Handset;
import com.milab.stfstatus.service.HandsetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    HandsetService handsetService;

    @GetMapping()
    public String showMainPage(Model model) {
        model.addAttribute("mymsg", "HEY");
        return "index";
    }

    @GetMapping("/allhandsets")
    public String showAllHandsets(Model model) {
        List<Handset> allHandsets = handsetService.findAllHandsets();
        model.addAttribute("allHandsets", allHandsets);
        return "allhandsets";
    }

    public void testMethod(){
        System.out.println("-------------------------------");
    }
}

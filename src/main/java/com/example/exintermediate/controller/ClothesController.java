package com.example.exintermediate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.exintermediate.domain.Clothes;
import com.example.exintermediate.service.ClothesService;

@Controller
@RequestMapping("/clothes")
public class ClothesController {

    @Autowired
    private ClothesService clothesService;

    @GetMapping("")
    public String index() {
        return "shop/clothes";

    }

    @GetMapping("/search")
    public String search(Integer gender, String color, Model model) {
        List<Clothes> clotheList = clothesService.search(gender, color);
        model.addAttribute("clotheList", clotheList);
        model.addAttribute("gender", gender);
        model.addAttribute("color", color);
        return "shop/clothes";

    }
}

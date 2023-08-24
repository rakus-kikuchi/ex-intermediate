package com.example.exintermediate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.exintermediate.domain.Hotel;
import com.example.exintermediate.service.HotelService;

@Controller
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService HotelService;

    @GetMapping("")
    public String index() {
        return "/hotel/hotel";
    }

    @GetMapping("/hit")
    public String hit(Integer price, Model model) {
        List<Hotel> hotelList = HotelService.hotelList(price);
        model.addAttribute("price", price);
        model.addAttribute("hotelList", hotelList);
        return "hotel/hotel";
    }

}

package com.example.exintermediate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.exintermediate.domain.Team;
import com.example.exintermediate.service.TeamService;

@Controller
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamService TeamService;

    @GetMapping("/list")
    public String index(Model model) {
        List<Team> teamList = TeamService.findAll();
        model.addAttribute("teamList", teamList);
        return "/baseball/list";
    }

    @GetMapping("/detail")
    public String detail(Integer id, Model model) {
        Team teamDetail = TeamService.teamDetail(id);
        if (teamDetail == null) {
            return "redirect:/error";
        }
        model.addAttribute("teamDetail", teamDetail);

        return "/baseball/detail";
    }
}

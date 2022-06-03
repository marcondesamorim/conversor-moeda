package com.conversor.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.conversor.domain.Cotacao;

@Controller
public class WelcomeController {

    private List<Cotacao> cotacoes = new ArrayList<Cotacao>();

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("cotacoes", cotacoes);

        return "welcome"; // view
    }

    @RequestMapping(value = "/do-stuff")
    public void doStuffMethod() {
        System.out.println("Success");
    }

}

package com.conversor.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.conversor.domain.entities.Conversao;
import com.conversor.services.ConversaoService;

@Controller
public class ConversaoController {

    private final ConversaoService conversaoService;

    public ConversaoController(ConversaoService conversorService) {
        this.conversaoService = conversorService;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String getCotacoes(Model model) {
        List<Conversao> conversoes = conversaoService.getConversoes();
        model.addAttribute("conversoes", conversoes);
        model.addAttribute("conversao", new Conversao());

        return "conversao";
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public RedirectView createConversao(RedirectAttributes redirectAttributes,
            @ModelAttribute Conversao conversao) {
        conversaoService.createConversao(conversao);
        String message = "Conversao" + conversao.getOriginal() + " " + conversao.getConvertido()
                + "</b> ✨.";
        RedirectView redirectView = new RedirectView("/", true);
        redirectAttributes.addFlashAttribute("userMessage", message);
        return redirectView;
    }

    // @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    // public String getUser(Model model, @PathVariable("id") Integer id) {
    // Cotacao cotacao = conversorService.getCotacao(id);
    // model.addAttribute("cotacao", cotacao);
    // return "edit";
    // }

    // @RequestMapping(path = "/{id}", method = RequestMethod.POST)
    // public RedirectView updateCotacao(RedirectAttributes redirectAttributes,
    // @PathVariable("id") Integer id,
    // @ModelAttribute Cotacao cotacao) {
    // conversorService.updateCotacao(id, cotacao);
    // String message = (cotacao != null ? "Updated " : "Deleted ") + " user <b>" +
    // cotacao.getName() + " "
    // + cotacao.getTimestamp() + "</b> ✨.";
    // RedirectView redirectView = new RedirectView("/", true);
    // redirectAttributes.addFlashAttribute("userMessage", message);
    // return redirectView;
    // }

}

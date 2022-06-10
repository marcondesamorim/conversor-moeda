package com.conversor.controllers;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.conversor.Util;
import com.conversor.domain.entities.Conversao;
import com.conversor.domain.entities.Cotacao;
import com.conversor.domain.entities.Moeda;
import com.conversor.services.ConversaoService;
import com.conversor.services.CotacaoAPIService;

@Controller
public class ConversaoController {

    private final ConversaoService conversaoService;
    private final CotacaoAPIService cotacaoAPIService;

    public ConversaoController(ConversaoService conversorService, CotacaoAPIService cotacaoAPIService) {
        this.conversaoService = conversorService;
        this.cotacaoAPIService = cotacaoAPIService;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String getCotacoes(Model model) {
        List<Conversao> conversoes = conversaoService.getConversoes();
        List<Moeda> moedas = Util.inicializaMoedas();
        model.addAttribute("conversoes", conversoes);
        model.addAttribute("conversao", new Conversao());
        model.addAttribute("moedas", moedas);

        return "conversao";
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public RedirectView createConversao(RedirectAttributes redirectAttributes,
            @ModelAttribute Conversao conversao) throws Exception {

        Cotacao cotacao = cotacaoAPIService.pegaCotacao(conversao.getCodigo());

        NumberFormat nf = NumberFormat.getNumberInstance(new Locale("pt", "BR"));

        Float original = nf.parse(conversao.getOriginal()).floatValue();
        Float convertido = original * cotacao.getBid();

        DecimalFormat df = new DecimalFormat("###,###.00");
        df.setRoundingMode(RoundingMode.HALF_UP);

        conversao.setConvertido(df.format(convertido));

        conversaoService.createConversao(conversao);

        String message = "Conversao : " + conversao.getCodigo() + " - Valor original: " + conversao.getOriginal()
                + " - Valor Convertido: " + conversao.getConvertido()
                + "</b> ✨.";
        RedirectView redirectView = new RedirectView("/", true);
        redirectAttributes.addFlashAttribute("userMessage", message);
        return redirectView;
    }
}

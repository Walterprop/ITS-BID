package com.cavaliere.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cavaliere.entities.Domanda;
import com.cavaliere.service.CountryServiceImpl;

import jakarta.servlet.http.HttpSession;

@Controller
public class CountryController {

    @Autowired
    private CountryServiceImpl countryService;

    @GetMapping("/countries")
    public String getCountries(Model m) {
        m.addAttribute("paesi", countryService.getCountries());
        return "paesi";
    }

    @GetMapping("/quiz/start")
    public String startQuiz(@RequestParam String difficolta, Model model, HttpSession session) {
        int numDomande = switch (difficolta) {
            case "facile" -> 10;
            case "medio" -> 20;
            case "difficile" -> 30;
            default -> 10;
        };
        int tempo = switch (difficolta) {
            case "facile" -> 0;
            case "medio" -> 600;
            case "difficile" -> 300;
            default -> 0;
        };
        session.setAttribute("inizioQuiz", System.currentTimeMillis());
        session.setAttribute("tempoTotale", tempo);
        return "redirect:/quiz?numDomande=" + numDomande + "&difficolta=" + difficolta + "&domandaCorrente=1";
    }

    @GetMapping("/quiz")
    public String quiz(
            @RequestParam(defaultValue = "10") int numDomande,
            @RequestParam(defaultValue = "facile") String difficolta,
            @RequestParam(defaultValue = "1") int domandaCorrente,
            HttpSession session,
            Model model) {

        // TIMER GLOBALE: calcola tempo rimasto
        Integer tempoTotale = (Integer) session.getAttribute("tempoTotale");
        Long inizioQuiz = (Long) session.getAttribute("inizioQuiz");
        int tempoRimasto = 0;
        if (tempoTotale != null && inizioQuiz != null && tempoTotale > 0) {
            long elapsed = (System.currentTimeMillis() - inizioQuiz) / 1000;
            tempoRimasto = (int) (tempoTotale - elapsed);
            if (tempoRimasto <= 0) {
                // Quiz finito per timeout
                Integer punteggio = (Integer) session.getAttribute("punteggio");
                model.addAttribute("punteggio", punteggio != null ? punteggio : 0);
                model.addAttribute("numDomande", numDomande);
                model.addAttribute("timeout", true);
                session.removeAttribute("punteggio");
                return "quiz_finito";
            }
        }

        Domanda domanda = countryService.generaDomandaCapitale();
        List<String> opzioni = countryService.getOpzioniMischiate(domanda);
        model.addAttribute("domanda", domanda);
        model.addAttribute("opzioni", opzioni);
        model.addAttribute("numDomande", numDomande);
        model.addAttribute("difficolta", difficolta);
        model.addAttribute("domandaCorrente", domandaCorrente);
        model.addAttribute("tempo", tempoRimasto);
        return "quiz";
    }

    @PostMapping("/quiz/risposta")
    public String verificaRisposta(
            @RequestParam String risposta,
            @RequestParam String corretta,
            @RequestParam int numDomande,
            @RequestParam int domandaCorrente,
            @RequestParam String difficolta,
            Model model,
            HttpSession session) {

        // TIMER GLOBALE: controlla se il tempo è scaduto
        Integer tempoTotale = (Integer) session.getAttribute("tempoTotale");
        Long inizioQuiz = (Long) session.getAttribute("inizioQuiz");
        int tempoRimasto = 0;
        if (tempoTotale != null && inizioQuiz != null && tempoTotale > 0) {
            long elapsed = (System.currentTimeMillis() - inizioQuiz) / 1000;
            tempoRimasto = (int) (tempoTotale - elapsed);
            if (tempoRimasto <= 0) {
                Integer punteggio = (Integer) session.getAttribute("punteggio");
                model.addAttribute("punteggio", punteggio != null ? punteggio : 0);
                model.addAttribute("numDomande", numDomande);
                model.addAttribute("timeout", true);
                session.removeAttribute("punteggio");
                return "quiz_finito";
            }
        }

        // Recupera o inizializza il punteggio
        Integer punteggio = (Integer) session.getAttribute("punteggio");
        if (punteggio == null) punteggio = 0;

        boolean esatta = risposta.equals(corretta);
        if (esatta) punteggio++;

        session.setAttribute("punteggio", punteggio);

        model.addAttribute("esatta", esatta);
        model.addAttribute("risposta", risposta);
        model.addAttribute("corretta", corretta);

        if (domandaCorrente < numDomande) {
            return "redirect:/quiz?numDomande=" + numDomande
                + "&difficolta=" + difficolta
                + "&domandaCorrente=" + (domandaCorrente + 1);
        } else {
            // Quiz finito: passa il punteggio e resetta la sessione
            model.addAttribute("punteggio", punteggio);
            model.addAttribute("numDomande", numDomande);
            session.removeAttribute("punteggio");
            return "quiz_finito";
        }
    }
}
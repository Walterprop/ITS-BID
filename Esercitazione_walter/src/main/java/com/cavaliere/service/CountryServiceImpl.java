package com.cavaliere.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cavaliere.entities.Country;
import com.cavaliere.entities.Domanda;
import com.cavaliere.repos.CountryRepo;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepo countryRepo;

    @Override
    public List<Country> getCountries() {
        return countryRepo.findAll();
    }

    public Domanda generaDomandaCapitale() {
        List<Country> paesi = getCountries();
        if (paesi.size() < 3) return null;
        Random rand = new Random();
        Country corretto = paesi.get(rand.nextInt(paesi.size()));

        Set<String> errate = new HashSet<>();
        while (errate.size() < 2) {
            Country altro = paesi.get(rand.nextInt(paesi.size()));
            if (!altro.getAlpha2Code().equals(corretto.getAlpha2Code()) && altro.getCapital() != null && !altro.getCapital().isEmpty()) {
                errate.add(altro.getCapital());
            }
        }
        List<String> errateList = new ArrayList<>(errate);

    
        return new Domanda(
            "Qual è la capitale di " + corretto.getName() + "?",
            corretto.getCapital(),
            errateList.get(0),
            errateList.get(1),
            corretto.getFlag() 
        );

    }

    public List<String> getOpzioniMischiate(Domanda domanda) {
    List<String> opzioni = new ArrayList<>();
    opzioni.add(domanda.getRispostaCorretta());
    opzioni.add(domanda.getRispostaErrata1());
    opzioni.add(domanda.getRispostaErrata2());
    Collections.shuffle(opzioni);
    return opzioni;
}

    @Override
    public Country getCountryById(String alpha2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCountryById'");
    }

    @Override
    public Country getCountryByRand() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCountryByRand'");
    }
}
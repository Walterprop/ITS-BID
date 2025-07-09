package com.cavaliere.entities;

public class Domanda {
    private String testo;
    private String rispostaCorretta;
    private String rispostaErrata1;
    private String rispostaErrata2;
    private String flag;

    public Domanda() {}

    public Domanda(String testo, String rispostaCorretta, String rispostaErrata1, String rispostaErrata2, String flag) {
        this.testo = testo;
        this.rispostaCorretta = rispostaCorretta;
        this.rispostaErrata1 = rispostaErrata1;
        this.rispostaErrata2 = rispostaErrata2;
        this.flag = flag;
    }

    // Getter e Setter
    public String getTesto() { return testo; }
    public void setTesto(String testo) { this.testo = testo; }
    public String getRispostaCorretta() { return rispostaCorretta; }
    public void setRispostaCorretta(String rispostaCorretta) { this.rispostaCorretta = rispostaCorretta; }
    public String getRispostaErrata1() { return rispostaErrata1; }
    public void setRispostaErrata1(String rispostaErrata1) { this.rispostaErrata1 = rispostaErrata1; }
    public String getRispostaErrata2() { return rispostaErrata2; }
    public void setRispostaErrata2(String rispostaErrata2) { this.rispostaErrata2 = rispostaErrata2; }
    public String getFlag() { return flag; }
    public void setFlag(String flag) { this.flag = flag; }
}



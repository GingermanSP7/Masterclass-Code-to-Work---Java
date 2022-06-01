package Esercizio4;

import java.util.Set;

public class Parola {
    private String parola;
    private Set<String> significato;
    
    Parola(String parola){
        this.parola = parola;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public Set<String> getSignificato() {
        return significato;
    }

    public void setSignificato(Set<String> significato) {
        this.significato = significato;
    }

    public void addSignificato(String sign){
        significato.add(sign);
    }

}

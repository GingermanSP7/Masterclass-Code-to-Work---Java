package Esercizio3;

import java.util.List;

public class Autore implements Comparable<Autore>{
    private Integer codice;
    private String nome;
    private String cognome;
    private List<Libro> l;

    public Autore(Integer codice, String nome, String cognome, List<Libro> l) {
        this.codice = codice;
        this.nome = nome;
        this.cognome = cognome;
        this.l = l;
    }

    public Integer getCodice() {
        return codice;
    }

    public void setCodice(Integer codice) {
        this.codice = codice;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public List<Libro> getL() {
        return l;
    }

    public void setL(List<Libro> l) {
        this.l = l;
    }

    @Override
    public int compareTo(Autore o) {
        if(o.getCodice() < this.getCodice()) return 1;
        else if(o.getCodice() == this.getCodice()) return 0;
        else return 1;
    }  
}

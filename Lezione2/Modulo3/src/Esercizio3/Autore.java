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

    //@Override
    // public int hashCode() {
    //     final int prime = 31;
    //     int result = 1;
    //     result = prime * result + ((codice == null) ? 0 : codice.hashCode());
    //     return result;
    // }

    // @Override
    // public boolean equals(Object obj) {
    //     if (this == obj)
    //         return true;
    //     if (obj == null)
    //         return false;
    //     if (getClass() != obj.getClass())
    //         return false;
    //     Autore other = (Autore) obj;
    //     if (codice == null) {
    //         if (other.codice != null)
    //             return false;
    //     } else if (!codice.equals(other.codice))
    //         return false;
    //     return true;
    // }

    @Override
    public int compareTo(Autore o) {
        if(o.getCodice() < this.getCodice()) return 1;
        else if(o.getCodice() == this.getCodice()) return 0;
        else return 1;
    } 

    
}

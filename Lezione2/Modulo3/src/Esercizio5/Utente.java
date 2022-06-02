package Esercizio5;

import java.util.HashSet;
import java.util.Set;

public class Utente implements Comparable<Utente>{
    private String nome;
    private String cognome;
    private String codice;
    private Set<Interesse> interessi;

    public Utente(String nome, String cognome, String codice) {
        this.nome = nome;
        this.cognome = cognome;
        this.codice = codice;
        interessi = new HashSet<>();
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

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public Set<Interesse> getInteressi() {
        return interessi;
    }

    public void addInteresse(Interesse i){
        interessi.add(i);
    }

    public void setInteressi(Set<Interesse> interessi) {
        this.interessi = interessi;
    }

    public void removeInteressi(){
        interessi.clear();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codice == null) ? 0 : codice.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Utente other = (Utente) obj;
        if (codice == null) {
            if (other.codice != null)
                return false;
        } else if (!codice.equals(other.codice))
            return false;
        return true;
    }

    @Override
    public int compareTo(Utente o) {
        
        return 0;
    }
}

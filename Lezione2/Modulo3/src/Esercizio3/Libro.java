package Esercizio3;

public class Libro {
    private Integer codice;
    private String titolo;
    private Autore autore;
    private String sinossi;

    public Libro(Integer codice, String titolo, Autore autore, String sinossi) {
        this.codice = codice;
        this.titolo = titolo;
        this.autore = autore;
        this.sinossi = sinossi;
    }

    public Integer getCodice() {
        return codice;
    }

    public void setCodice(Integer codice) {
        this.codice = codice;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public Autore getAutore() {
        return autore;
    }

    public void setAutore(Autore autore) {
        this.autore = autore;
    }

    public String getSinossi() {
        return sinossi;
    }

    public void setSinossi(String sinossi) {
        this.sinossi = sinossi;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((autore == null) ? 0 : autore.hashCode());
        result = prime * result + ((codice == null) ? 0 : codice.hashCode());
        result = prime * result + ((titolo == null) ? 0 : titolo.hashCode());
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
        Libro other = (Libro) obj;
        if (autore == null) {
            if (other.autore != null)
                return false;
        } else if (!autore.equals(other.autore))
            return false;
        if (codice == null) {
            if (other.codice != null)
                return false;
        } else if (!codice.equals(other.codice))
            return false;
        if (titolo == null) {
            if (other.titolo != null)
                return false;
        } else if (!titolo.equals(other.titolo))
            return false;
        return true;
    }

    
    
}

package Esercizio5;

public class Interesse{
    private String codice;
    private String testo;
    
    public Interesse(String codice, String testo) {
        this.codice = codice;
        this.testo = testo;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
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
        Interesse other = (Interesse) obj;
        if (codice == null) {
            if (other.codice != null)
                return false;
        } else if (!codice.equals(other.codice))
            return false;
        return true;
    }

    
}

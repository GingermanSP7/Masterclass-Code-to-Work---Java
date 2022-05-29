package Lezione_1.Modulo2.src.Esercizio3.gest_Prenotazioni;

public class Prenotazione {
    private String codice;
    private int n_posti;

    Prenotazione(String codice, int n_posti){
        this.codice = codice;
        this.n_posti = n_posti;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public int getnPosti(){
        return n_posti;
    }
}

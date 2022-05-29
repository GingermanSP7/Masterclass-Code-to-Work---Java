package Lezione_1.Modulo2.src.Esercizio3.gest_Prenotazioni;

public class PrenotazioneGruppo extends Prenotazione{
    private int posti_ris;

    PrenotazioneGruppo(String codice,int posti_ris) {
        super(codice,posti_ris);
        this.posti_ris = posti_ris;
    }

    public int getPosti_ris() {
        return posti_ris;
    }

    public void setPosti_ris(int posti_ris) {
        if(posti_ris < 1) return;
        this.posti_ris = posti_ris;
    }
}

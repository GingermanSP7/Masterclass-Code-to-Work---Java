package Esercizio3.gest_Prenotazioni;

public class PrenotazioneSingola extends Prenotazione{
    private Preferenza pref;
    private int posti_ris;

    PrenotazioneSingola(String codice,Preferenza pref) {
        super(codice,1);
        this.pref = pref;
        posti_ris = 1;
    }

    public Preferenza getPref() {
        return pref;
    }

    public void setPref(Preferenza pref) {
        this.pref = pref;
    }

    public int getnPosti(){
        return 1;
    }

}

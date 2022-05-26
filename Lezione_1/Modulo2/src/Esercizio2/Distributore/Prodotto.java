package Esercizio2.Distributore;

/**
 *     Ogni tipo di prodotto può avere un codice univoco e un prezzo uguali nel tempo (ossia per uno stesso tipo di prodotto).
 */

public class Prodotto {
    private String codice;
    private Double prezzo;

    Prodotto(String codice, Double prezzo){
        this.codice = codice;
        this.prezzo = prezzo;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public Double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Double prezzo) {
        if(prezzo < 0.01){
            System.out.println("Errore, prezzo non valido o negativo");
            return;
        }
        this.prezzo = prezzo;
    }
}

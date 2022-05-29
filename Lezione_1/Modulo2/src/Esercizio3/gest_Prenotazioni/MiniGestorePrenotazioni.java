package Lezione_1.Modulo2.src.Esercizio3.gest_Prenotazioni;

/**
     * Esercizio Mini Gestore prenotazioni 🛵

    Scrivere un programma in grado di modellare la gestione delle prenotazioni di un ristorante. Il ristorante può ricevere 2 tipi di prenotazione: singola o di gruppo.
    Progettare la classe GestorePrenotazioni a partire da due interi m e n che determinano rispettivamente il numero di posti disponibili all’interno e all’esterno nel ristorante.
    Ad ogni Prenotazione sono associati un codice univoco. Una prenotazione singola può anche esprimere una preferenza tra interno ed esterno, La prenotazione di gruppo, invece, ha anche un attributo che specifica il numero di posti da riservare.

    La classe prevede i seguenti metodi:

    - prenota: data una Prenotazione p in input, se c’è posto nel ristorante viene accettata restituendo true (dando precedenza alla preferenza indicata), altrimenti viene rifiutata restituendo false
    - terminaPrenotazione: data una Prenotazione p in input, termina la prenotazione eliminandola e liberando i posti associati.

    PLUS🏍: Se presenti prenotazioni singole la cui preferenza può ora essere soddisfatta in virtù dei nuovi posti liberi, modificare la prenotazione di conseguenza. 
    Esempio: ci sono 2 posti disponibili all’esterno e 2 prenotazioni p1 e p2, entrambe da 2 persone all’esterno; nel momento in cui viene terminata la prenotazione p1, se p2 è ancora in corso, va spostata all’esterno.
    - prenotazioniAttualiEsterno: ritorna un array con le attuali prenotazioni per l’esterno del ristorante
    - prenotazioniAttualiInterno: ritorna un array con le attuali prenotazioni per l’interno del ristorante
    

    Potete usare questo codice come test

    ```
    MiniGestorePrenotazioni miniGestorePrenotazioni = new MiniGestorePrenotazioni(3, 5);
    Prenotazione p1 = new PrenotazioneSingola("12", Preferenza.ESTERNO);
    Prenotazione p2 = new PrenotazioneSingola("23", Preferenza.ESTERNO);
    Prenotazione p3 = new PrenotazioneSingola("34", Preferenza.INTERNO);
    Prenotazione p4 = new PrenotazioneSingola("56", Preferenza.ESTERNO);
    miniGestorePrenotazioni.prenota(p1);
    miniGestorePrenotazioni.prenota(p2);
    miniGestorePrenotazioni.prenota(p3);
    miniGestorePrenotazioni.prenota(p4);

    Prenotazione[] prenotazioniInternoArray = miniGestorePrenotazioni.prenotazioniAttualiInterno();
    Prenotazione[] prenotazioniEsternoArray = miniGestorePrenotazioni.prenotazioniAttualiEsterno();
    int prenotazioniInterno = 0, prenotazioniEsterno = 0;
    //contiamo e togliamo i null se presenti
    for (int i = 0; i < prenotazioniInternoArray.length; i++)
        if (prenotazioniInternoArray[i] != null) {
            prenotazioniInterno++;
        }
    for (int i = 0; i < prenotazioniEsternoArray.length; i++)
        if (prenotazioniEsternoArray[i] != null) {
            prenotazioniEsterno++;
        }
    System.out.println(prenotazioniInterno == 1);
    System.out.println(prenotazioniEsterno == 3);
    Prenotazione p5 = new PrenotazioneGruppo("45", 2);
    boolean a  = miniGestorePrenotazioni.prenota(p5);
    prenotazioniInterno = 0;
    prenotazioniEsterno = 0;
    //contiamo e togliamo i null se presenti
    for (int i = 0; i < prenotazioniInternoArray.length; i++)
        if (prenotazioniInternoArray[i] != null) {
            prenotazioniInterno++;
        }
    for (int i = 0; i < prenotazioniEsternoArray.length; i++)
        if (prenotazioniEsternoArray[i] != null) {
            prenotazioniEsterno++;
        }
    System.out.println(prenotazioniInterno + prenotazioniEsterno == 5);
    //verifichiamo i posti effettivamente riservati
    int postiTotali = 0;
    for (int i = 0; i < prenotazioniInternoArray.length; i++)
        if (prenotazioniInternoArray[i] != null) {
            postiTotali += prenotazioniInternoArray[i].getnPosti();
        }
    for (int i = 0; i < prenotazioniEsternoArray.length; i++)
        if (prenotazioniEsternoArray[i] != null) {
            postiTotali += prenotazioniEsternoArray[i].getnPosti();
    }
    System.out.println(postiTotali == 6);
    Prenotazione p6 = new PrenotazioneSingola("67", Preferenza.ESTERNO);
    boolean inserita = miniGestorePrenotazioni.prenota(p6);
    System.out.println(inserita);
    ```

    Suggerimento: usate l’ereditarietà
 */

public class MiniGestorePrenotazioni {
    private int m;      //disponibili INTERNO
    private int n;      //disponibili ESTERNO

    private int prenotati_m;
    private int prenotati_n;

    private Prenotazione interno[];
    private Prenotazione esterno[];

    private int searchPrenotazione_Interno(Prenotazione p){
        //caso: SINGOLA
        if(p instanceof PrenotazioneSingola){
            PrenotazioneSingola singola = (PrenotazioneSingola) p;
            for(int i=0;i<interno.length;i++){
                if(interno[i].getCodice().toLowerCase().equals(singola.getCodice().toLowerCase())) return i;
            }
        }
        return -1;
    }
    
    private int searchPrenotazione_Esterno(Prenotazione p){
        //caso: SINGOLA
        if(p instanceof PrenotazioneSingola){
            PrenotazioneSingola singola = (PrenotazioneSingola) p;
            for(int i=0;i<esterno.length;i++){
                if(esterno[i].getCodice().toLowerCase().equals(singola.getCodice().toLowerCase())) return i;
            }
        }
        return -1;
    }

    private void shiftPrenotazione_Interno(int i){
        while(interno[i+1] != null){
            interno[i] = interno[i+1];
            i++;
        }
        interno[i] = null;
        return;
    }

    private void shiftPrenotazione_Esterno(int i){
        while(esterno[i+1] != null){
            esterno[i] = esterno[i+1];
            i++;
        }
        esterno[i] = null;
        return;
    }

    private int searchPrenotazioneLibera(Prenotazione p[]){
        int pos = 0;
        while(p[pos] != null){
            pos++;
        }
        if(pos == p.length-1) return -1;
        return pos;
    }

    MiniGestorePrenotazioni(int m, int n){
        this.m = m;
        this.n = n;
        interno = new Prenotazione[m];
        esterno = new Prenotazione[n];
        prenotati_m = 0;
        prenotati_n = 0;
    }

    public boolean prenota(Prenotazione p){
        //caso: SINGOLA
        if(p instanceof PrenotazioneSingola){
            PrenotazioneSingola singola = (PrenotazioneSingola) p;      //downcasting: ereditarietà  
            switch(singola.getPref()){
                case INTERNO:
                if(m>0){
                    interno[prenotati_m++] = p;
                    m--;
                    return true;
                }
                break;
                case ESTERNO:
                    if(n > 0){
                        esterno[prenotati_n++] = p;
                        n--;
                        return true;
                    }
                break;
            }
            return false;
        }

        //caso: GRUPPO
        int pos = -1;
        PrenotazioneGruppo gruppo = (PrenotazioneGruppo) p;
        if(gruppo.getPosti_ris() > n-prenotati_n){  //preferenza interna
            pos = searchPrenotazioneLibera(interno);
            if(pos != -1){
                interno[pos] = gruppo;
                m -= gruppo.getPosti_ris();
                prenotati_m += gruppo.getPosti_ris();
                return true;
            }
            else return false;
        }
        //preferenza esterna
        pos = searchPrenotazioneLibera(esterno);
        if(pos != -1){
            esterno[pos] = gruppo;
            n -= gruppo.getPosti_ris();
            prenotati_n += gruppo.getPosti_ris();
            return true;
        }
        return false;
    }

    public void terminaPrenotazione(Prenotazione p){
        int pos = -1;
        // caso: SINGOLA
        if(p instanceof PrenotazioneSingola){
            PrenotazioneSingola singola = (PrenotazioneSingola) p;
            //caso: INTERNO
            if(singola.getPref() == Preferenza.INTERNO){
                pos = searchPrenotazione_Interno(singola);
                if(pos != -1){
                    interno[pos] = null;
                    m++;
                    prenotati_m--;
                    shiftPrenotazione_Interno(pos);
                }
                return;
            }
            //caso: ESTERNO
            pos = searchPrenotazione_Esterno(singola);
            if(pos != -1){
                esterno[pos] = null;
                n++;
                prenotati_n--;
                shiftPrenotazione_Esterno(pos);
            }
            return;
        }
        //caso: GRUPPO
        PrenotazioneGruppo gruppo = (PrenotazioneGruppo) p;
        int count = gruppo.getPosti_ris();
        int tmp = 0; 
        int k = 1;

        pos = searchPrenotazione_Interno(gruppo);
        tmp = pos;
        if(pos == -1){
            pos = searchPrenotazione_Esterno(p);
            if(pos == -1) return;   //non esiste nessuna prenotazione
            //caso: ESTERNO
            while(count > 0){
                esterno[pos++] = null;
                count--;
            }
            //shift di gruppo.getPosti_ris posizioni in esterno
            while(pos < esterno.length){
                esterno[pos++] = esterno[tmp];
                esterno[tmp] = null;
                tmp++;
            }
            return;
        }
        //caso: INTERNO
        while(count > 0){
            interno[pos++] = null;
            count--;
        }
        //shift di gruppo.getPosti_ris posizioni in interno
        while(pos < interno.length){
            interno[pos++] = interno[tmp];
            interno[tmp] = null;
            tmp++;
        }
        return;
    }

    public Prenotazione[] prenotazioniAttualiEsterno(){
       return esterno;
    }

    public Prenotazione[] prenotazioniAttualiInterno(){
        return interno;
    }

    public int getnPosti(Prenotazione p[]){
        int count = 0;
        for(int i=0;i<p.length;i++){
            if(p[i] == null) continue;
            else{
                count++;
            }
        }
        return count;
    }

    public static void main(String args[]){
        MiniGestorePrenotazioni miniGestorePrenotazioni = new MiniGestorePrenotazioni(3, 5);
        Prenotazione p1 = new PrenotazioneSingola("12", Preferenza.ESTERNO);
        Prenotazione p2 = new PrenotazioneSingola("23", Preferenza.ESTERNO);
        Prenotazione p3 = new PrenotazioneSingola("34", Preferenza.INTERNO);
        Prenotazione p4 = new PrenotazioneSingola("56", Preferenza.ESTERNO);
        miniGestorePrenotazioni.prenota(p1);
        miniGestorePrenotazioni.prenota(p2);
        miniGestorePrenotazioni.prenota(p3);
        miniGestorePrenotazioni.prenota(p4);
        
        Prenotazione[] prenotazioniInternoArray = miniGestorePrenotazioni.prenotazioniAttualiInterno();
        Prenotazione[] prenotazioniEsternoArray = miniGestorePrenotazioni.prenotazioniAttualiEsterno();
        int prenotazioniInterno = 0, prenotazioniEsterno = 0;
        //contiamo e togliamo i null se presenti
        for (int i = 0; i < prenotazioniInternoArray.length; i++)
            if (prenotazioniInternoArray[i] != null) {
                prenotazioniInterno++;
            }
        for (int i = 0; i < prenotazioniEsternoArray.length; i++)
            if (prenotazioniEsternoArray[i] != null) {
                prenotazioniEsterno++;
            }
        System.out.println(prenotazioniInterno == 1);
        System.out.println(prenotazioniEsterno == 3);

        Prenotazione p5 = new PrenotazioneGruppo("45", 2);
        boolean a  = miniGestorePrenotazioni.prenota(p5);
        prenotazioniInterno = 0;
        prenotazioniEsterno = 0;
        //contiamo e togliamo i null se presenti
        System.out.println("INTERNO");
        for (int i = 0; i < prenotazioniInternoArray.length; i++)
            if (prenotazioniInternoArray[i] != null) {
                System.out.println(prenotazioniInternoArray[i].getCodice());
                prenotazioniInterno++;
            }

        System.out.println("ESTERNO:");
        for (int i = 0; i < prenotazioniEsternoArray.length; i++)
            if (prenotazioniEsternoArray[i] != null) {
                System.out.println(prenotazioniEsternoArray[i].getCodice());
                prenotazioniEsterno++;
            }
        System.out.println(prenotazioniInterno + prenotazioniEsterno == 5);
        //verifichiamo i posti effettivamente riservati
        int postiTotali = 0;
        for (int i = 0; i < prenotazioniInternoArray.length; i++)
            if (prenotazioniInternoArray[i] != null) {
                postiTotali += prenotazioniInternoArray[i].getnPosti();
            }
        for (int i = 0; i < prenotazioniEsternoArray.length; i++)
            if (prenotazioniEsternoArray[i] != null) {
                postiTotali += prenotazioniEsternoArray[i].getnPosti();
        }
        System.out.println(postiTotali == 6);
        Prenotazione p6 = new PrenotazioneSingola("67", Preferenza.ESTERNO);
        boolean inserita = miniGestorePrenotazioni.prenota(p6);
        System.out.println(inserita);
    }
}

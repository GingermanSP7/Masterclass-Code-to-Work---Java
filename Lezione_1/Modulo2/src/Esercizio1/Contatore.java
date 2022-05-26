package Esercizio1;
/** 
 *  Progettare una classe Contatore che permetta di:
 *      - Istanziare la classe con un valore iniziale
 *      - Istanziare la classe senza un valore iniziale
 *      - Incrementare il conteggio attuale
 *      - Ottenere il conteggio attuale
 *      - Resettare il conteggio a 0
 *      - Resettare il conteggio ad un altro valore 
 **/

public class Contatore {
    private int count;

    Contatore(int valoreIniziale){             //istanziare la classe con un valore iniziale
        setCount(valoreIniziale);
    }   

    Contatore(){}         //istanziare la classe senza un valore iniziale
    

    public int getCount() {     //ottenere il conteggio attuale
        System.out.println("Valore contatore attuale: "+count);
        return count;
    }

    public void setCount(int count) {
        if(count < 0){
            System.out.println("Impossibile impostare un valore negativo al contatore");
            return;
        }
        this.count = count;
    }

    public void incremento(){
        count += 1;
    }

    public void reset(){
        setCount(0);
    }

    public void resetVal(int val){
        setCount(val);
    }

    public static void main(String args[]){
        Contatore c1 = new Contatore();
        c1.setCount(2);
        c1.getCount();

        Contatore c2 = new Contatore(23);
        c2.getCount();
        c2.reset();
        c2.getCount();
        c2.resetVal(100);
        c2.getCount();
        c2.incremento();
        c2.getCount();
    }
}

package Lezione_1.Modulo2.src.Esercizio1;

/**
 * 
    * Progettare una classe Quadrato, che permetta di
    • Istanziare la classe con la dimensione del lato del quadrato
    • Ottenere il perimetro del quadrato
    • Stampare il quadrato sulla console
 
    * Progettare una classe Cerchio, che permetta di
    • Istanziare la classe con un costruttore che accetta un parametro
    • Ottenere la circonferenza del cerchio
    • Ottenere l’area del cerchio
 */



public class Quadrato {
    private float lato;
    private Colore col;

    Quadrato(float lato){
        this.lato = lato;
        col = new Nero();
    }

    public float getLato() {
        return lato;
    }

    public void setLato(float lato) {
        if(lato < 0){
            System.out.println("Un quadrato non può avere lati negativi! ");
            return;
        }
        this.lato = lato;
    }

    public float getPerimetro(){
        return this.lato*4;
    }

    public void printSquare(){
        System.out.println("Risultato (lato al quadrato): "+ this.lato*this.lato);
    }

    public void setColore(int rosso, int verde, int blue){
        if(rosso == 255 && verde == 255 && blue == 255){
            col = new Bianco();
            return;
        }
        else if(rosso == 0 && verde == 0 && blue == 0){
            col = new Nero();
            return;
        }
        col = new Colore(rosso, verde, blue);
    }

    public static void main(String args[]){
        Quadrato q = new Quadrato(11);
        Cerchio c = new Cerchio(4);

        // q.setLato(-1);      //errore (valore negativo)!
        // float perimetro = q.getPerimetro();
        // System.out.println("Perimetro del quadrato: "+perimetro);
        // q.printSquare();

        c.getDiametro();
        c.setDiametro(-11);
        c.getDiametro();
        c.getCirconferenza();
        c.getArea();
        // c.setColore(10, 25, -2);
    }
}   


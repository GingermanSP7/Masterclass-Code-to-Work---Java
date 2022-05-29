/**
 * Scrivere un programma in grado di modellare la gestione di diversi tipi di veicoli: automobili e 
    autocarri. In particolare, create le classi Autocarro e Automobile entrambe con le seguenti 
    caratteristiche:
    Ogni veicolo è caratterizzato da:
        - Targa
        - Numero di posti
    Gli autocarri hanno una proprietà aggiuntiva: la capacità massima di carico (espressa in quintali). Le automobili, invece, il numero di porte.
    Il metodo toString degli oggetti Automobile deve ritornare il numero di targa e il numero di porte, separati dal carattere «:».
    Il metodo toString degli oggetti Autocarro, invece, deve ritornare il numero di targa e la massima capacità in quintali, separati dal carattere «:».

    Deve essere possibile eseguire il seguente codice:

    ```
    Automobile automobile = new AutoMobile("cf123rm", 4, 4);
    AutoCarro autoCarro = new AutoCarro("ca133sm", 4, 2);
    
    ```
 */

package Lezione_1.Modulo2.src.Esercizio3.Veicoli;

public class Veicolo {
    private String targa;
    private int numero_p;

    Veicolo(String targa, int numero_p){
        this.targa = targa;
        this.numero_p = numero_p;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public int getNumero_p() {
        return numero_p;
    }

    public void setNumero_p(int numero_p) {
        if(numero_p < 1){
            System.out.println("Errore, valore non valido");
            return;
        }
        this.numero_p = numero_p;
    }   

    public static void main(String args[]){
        Automobili a = new Automobili("cf123rm", 4, 4);
        Autocarri c = new Autocarri("ca133sm", 4, 2);

        System.out.println(a.toString());
        System.out.println(c.toString());

        Automobili a1 = new Automobili("ab999cd", 2, 3);
        Autocarri c2 = new Autocarri("ef222gh", 3, 5);

        System.out.println(a1.toString());
        System.out.println(c2.toString());
    }
}

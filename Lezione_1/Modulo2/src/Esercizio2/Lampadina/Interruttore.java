package Lezione_1.Modulo2.src.Esercizio2.Lampadina;

import java.util.Scanner;

public class Interruttore {
    private int statoInt;
    private Lampadina l;

    Interruttore(){
        statoInt = 0;
        l = Lampadina.creaIstanza();
    }

    public int getStatoInt() {
        System.out.println("Stato interruttore: " + statoInt);
        return statoInt;
    }

    public void premi_Interruttore() {
        if(this.statoInt < 0 || this.statoInt > 1){
            System.out.println("Errore, valore interruttore non valido!");
            return;
        }
        else if(this.statoInt == 0){
            statoInt = 1;
            l.click();
        } 
        else if(this.statoInt == 1){
            statoInt = 0;
            l.click();
        }
    }

    public void getStato_lampadina(){
        l.stato();
    }


    public static void main(String args[]){
        int scelta = 0;
        Interruttore i = new Interruttore();
        Interruttore i2 = new Interruttore();

        Scanner sc = new Scanner(System.in);
        System.out.println("Quale interruttore vuoi cliccare? \n 1: Interruttore 1 \t 2: Interruttore 2 \t 0: Esci");
        scelta = sc.nextInt();
        if(scelta < 0 || scelta > 2){
            System.out.println("Errore, valore non valido");
            sc.close();
            return;
        }
        while(scelta != 0){
            if(scelta == 1){
                i.premi_Interruttore();
                i.getStatoInt();
                i.getStato_lampadina();
            }
            else{
                i2.premi_Interruttore();
                i2.getStato_lampadina();
                i2.getStatoInt();
            }
            System.out.println("\nQuale interruttore vuoi cliccare? \n 1: Interruttore 1 \t 2: Interruttore 2 \t 0: Esci");
            scelta = sc.nextInt();
        }
        System.out.println("Arrivederci!");
        sc.close();
        return;
    }
}

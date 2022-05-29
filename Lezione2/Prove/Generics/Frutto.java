package Lezione2.Prove.Generics;

import java.util.ArrayList;
import java.util.List;

public class Frutto {
    public static void mangia(List<Frutto> frutti){}

    // il metodo ritorna un tipo T che estende la classe frutto, 
    // quindi comprende il tipo Frutto ma anche il tipo delle sottoclassi di Frutto
    public static <T extends Frutto> void mangia2(List<T> frutti){}

    public static void main(String[] args) {
        ArrayList<Pera> pere = new ArrayList<>();
        ArrayList<Frutto> frutti = new ArrayList<>();

        Frutto.mangia(frutti);
        
        // da errore perchè il metodo mangia prende solo una lista di tipo frutto e non pere, 
        // anche se questo è una sottoclasse del tipo desiderato
        //Frutto.mangia(pere);     

        Frutto.mangia2(frutti);
        // questo lo possiamo fare perchè abbiamo specificato che il tipo generico comprende anche le sottoclassi di Frutto
        Frutto.mangia2(pere);

    }
}

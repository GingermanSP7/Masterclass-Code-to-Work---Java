package Lezione_1.Modulo2.src.Esercizio2.Lampadina;

public class Lampadina {
    private int stato;
    private int count;
    private static Lampadina l;

    private Lampadina(int stato){
        if(stato < -1 || stato > 1){
            System.out.println("Stato della lampadina non valido!");
            return;
        }
        this.stato = stato;
        count = 0;
    }

    public static Lampadina creaIstanza(){
        if(l == null) l = new Lampadina(0);
        return l;
    }

    public int stato(){
        if(stato == 0) System.out.println("Lampadina spenta");
        else if(stato == 1) System.out.println("Lampadina accesa");
        else if(stato == -1) System.out.println("La lampadina è rotta");
        return stato;
    }

    public void click(){
        count++;
        if(this.stato == -1 || count >= 3){
            System.out.println("Lampadina rotta!");
            this.stato = -1;
            this.count = 3;
            return;
        }
        else if(this.stato == 0) this.stato = 1;  
        else if(this.stato == 1) this.stato = 0;
    }

    public static void main(String args[]){
        // Lampadina l = new Lampadina(0);
        // l.stato();
        // l.click();
        // l.stato();
        // l.click();
        // l.stato();
        // l.click();
        // l.stato();
        // l.click();
        // l.stato();
    }
}

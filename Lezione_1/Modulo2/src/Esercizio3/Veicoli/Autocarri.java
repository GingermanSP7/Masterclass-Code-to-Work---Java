package Esercizio3.Veicoli;

public class Autocarri extends Veicolo {
    private int capacità_q;

    Autocarri(String targa, int num_posti, int capacità_q){
        super(targa,num_posti);
        this.capacità_q = capacità_q;
    }

    public int getCapacità_q() {
        return capacità_q;
    }

    public void setCapacità_q(int capacità_q) {
        if(capacità_q < 0){
            System.out.println("Errore, non è possibile avere una capacità negativa!");
            return;
        }
        this.capacità_q = capacità_q;
    }

    public String toString(){
        String str = "";
        Integer cap = this.getCapacità_q();
        str += this.getTarga()+":"+Integer.toString(cap);
        return str;
    }
}

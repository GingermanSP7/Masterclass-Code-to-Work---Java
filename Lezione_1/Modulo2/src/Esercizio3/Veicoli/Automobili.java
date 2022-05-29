package Lezione_1.Modulo2.src.Esercizio3.Veicoli;

public class Automobili extends Veicolo{
    private int num_porte;

    Automobili(String targa, int num_posti, int num_porte){
        super(targa, num_posti);
        this.num_porte = num_porte;
    }

    public int getNum_porte() {
        return num_porte;
    }

    public void setNum_porte(int num_porte) {
        if(num_porte < 1){
            System.out.println("Impossibile avere un numero di posti negativo");
            return;
        }
        this.num_porte = num_porte;
    }

    public String toString(){
        String str = "";
        Integer n = this.num_porte;
        str +=this.getTarga()+":"+Integer.toString(n); 
        return str;
    }
}

package Esercizio4;

import java.util.Set;
import java.util.TreeSet;

public class Parola implements Comparable<Parola>{
    private Set<String> significato;
    private final String parola;

    Parola(String parola){
        this.parola = parola;
        significato = new TreeSet<>();
    }

    public Set<String> getSignificati_Parola() {
        return significato;
    }

    public void addSignificato(String sign) {
        significato.add(sign);
    }

    public String getParola(){
        return parola;
    }

    public Character getCarattereParola(int i){
        return parola.charAt(i);
    }

    @Override
    public int compareTo(Parola o) {
        String parola1 = this.getParola();
        String parola2 = o.getParola();
        int result = parola1.compareTo(parola2);
        if(result == 1) return 1;
        else if(result == -1) return -1;
        else return 0;
    }
}

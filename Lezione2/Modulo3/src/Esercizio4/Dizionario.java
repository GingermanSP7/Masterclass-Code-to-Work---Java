package Esercizio4;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
    * Esercizio Dictionary 🛵

    Scrivere un programma che per gestire un dizionario. In particolare, ad ogni lettera
    dell'alfabeto è associata una lista di parole che iniziano con quella lettera e ad
    ogni parola è, a sua volta, associata una lista di significati diversi della parola.

    Esempio:
    c -> calcio -> sport
    c -> calcio -> elemento chimico

    Devono essere possibili le seguenti operazioni:
    - inserisci parola (con almeno un significato associato)
    - aggiungi significato per una certa parola
    - stampa dizionario, che ritorna una stringa contenente ogni parola e significato
    (in ordine lessicografico ascendente in base alla lettera) nella forma:

    ```
    lettera1:[parola1: (significato1;significato2;...;), parola2: (significato1;...;...;)]
    lettera2:[parola1: significato1;significato2;...;), parola2: (significato1;...;...;)]
    ...
    letteraN:[parola1: significato1;significato2;...;),parola2: (significato1;...;...;)]
    ```  
 */

 public class Dizionario{
    private Map<Character,Set<Parola>> diz;
    
    Dizionario(){
        diz = new TreeMap();
    }

    public void addParola(Parola p, String significato){
        int feed = 0;
        Character iniziale = p.getParola().toLowerCase().charAt(0);
        p.addSignificato(significato);

        if()
    }


    public static void main(String[] args) {
         
    }
 }
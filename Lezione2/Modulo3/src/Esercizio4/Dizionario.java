package Esercizio4;

import java.util.Map;

/**
 * Scrivere un programma che per gestire un dizionario. In particolare, ad ogni lettera
    dell'alfabeto è associata una lista di parole che iniziano con quella lettera e ad
    ogni parola è, a sua volta, associata una lista di significati diversi della parola.

    NOTA: Devono essere tutti gli argomenti ordinati

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

import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


public class Dizionario {
   private Map<Character,Set<Parola>> diz;

   Dizionario(){
      diz = new TreeMap<>();
   }

   public void addParola(Parola p, String significato){
      Character iniziale = p.getCarattereParola(0);
      if(!diz.containsKey(iniziale)){        //carattere non esiste
         Set<Parola> setP = new TreeSet<>();
         setP.add(p);
         diz.put(iniziale, setP);
         p.addSignificato(significato);
         return;
      }
      Set<Parola> setP = diz.get(iniziale);  //se il carattere esite, il set elimina eventuali duplicati, quindi si inserisce solamente la parola e il significato
      setP.add(p);
      p.addSignificato(significato);
   }

   public void addSignificato(Parola p, String significato){
      Character iniziale = p.getCarattereParola(0);
      if(diz.containsKey(iniziale)){
         Set<Parola> setP = diz.get(iniziale);
         if(setP.contains(p)){
            p.addSignificato(significato);
            return;
         }
         else{
            System.out.println("Il dizionario non contiene la parola data, di conseguenza non è possibile aggiungere il significato");
            return;
         }
      }
      System.out.println("Il dizionario non contiene il carattere per la parola data, prova ad aggiungere la parola al dizionario");
      return;
   }

   public void stampaDizionario(){
      for (Map.Entry<Character,Set<Parola>> entry : diz.entrySet())  {
         Set<Parola> setP = entry.getValue();
         System.out.print(entry.getKey() + " : [");
         for (Parola parola : setP) {
            Set<String> sign = parola.getSignificati_Parola();
            System.out.print(parola.getParola() + " : (");
            for (String significato : sign) {
               System.out.print(significato + ";");
            }
            System.out.print("), ");
         }
         System.out.println("]");
      }
   }

   public static void main(String[] args) {
      Parola p1 = new Parola("calcio");
      Parola p2 = new Parola("campagna");
      Parola p3 = new Parola("squadra");

      Dizionario d = new Dizionario();
      d.addParola(p1, "Sport");
      d.addParola(p1, "Elemento chimico");      //provo a inserire la stessa parola per vedere se inserisce duplicati, ma non lo fa
      d.addParola(p2, "Superficie di terreno aperta");
      d.addParola(p3, "strumento da disegno");  
      d.addSignificato(p2, "Insieme di operazioni");
      d.addSignificato(p1, "Fabrizio Maurizio");
      d.addSignificato(p3, "gruppo di persone che collaborano");

      d.stampaDizionario();
   }
}

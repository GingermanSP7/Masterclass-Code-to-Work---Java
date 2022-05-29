package Lezione_1.Modulo2.src.Esercizio2.Distributore;
/**
 * Scrivere un programma in grado di modellare la gestione di un distributore di bevande. Il distributore gestirà una lista di 2 tipi diversi di prodotti: Caffè e Cappuccino.
    Progettare la classe DistributoreDiBevande costruito con un intero n che determina il numero di prodotti nel distributore
    Ogni tipo di prodotto può avere un codice univoco e un prezzo uguali nel tempo (ossia per uno stesso tipo di prodotto).

    La classe prevede i seguenti metodi:

    - caricaProdotto: dato un Prodotto p in input, lo carica nel distributore
    - inserisciImporto: permette di inserire un importo nella macchinetta
    - scegliProdotto: dato in ingresso un codice di prodotto, restituisca il 
    prodotto associato a quel codice (se l’importo inserito lo consente) e 
    decrementi il saldo disponibile nel distributore
    - saldoAttuale: restituisce il saldo attuale del distributore
    - getResto: restituisce il resto dovuto e azzeri il saldo


    Potete usare questo codice come test

    ```
    Caffe caffe = new Caffe("caffe", 0.5);
    Cappuccino cappuccino = new Cappuccino("cappuccino", 1);
    DistributoreDiBevande distributoreDiBevande = new DistributoreDiBevande(10);
    distributoreDiBevande.caricaProdotto(caffe);
    distributoreDiBevande.caricaProdotto(caffe);
    distributoreDiBevande.caricaProdotto(cappuccino);
    distributoreDiBevande.caricaProdotto(caffe);
    distributoreDiBevande.caricaProdotto(caffe);
    distributoreDiBevande.caricaProdotto(cappuccino);
    distributoreDiBevande.caricaProdotto(caffe);
    System.out.println(distributoreDiBevande.saldoAttuale() == 0);
    System.out.println(distributoreDiBevande.getResto() == 0);
    distributoreDiBevande.inserisciImporto(0.4);
    System.out.println(distributoreDiBevande.scegliProdotto("caffe") == null);
    distributoreDiBevande.inserisciImporto(0.2);
    System.out.println(distributoreDiBevande.scegliProdotto("caffe") != null);
    System.out.println(distributoreDiBevande.getResto()-0.10 < 1E-6);
    System.out.println(distributoreDiBevande.saldoAttuale() == 0);
    System.out.println(distributoreDiBevande.scegliProdotto("caffe") == null);
    distributoreDiBevande.inserisciImporto(2.0);
    System.out.println(distributoreDiBevande.scegliProdotto("caffe") != null);
    System.out.println(distributoreDiBevande.scegliProdotto("cappuccino") != null);
    System.out.println(distributoreDiBevande.scegliProdotto("caffe") != null);
    System.out.println(distributoreDiBevande.saldoAttuale() == 0);
    System.out.println(distributoreDiBevande.getResto()-0.10 < 1E-6);
    ```

    Suggerimento: usate l’ereditarietà
 */


public class DistributoreDiBevande {
   private Prodotto p[];
   private int count;
   private Double saldo_disp;

   private void scorriProdotti(int pos){
      //caso in cui si sceglie il prodotto i-esimo
      while(p[pos+1] != null){
         p[pos] = p[pos+1];
         ++pos;
      }         
      p[pos] = null;      
   }

   private int searchProdotto(String cod){
      //caso in cui il prodotto è il primo della lista
      if(p[0].getCodice().toLowerCase().equals(cod.toLowerCase())) return 0;
      
      
      //caso in cui si sceglie l'i-esimo prodotto
      for(int i=0;i<p.length;i++){
         if(p[i].getCodice().toLowerCase().equals(cod.toLowerCase())) return i;
      }

      // nessun prodotto con codice 'cod' trovato
      return -1;
   }

   DistributoreDiBevande(int n){
      p = new Prodotto[n];
      count = 0;
      saldo_disp = 0.0d;
   }

   public void caricaProdotto(Prodotto prod){
      // caso in cui p è tutto null
      if(p == null){
         p[0] = prod;
         count++;
         return;
      }
      //inserimento alla i-esima posizione
      for(int i=0;i<p.length;i++){
         if(p[i] == null){
            p[i] = prod;
            count++;
            return;
         }
      }
      //tutti i posti sono occupati
      System.out.println("Il distributore è pieno!");
      return;
   }

   public void inserisciImporto(Double imp){
      //caso in cui l'importo e negativo o zero
      if(imp < 0 || imp == 0.0){
         System.out.println("Errore, importo negativo o zero");
         return;
      }
      //caso importo > 0
      saldo_disp += imp;
   }

   public Prodotto scegliProdotto(String str){
      Prodotto tmp = null;
      int i = -1;
      // cerco il prodotto in base al codice;
      i = searchProdotto(str);
      if(i != -1 && saldo_disp >= p[i].getPrezzo()){      //prodotto trovato e saldo sufficiente
         saldo_disp -= p[i].getPrezzo();
         tmp = p[i];
         scorriProdotti(i);
         return tmp;
      }
      return null;
   }

   public void printProdotti(){
      for(int i=0;i<p.length;i++){
         //se l'i-esimo prodotto è null, saltalo
         if(p[i] == null) continue;
         System.out.println(p[i].getCodice()+"-> "+p[i].getPrezzo());
      }
   }

   public Double saldoAttuale(){
      return saldo_disp;
   }

   public Double getResto(){
      Double resto = saldoAttuale();
      saldo_disp = 0d;
      return resto;
   }


   public static void main(String args[]){
      Caffe caffe = new Caffe("caffe", 0.5);
      Cappuccino cappuccino = new Cappuccino("cappuccino", 1d);
      DistributoreDiBevande distributoreDiBevande = new DistributoreDiBevande(10);
      distributoreDiBevande.caricaProdotto(caffe);
      distributoreDiBevande.caricaProdotto(caffe);
      distributoreDiBevande.caricaProdotto(cappuccino);
      distributoreDiBevande.caricaProdotto(caffe);
      distributoreDiBevande.caricaProdotto(caffe);
      distributoreDiBevande.caricaProdotto(cappuccino);
      distributoreDiBevande.caricaProdotto(caffe);

      distributoreDiBevande.printProdotti();
      System.out.println("");

      System.out.println(distributoreDiBevande.saldoAttuale() == 0);
      System.out.println(distributoreDiBevande.getResto() == 0);
      distributoreDiBevande.inserisciImporto(0.4);
      System.out.println(distributoreDiBevande.scegliProdotto("caffe") == null);   
      distributoreDiBevande.inserisciImporto(0.2);
      System.out.println(distributoreDiBevande.scegliProdotto("caffe") != null);
      System.out.println(distributoreDiBevande.getResto()-0.10 < 1E-6);
      System.out.println(distributoreDiBevande.saldoAttuale() == 0);
      System.out.println(distributoreDiBevande.scegliProdotto("caffe") == null);
      distributoreDiBevande.inserisciImporto(2.0);
      System.out.println(distributoreDiBevande.scegliProdotto("caffe") != null);
      System.out.println(distributoreDiBevande.scegliProdotto("cappuccino") != null);
      System.out.println(distributoreDiBevande.scegliProdotto("caffe") != null);
      System.out.println(distributoreDiBevande.saldoAttuale() == 0);
      System.out.println(distributoreDiBevande.getResto()-0.10 < 1E-6);   
   }
}

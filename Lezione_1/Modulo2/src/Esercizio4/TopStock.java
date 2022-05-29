package Esercizio4;

/**
 * In questo problema ti verrà fornito un elenco dei prezzi giornalieri delle azioni e ti verrà chiesto di restituire le tre azioni con il prezzo medio più alto.
 * 
 * Implementa il metodo getTopStocks(stocks,prices) che prende come input:
    - Un array di stringhe stocks che rappresenta gli stock considerati
    - Un array di 2 dimensioni prices che rappresenta i prezzi dello stock(lista interna) for ogni giorno (lista esterna)
 *
 * Il metodo deve ritornare un array contenente i nomi dei 3 stock che hanno il prezzo maggiore del valore medio.
 * L'array deve essere ordinato in ordine in ordine medio descrescente.
 * Hai la garanzia che ogni azione avrà un valore medio unico.
 * 
 * NOTA: La media deve essere fatta sommando i prezzi per tutti i giorni
 */

public class TopStock{

   private Double calcolaMedia(Double prices[][]){
      Double media = 0d;
      int count = 0;
      for(int i=0;i<prices.length;i++){
         for(int j=0;j<prices[i].length;j++){
            media += prices[i][j];
            count ++;
         }
      }
      return media / count;
   }

   private String[] getTopStocks(String stocks[], Double prices[][]){
      Double media = calcolaMedia(prices);
      Double tot[] = new Double[stocks.length];
      Double max = 0d;
      String topStocks[] = new String[3];
      Integer index[] = new Integer[3];
      int count = 0; 

      // per ogni stock dobbiamo sommare i prezzi di ogni sottoarray nella stessa posizione dello stock
      /*
           0       1     2      3      4      5  
         [AMZN - CACC - EQIX - GOOG - ORLY - ULTA]

              0      1      2     3     4     5  
         0| 11.81  11.09  12.11 10.93  9.83  8.14
         1|
         2|                                                    TOT[] = {0,0,0,0,0,0}  ogni elemento di questo array corrisponde all'i-esimo stock
         3|
         4|
         5|

      */
      for(int i=0;i<prices.length;i++){      //sommo i prezzi di ogni stock per ognuno dei giorni
         tot[i] = 0d;
         for(int j=0;j<prices[i].length;j++){
            tot[i] += prices[j][i];
         }  
      }

      while(count < 3){
         for(int i=0;i<tot.length;i++){
            if(max < tot[i]){
               max = tot[i];
               tot[i] = null;    //al prossimo ciclo non viene considerato, evitiamo di prendere sempre lo stesso massimo
               if(max > media) index[count] = i;
            }
         }
         max = 0d;
         ++count;
      }

      for(int i=0;i<index.length;i++){
         topStocks[i] = stocks[index[i]];
      }
      return topStocks;
   }

   public static void main(String args[]){
      return;
   }
}
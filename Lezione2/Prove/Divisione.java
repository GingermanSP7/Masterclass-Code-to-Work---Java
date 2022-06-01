public class Divisione{
    public static void divisione(int a, int b){
        try{
            int c = a /b;
            System.out.println(c);
        }
        catch(ArithmeticException e){
            //e.printStackTrace();            //stampa l'errore che darebbe senza interrompere il flusso di esecuzione
            System.out.println(e.getMessage());  // stampa il motivo per cui si è generato l'errore
            // System.out.println("Divisione per 0");  //funziona
        }
        finally{
            System.out.println("Dentro il finally");
        }
        System.out.println("Ciao mondo");   //funziona
    }

    public static void main(String[] args) {
        Divisione.divisione(10, 0);
    }
}
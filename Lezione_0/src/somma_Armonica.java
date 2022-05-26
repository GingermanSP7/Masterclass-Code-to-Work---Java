import java.util.Scanner;

public class somma_Armonica {
    public static void main(String args[]){
        int numero = 0;
        float ris = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Dammi un numero: ");
        numero = sc.nextInt();

        ris = sum(numero);
        System.out.println("Risultato: "+ ris);
    }

    private static float sum(int numero){
        float tot = 0;
        for (int i=1;i<=numero;i++) {
            tot += (1f / i);
        }
        return tot;
    }
}

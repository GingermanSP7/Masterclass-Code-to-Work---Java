import java.util.Scanner;

public class fattoriale {
    public static void main(String args[]){
        int numero = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Dammi un numero intero");
        numero = sc.nextInt();

        fattoriale(numero);
    }

    private static void fattoriale(int numero){
        int tot = 1;
        if(numero == 0){
            System.out.println("Risultato: "+1);
            return;
        }
        for(int i=numero; i>=1;i--){
            tot *= i;
        }
        System.out.println("Risultato: "+tot);
    }
}

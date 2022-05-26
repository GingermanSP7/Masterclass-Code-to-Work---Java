import java.util.Scanner;

public class numero_primo {
    public static void main(String args[]){
        int numero = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Dammi un numero");
        numero = sc.nextInt();

        isPrimo(numero);
    }

    private static void isPrimo(int numero) {
        for(int i=2;i<numero;i++){
            if(numero == i) continue;
            if(numero % i == 0) {
                System.out.println("Non è un numero primo!");
                return;
            }
        }
        System.out.println("E' un numero primo!");
    }
}

import java.util.Scanner;
public class fibonacci {
    public static void main(String args[]){
        int iterazioni = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Dammi un numero iniziale: ");
        iterazioni = sc.nextInt();
        System.out.print("\n");

        fibonacci(iterazioni);
    }

    private static void fibonacci(int n){
        Integer arr[] = new Integer[n+2];
        arr[0] = 0;
        arr[1] = 1;

        for(int i=2;i<n+2;i++){
            arr[i] = arr[i-2] + arr[i-1];
        }
        System.out.println("numero: "+ arr[n]);
    }
}

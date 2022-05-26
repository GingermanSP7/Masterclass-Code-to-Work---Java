import java.util.Scanner;

public class Tabelline {
    public static void main(String args[]){
        int n,m;
        Scanner sc = new Scanner(System.in);
        System.out.println("Dammi due numeri");
        System.out.print("N: ");
        n = sc.nextInt();
        System.out.print("\n");
        System.out.print("M: ");
        m = sc.nextInt();
        System.out.print("\n");


        tabelline(n,m);
    }

    private static void tabelline(int n, int m){
        Integer arr[] = new Integer[m];
        for(int i=0;i<m;i++){
            arr[i] = i * n;
            System.out.println("Elemento in posizione "+ i + ": "+arr[i]);
        }
    }
}

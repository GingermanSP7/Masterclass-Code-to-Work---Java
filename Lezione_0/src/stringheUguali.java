import java.util.Scanner;

public class stringheUguali {
    public static void main(String args[]){
        String a = "";
        String b = "";
        String c = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("Dammi 3 Stringhe");

        a = sc.next();
        b = sc.next();
        c = sc.next();


        checkEquals(a,b,c);
    }

    private static void checkEquals(String a, String b, String c){
        if(a.toLowerCase().equals(b) && a.toLowerCase().equals(c)) System.out.println("3");
        else if((a.toLowerCase().equals(b)) && !(a.toLowerCase().equals(c))) System.out.println("2: A e B");
        else if(!(a.toLowerCase().equals(b)) && a.toLowerCase().equals(c)) System.out.println("2: A e C");
        else if((!a.toLowerCase().equals(b)) && !(a.toLowerCase().equals(c)) && b.toLowerCase().equals(c)) System.out.println("2: B e C");
        else System.out.print("0");
    }
}

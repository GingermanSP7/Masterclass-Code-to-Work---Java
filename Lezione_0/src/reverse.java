import java.util.Arrays;
import java.util.Scanner;

public class reverse {
    public static void main(String args[]){
        String s = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("Dammi una stringa");
        s = sc.next();

        revereString(s);
    }

    private static void revereString(String str){
        String reverse = "";
        String tmp = "";

        for(int i=str.length()-1;i>=0;i--){
            reverse += str.charAt(i);
        }
        System.out.println("Stringa Originale: "+str+"\nStringa Reverse: "+reverse);
    }
}

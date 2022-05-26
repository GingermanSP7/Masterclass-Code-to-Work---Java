import java.util.Scanner;
public class occorrenze {
    public static void main(String args[]){
        char c;
        int count_Occorrenze = 0;
        String str = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("Dimmi il carattere per cui cercare le occorrenze");
        c = sc.next().charAt(0);
        System.out.println("Dimmi la stringa su cui devo trovare le occorrenze");
        str = sc.next();

        check_Occorrenze(c,str);
    }

    private static void check_Occorrenze(char c, String s){
        int count = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == c) ++count;
        }
        System.out.println("Numero di occorrenze per il carattere '"+c+"' trovate: "+count);
    }
}

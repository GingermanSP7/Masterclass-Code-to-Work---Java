package Lezione_0.src;

import java.util.Scanner;
import java.lang.String;

public class InvertiStringa {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a String:");
        String s = sc.nextLine();
        reverseString(s);
    }

    private static void reverseString(String s){
        String splitted[] = s.split(" ");
        String p1 = splitted[0];
        String p2 = splitted[1];


        String concat = p2 + " " + p1;
        System.out.println("Reverse String: "+concat);
    }
}

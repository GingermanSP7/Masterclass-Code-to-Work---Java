import java.util.Scanner;


public class anagrammi {
    public static void main(String args[]){
        String a = "";
        String b = "";
        Scanner sc = new Scanner(System.in);

        System.out.println("Dammi due stringhe: ");
        a = sc.next();
        b = sc.next();

        anagrammi(a,b);
    }

    private static void anagrammi(String a, String b){
        int count = 0;
        Integer occorrenze_A[] = new Integer[26];
        Integer occorrenze_B[] = new Integer[26];

        if(a.length() != b.length()){           //uno dei due ha almeno un carattere in più
            System.out.println("Non anagrammi!");
            return;
        }

        inizializza_Array(occorrenze_A);
        inizializza_Array(occorrenze_B);

        occorrenze_A = inizializzaOccorrenze(a);
        occorrenze_B = inizializzaOccorrenze(b);

//        printOccorrenze(occorrenze_A,1);
//        printOccorrenze(occorrenze_B,2);

        for(int i=0;i<26;i++){
            if(occorrenze_A[i] == occorrenze_B[i]) ++count;
            else {
                System.out.println("Non Anagramma!");
                return;
            }
        }

        if(count == 26) System.out.println("Anagramma!");
        else System.out.println("Non anagramma!");

    }

    private static Integer[] inizializza_Array(Integer[] arr){
        for(int i=0;i<arr.length;i++){
            arr[i] = 0;
//            System.out.println("Inizializzando l'array: "+arr[i]);
        }
        return arr;
    }

//    private static void printOccorrenze(Integer[] arr,int id_Stringa) {         //id_Stringa solo per scopo di debugging
//        for(int i=0;i<arr.length;i++){
//            if(id_Stringa == 1) System.out.println("Occorrenze A: "+arr[i]);
//            else if(id_Stringa == 2) System.out.println("Occorrenze B: "+arr[i]);
//        }
//    }

    private static Integer[] inizializzaOccorrenze(String s){
        Integer occorrenze[] = new Integer[26];
        inizializza_Array(occorrenze);

        for(int i=0;i<s.length();i++){
            int carattere = s.toUpperCase().charAt(i);
            int pos = carattere - 65;
            occorrenze[pos] += 1;
//            System.out.println("Carattere: "+ s.toUpperCase().charAt(i) +" in posizione: " + pos);
        }

        return occorrenze;
    }
}

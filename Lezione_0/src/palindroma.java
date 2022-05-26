import java.util.Scanner;

public class palindroma {
    public static void main(String args[]){
        String str = "";
        Scanner sc = new Scanner(System.in);

        System.out.println("Dammi una stringa: ");
        str = sc.next();

        isPalindroma(str);
    }

    private static void isPalindroma(String str){       //confronto i caratteri iniziali e finali con due indici
        int j = str.length()-1;
        int count = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == str.charAt(j)) ++count;
            else{
                System.out.println("Non palindroma!");
                return;
            }
            j--;
        }

        if(count == str.length()) System.out.println("Palindroma!");
        return;
    }
}

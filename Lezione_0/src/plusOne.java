import java.util.Scanner;

public class plusOne {
    public static void main(String args[]){
        int len = 0;
        Integer digits[];

        Scanner sc = new Scanner(System.in);
        System.out.println("Lunghezza del numero");
        len = sc.nextInt();
        digits = new Integer[len];

        System.out.println("Digita il numero");
        for(int i=0;i<len;i++){
            digits[i] = sc.nextInt();
            if(digits[i] > 9 || digits[i]< 0){
                System.out.println("Errore numero non valido!");
                return;
            }
        }

        incremento(digits);
    }

    private static void incremento(Integer []digits) {
        Integer arr[] = new Integer[digits.length+1];
        int j = 0;
        arr[0] = 0;

        for(int i=1;i<=digits.length;i++){
            arr[i] = digits[i-1];
            //System.out.print(arr[i] + " ");
        }

        j = arr.length - 1;
        if(arr[j] == 9){
            arr[j] = 0;
            while(arr[j-1] == 9){
                arr[j-1] = 0;
                j--;
            }
            arr[j-1]+=1;
        }
        else{
            arr[j] += 1;
        }
        printArr(arr);
    }

    private static void printArr(Integer[] arr) {
        if(arr[0] == 0){
            int arr1[] = new int[arr.length];
            for(int i=1;i<arr.length;i++){
                arr1[i-1] = arr[i];
                System.out.print(arr1[i-1] + " ");
            }
        }
        else{
            for(int i=0;i<arr.length;i++){
                System.out.print(arr[i]+" ");
            }
        }
    }
}

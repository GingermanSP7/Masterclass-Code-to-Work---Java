package Lezione_0.src;

import java.util.Arrays;
import java.util.Scanner;

public class min_max {
    public static void main(String args[]){
        String arr[];
        Integer  numbers[];
        int dim = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("Dammi la dimensione dell'array");
        dim = sc.nextInt();
        arr = new String[dim];
        numbers = new Integer[dim];

        System.out.println("Riempi l'array");
        arr = fillNumbers(arr,dim,sc);

//        printArr(arr,dim);

        numbers = parseNumbers(arr);
        computeMinMax(numbers);
    }

    private static String[] fillNumbers(String arr[],int dim,Scanner sc){
        for(int i=0;i<dim;i++){
            arr[i] = sc.next();
        }
        return arr;
    }

    private static void printArr(String arr[],int dim){
        for(int i=0;i<dim;i++){
            System.out.println(arr[i]);
        }
    }

    private static Integer[] parseNumbers(String arr[]){        //converto in intero gli elementi dell'array di Integer
        Integer numbers[] = new Integer[arr.length];
        for(int i=0;i<arr.length;i++){
            numbers[i] = Integer.parseInt(arr[i]);
        }
        return numbers;
    }

    private static void computeMinMax(Integer numb[]){
        Arrays.sort(numb);
        System.out.println("Il minimo è: " + numb[0] + " il massimo è: " + numb[numb.length-1]);
    }
}

package Lezione_0.src;

import java.util.Scanner;

public class somma_diagonale {
    public static void main(String args[]){
        int righe_colonne = 0;
        Integer matrix[][];
        Scanner sc = new Scanner(System.in);
        System.out.println("Dimmi il numero di righe e di colonne che deve avere la matrice");
        righe_colonne = sc.nextInt();

        matrix = fillMatrix(righe_colonne,sc);
//        printMatrix(matrix,righe_colonne);
        somma_diagonali(matrix,righe_colonne);
    }

    private static Integer[][] fillMatrix(int rc, Scanner sc){
        System.out.println("Riempi la matrice");
        Integer matrix[][] = new Integer[rc][rc];
        for(int i=0;i<rc;i++){
            for(int j=0;j<rc;j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        return matrix;
    }

    private static void printMatrix(Integer matrix[][],int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.println(matrix[i][j]);
            }
        }
    }

    private static void somma_diagonali(Integer matrix[][],int n){
        int tot_diagPrincipale = 0;
        int tot_diagSecondaria = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i == j) tot_diagPrincipale += matrix[i][j];      // diagonale principale
                if(j == n-1-i) tot_diagSecondaria += matrix[i][j];  //diagonale secondaria
            }
        }
        System.out.println("Somma diagonale principale: "+tot_diagPrincipale);
        System.out.println("Somma diagonale secondaria: "+tot_diagSecondaria);
        return;
    }

}

package Lezione_0.src;

/*
    Vengono forniti due array di interi nums1 e nums2, ordinati in ordine crescente, e due interi m e n, che rappresentano rispettivamente il numero di elementi in nums1 e nums2.

    OBIETTIVO: Unisci nums1 e nums2 in un unico array ordinato in ordine crescente.

    L'array ordinato finale non dovrebbe essere restituito dalla funzione, ma essere invece archiviato all'interno dell'array nums1. Per adattarsi a questo, 
    nums1 ha una lunghezza di m + n, dove i primi m elementi denotano gli elementi che devono essere uniti e gli ultimi n elementi sono impostati su 0 e dovrebbero essere ignorati. 
    nums2 ha una lunghezza di n.

    NOTA: Prova a svolgere l'esercizio con una complessità di O(m+n)
 */

public class mergeArray {
    public static void main(String args[]){
        Integer arr1[] = {2,3,4,0,0,0,0};
        Integer arr2[] = {1,2,3,5};

        merge(arr1,arr2);
        printArray(arr1);

        insertionSort(arr1);
    }

    private static void insertionSort(Integer[] arr1) {
        for(int i=0;i<arr1.length;i++){
            int j = i-1;
            while(j>=0 && arr1[j+1] < arr1[j]){
                int tmp = arr1[j+1];
                arr1[j+1] = arr1[j];
                arr1[j] = tmp;
                j--;
            }
        }
        printArray(arr1);
    }

    private static void printArray(Integer[] arr1) {
        for(int i=0;i<arr1.length;i++){
            System.out.print(arr1[i]+" ");
        }
        System.out.print("\n");
    }

    private static void merge(Integer[] arr1, Integer[] arr2) {
        int pos = 0;
        int j = 0;
        while(arr1[pos] != 0){
            pos++;
        }
        for(int i=pos;i<arr1.length;i++){
            arr1[i] = arr2[j];
            j++;
        }
    }


}

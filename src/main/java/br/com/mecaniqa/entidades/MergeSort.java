package br.com.mecaniqa.entidades;
public class MergeSort {
    public static void mergeSort(int[]array,int inicio, int fim){
        if(inicio < fim){
            int meio = inicio + (fim - inicio) / 2;
            mergeSort(array,inicio, meio);
            mergeSort(array, meio + 1, fim);
            intercalar(array, inicio, meio , fim);
        }
        
    }
    private static void intercalar(int[]array,int inicio,int meio, int fim){
        int esquerdo = meio - inicio + 1;
        int direito = fim - meio;

        int[] arrayEsq = new int[esquerdo];
        int[] arrayDireita = new int[direito];
        
        for(int i = 0; i < esquerdo ; i++){
            arrayEsq[i] = array[inicio + i];
        } 

       for (int j = 0; j < direito; j++){
        arrayDireita[j] = array[meio + 1 + j];
       }
        int i = 0;
        int j = 0;
        int k = inicio;
        while(i < esquerdo && j < direita){
            if(arrayEsq[i] <= arrayDireita[j]){
                array[k] = arrayEsq[i];
                i++;
            } else{
                array[k] = arrayDireita[j];
                j++;
            }
            k++;
        
        }   
        while (j < direito){
            array[k] = arrayDireita[j];
            j++;
            k++;
        }
    }
}



package br.com.mecaniqa.entidades;

import br.com.mecaniqa.enums.ChaveOrdenacao;

public class MergeSort {

    public static void ordenarPecas(Peca[] array, int inicio, int fim, ChaveOrdenacao chave){

            if(inicio < fim){
                int meio = inicio + (fim - inicio) / 2;
                ordenarPecas(array,inicio, meio,chave);
                ordenarPecas(array, meio + 1, fim,chave);
                intercalar(array, inicio, meio , fim,chave);
            }
    }
    private static void intercalar(Peca[]array,int inicio,int meio, int fim, ChaveOrdenacao chave){
        int esquerdo = meio - inicio + 1;
        int direito = fim - meio;

        Peca[] arrayEsq = new Peca[esquerdo];
        Peca[] arrayDireita = new Peca[direito];
        
        for(int i = 0; i < esquerdo ; i++){
            arrayEsq[i] = array[inicio + i];
        } 

       for (int j = 0; j < direito; j++){
        arrayDireita[j] = array[meio + 1 + j];
       }
        int i = 0;
        int j = 0;
        int k = inicio;

        if (chave == ChaveOrdenacao.CODIGO_IDENTIFICADOR){
            while(i < esquerdo && j < direito){
                if(arrayEsq[i].codigo <= arrayDireita[j].codigo){
                    array[k] = arrayEsq[i];
                    i++;
                } else{
                    array[k] = arrayDireita[j];
                    j++;
                }
                k++;
            }
        }

        if (chave == ChaveOrdenacao.NOME){
            while(i < esquerdo && j < direito){
                if(arrayEsq[i].nomePeca.compareTo(arrayDireita[j].nomePeca) <= 0){
                    array[k] = arrayEsq[i];
                    i++;
                } else{
                    array[k] = arrayDireita[j];
                    j++;
                }
                k++;
            }
        }

        while (i < esquerdo){
            array[k] = arrayEsq[i];
            i++;
            k++;
        }
        while (j < direito){
            array[k] = arrayDireita[j];
            j++;
            k++;
        }
    }

    public static void ordenarServicos(Servico[] array, int inicio, int fim, ChaveOrdenacao chave){

        if(inicio < fim){
            int meio = inicio + (fim - inicio) / 2;
            ordenarServicos(array,inicio, meio,chave);
            ordenarServicos(array, meio + 1, fim,chave);
            intercalarServ(array, inicio, meio , fim,chave);
        }
    }
    private static void intercalarServ(Servico[]array,int inicio,int meio, int fim, ChaveOrdenacao chave){
        int esquerdo = meio - inicio + 1;
        int direito = fim - meio;

        Servico[] arrayEsq = new Servico[esquerdo];
        Servico[] arrayDireita = new Servico[direito];

        for(int i = 0; i < esquerdo ; i++){
            arrayEsq[i] = array[inicio + i];
        }

        for (int j = 0; j < direito; j++){
            arrayDireita[j] = array[meio + 1 + j];
        }
        int i = 0;
        int j = 0;
        int k = inicio;

        if (chave == ChaveOrdenacao.CODIGO_IDENTIFICADOR){
            while(i < esquerdo && j < direito){
                if(arrayEsq[i].codigo <= arrayDireita[j].codigo){
                    array[k] = arrayEsq[i];
                    i++;
                } else{
                    array[k] = arrayDireita[j];
                    j++;
                }
                k++;
            }
        }

        if (chave == ChaveOrdenacao.NOME){
            while(i < esquerdo && j < direito){
                if(arrayEsq[i].descricao.compareTo(arrayDireita[j].descricao) <= 0){
                    array[k] = arrayEsq[i];
                    i++;
                } else{
                    array[k] = arrayDireita[j];
                    j++;
                }
                k++;
            }
        }

        while (i < esquerdo){
            array[k] = arrayEsq[i];
            i++;
            k++;
        }
        while (j < direito){
            array[k] = arrayDireita[j];
            j++;
            k++;
        }
    }
}



package br.com.mecaniqa;

import org.w3c.dom.ls.LSOutput;

public class Peca {
    public int codigo;
    public String nomePeca;
    public String nomeFabricante;
    public double precoCusto;
    public double precoVenda;
    public int quantidade;

    private static final int MAX_PECAS = 100;
    public static Peca[] pecas = new Peca[MAX_PECAS];
    public static int proximoIndex = 0;

    public Peca(int codigo, String nomePeca, String nomeFabricante, double precoCusto, double precoVenda, int quantidade) {
        this.codigo = codigo;
        this.nomePeca = nomePeca;
        this.nomeFabricante = nomeFabricante;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.quantidade = quantidade;
    }

    public static void inserirPeca(Peca nome) {

        //verifica se o vetor esta cheio
        if (proximoIndex < MAX_PECAS){
            pecas[proximoIndex] = nome;
            proximoIndex++;
            return;
        }
        System.out.println("O array esta cheio");
    }

    public static void inserirPosicaoPeca(Peca nome, int index){

        //verifica se o index é válido
        if (index >= proximoIndex || index < 0){
            System.out.println("index invalido");
            return;
        }
        //verifica se o vetor está cheio
        if (proximoIndex >= MAX_PECAS){
            System.out.println("O array esta cheio");
            return;
        }
        //Leva os elementos do vetor para a direita
        for (int i = proximoIndex; i > index; i--){
            pecas[i] = pecas[i - 1];
        }
        //insere a peça
        pecas[index] = nome;
        proximoIndex++;
    }

    public static void mostrarPeca(){
        System.out.println("LISTA DE PECAS");
        for (int i = 0; i < proximoIndex; i++) {
            System.out.println(
                    "Indice " + i + ": " +
                            "Codigo: " + pecas[i].codigo +
                            " | Nome: " + pecas[i].nomePeca +
                            " | Preco: R$ " + pecas[i].precoVenda +
                            " | Quantidade: " + pecas[i].quantidade);
        }
    }

    public static void deletarPeca(int index){

        //verifica se o index é valido
        if (index >= proximoIndex || index < 0){
            System.out.println("index invalido");
            return;
        }

        //traz os elementos para a esquerda sobrescrevendo a peça do index removido
        for(int i = index; i < proximoIndex; i++){
            pecas[i] = pecas[i + 1];
        }
        proximoIndex--;

    }

    public static int buscarPeca(int codigo){
        //varre o vetor procurando
        for (int i = 0; i < proximoIndex; i++){
            if (pecas[i].codigo == codigo)
                return i;
        }
        return -1;
    }

    //retorna o total de peças com base no index válido naquele momento
    public static void totalPecas(){
        int  total = proximoIndex;
        System.out.println("TOTAL DE PECAS: " + total);
    }

    public static void mudarPeca(int codigoBusca, String novoNome, double novoValorVenda, int novaQuantidade){
        int codigoPeca = buscarPeca(codigoBusca);
        if(codigoPeca != -1){
            pecas[codigoPeca].nomePeca = novoNome;
            pecas[codigoPeca].precoVenda = novoValorVenda;
            pecas[codigoBusca].quantidade = novaQuantidade;
            System.out.println("Peça atualizada com sucesso!");
        }else {
            System.out.println("Erro: Peça não encontrada.");
        }
    }
}

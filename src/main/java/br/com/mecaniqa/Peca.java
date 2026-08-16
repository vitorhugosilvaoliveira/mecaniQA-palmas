package br.com.mecaniqa;

public class Peca {
    public int codigo;
    public String nomePeca;
    public String nomeFabricante;
    public double precoCusto;
    public double precoVenda;
    public int quantidade;

    private static final int MAX_PECAS = 100;
    public static Peca[] pecas = new Peca[MAX_PECAS];
    public static int indexValido = 0;

    public Peca(int codigo, String nomePeca, String nomeFabricante, double precoCusto, double precoVenda, int quantidade) {
        this.codigo = codigo;
        this.nomePeca = nomePeca;
        this.nomeFabricante = nomeFabricante;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.quantidade = quantidade;
    }

    public static void inserirPeca(Peca nome) {

        //verifica se a lista esta cheia
        if (indexValido <= MAX_PECAS - 1){
            pecas[indexValido] = nome;
            indexValido++;
        }
        else
            System.out.println("A lista esta cheia");
    }

    public static void inserirPosicaoPeca(Peca nome, int index){

        //verifica se o index é válido
        if (index > indexValido || index < 0){
            System.out.println("index invalido");
            return;
        }
        //verifica se a lista está cheia
        if (indexValido >= MAX_PECAS){
            System.out.println("A lista esta cheia");
            return;
        }
        //insere a peça
        for (int i = indexValido; i > index; i--){
            pecas[i] = pecas[i - 1];
        }
        pecas[index] = nome;
        indexValido++;
    }


    public static void mostrarPeca(){
        System.out.println("LISTA DE PECAS");
        for (int i = 0; i < indexValido; i++) {
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
        if (index > indexValido || index < 0){
            System.out.println("index invalido");
            return;
        }

        //traz os elementos para a esquerda sobrescrevendo a peça do index removido
        for(int i = index; i < indexValido; i++){
            pecas[i] = pecas[i + 1];
        }
        indexValido--;

    }

    public static int buscarPeca(Peca nome){
        //varre a lista procurando
        for (int i = 0; i < indexValido; i++){
            if (pecas[i] == nome)
                return i;
        }
        return -1;
    }

    //retorna o total de peças com base no index válido naquele momento
    public static int totalPecas(){
        return indexValido;
    }

}

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
    public static int totalPecas = 0;

    public Peca(int codigo, String nomePeca, String nomeFabricante, double precoCusto, double precoVenda, int quantidade) {
        this.codigo = codigo;
        this.nomePeca = nomePeca;
        this.nomeFabricante = nomeFabricante;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.quantidade = quantidade;
    }

    public static void inserirPeca(Peca nome){
        if(totalPecas < MAX_PECAS){
            pecas[totalPecas] = nome;
            totalPecas++;
        }else {
            System.out.println("cheio!");
        }
    }

    public static void mostrarPeca(){
        System.out.println("LISTA DE PEÇAS");
        for (int i = 0; i < totalPecas; i++) {
            if (pecas[i] != null){
                System.out.println(
                        "Índice " + i + ": " +
                                "Código: " + pecas[i].codigo +
                                " | Nome: " + pecas[i].nomePeca +
                                " | Preço: R$ " + pecas[i].precoVenda +
                                " | Quantidade: " + pecas[i].quantidade);
            }
            else{
                System.out.println("Índice " + i + " : " + " Vazio");}
        }
    }
    public static int procurarPeca(int codigo){
        for (int i = 0; i < pecas.length; i++) {
            if (pecas[i].codigo == codigo) {
                return i;
            }
        }
        return -1;
    }

    public static void deletarPeca(Peca y) {
         int indexPeca = procurarPeca(y.codigo);

        int indexValido = 0;
        if( indexPeca >= 0 && indexPeca < totalPecas){
            pecas[indexPeca] = null ;
            Peca.totalPecas--;
        }
        for (int i = 0; i < pecas.length; i++) {
            if (pecas[i] != null) {
                pecas[indexValido] = pecas[i];
                if (i != indexValido) {
                    pecas[i] = null;
                }
                indexValido++;
            }
        }
    }
}

package br.com.mecaniqa;

// Import não utilizado; vale remover para manter o código limpo.
import org.w3c.dom.ls.LSOutput;

public class Peca {
    // Boa, parabéns! Todos os atributos do TAD são públicos e sem getters/setters.
    public int codigo;
    public String nomePeca;
    public String nomeFabricante;
    public double precoCusto;
    public double precoVenda;
    public int quantidade;

    // Boa, parabéns pelo uso de arrays estáticos unidimensionais com tamanho fixo e variável de controle!
    // Porém, toda esta estrutura (array, proximoIndex) e os métodos CRUD abaixo deveriam estar isolados
    // na classe Gerenciador, deixando Peca estritamente como uma struct (apenas atributos, sem construtor nem métodos).
    private static final int MAX_PECAS = 100;
    public static Peca[] pecas = new Peca[MAX_PECAS];
    public static int proximoIndex = 0;

    // A especificação pedia TADs sem métodos internos (nem mesmo construtores).
    public Peca(int codigo, String nomePeca, String nomeFabricante, double precoCusto, double precoVenda, int quantidade) {
        this.codigo = codigo;
        this.nomePeca = nomePeca;
        this.nomeFabricante = nomeFabricante;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.quantidade = quantidade;
    }

    // Dica de nomenclatura: o parâmetro "nome" na verdade é um objeto Peca (melhor seria "novaPeca").
    public static void inserirPeca(Peca nome) {

        // Boa, parabéns! Verifica capacidade máxima e usa a variável controladora proximoIndex
        // para inserir em O(1) no primeiro espaço vazio.
        //verifica se o vetor esta cheio
        if (proximoIndex < MAX_PECAS){
            pecas[proximoIndex] = nome;
            proximoIndex++;
            return; // uso legal de early return!
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
                            " | Preço: R$ " + pecas[i].precoVenda +
                            " | Quantidade: " + pecas[i].quantidade);
        }
    }

    public static void deletarPeca(int codigo){
        // Boa, parabéns! Reutiliza a busca linear e faz o shift-left sem deixar buracos no array.
        // Dica: após decrementar proximoIndex, vale atribuir pecas[proximoIndex] = null para liberar a referência duplicada.
        int indexPeca = buscarPeca(codigo);

        if(indexPeca >= 0 && indexPeca < proximoIndex){
            //traz os elementos para a esquerda sobrescrevendo a peça do index removido
            for(int i = indexPeca; i < proximoIndex - 1; i++){
                pecas[i] = pecas[i + 1];
            }
            // Diminui para marcar o proximo index valido
            proximoIndex--;

            System.out.println("Peça removida com sucesso!");
        }else{
            System.out.println("index invalido");
        }
    }

    public static int buscarPeca(int codigo){
        // Boa, parabéns! Busca linear correta retornando o índice encontrado ou -1.
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
        // Boa, parabéns! Chama a busca linear e altera os atributos públicos diretamente.
        // Dica: o nome "codigoPeca" confunde porque guarda o ÍNDICE retornado pela busca, não o código.
        int codigoPeca = buscarPeca(codigoBusca);
        if(codigoPeca != -1){
            pecas[codigoPeca].nomePeca = novoNome;
            pecas[codigoPeca].precoVenda = novoValorVenda;
            // ATENÇÃO (BUG): aqui foi usado "codigoBusca" (o código da peça) em vez de "codigoPeca" (o índice)!
            // Se o código for maior que a quantidade de peças ou não coincidir com o índice, vai alterar a peça errada
            // ou lançar NullPointerException / ArrayIndexOutOfBoundsException.
            pecas[codigoBusca].quantidade = novaQuantidade;
            System.out.println("Peça atualizada com sucesso!");
        }else {
            System.out.println("Erro: Peça não encontrada.");
        }
    }
}

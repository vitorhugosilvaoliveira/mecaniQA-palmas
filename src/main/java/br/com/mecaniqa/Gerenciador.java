package br.com.mecaniqa;

public class Gerenciador {
    private static final int MAX_SERVICOS = 50;
    public static Servico[] servicos = new Servico[MAX_SERVICOS];
    public static int indexValido = 0;

    private static final int MAX_PECAS = 100;
    public static Peca[] pecas = new Peca[MAX_PECAS];
    public static int proximoIndex = 0;

    public static void inserirServico(Servico nomeServico){
        if(indexValido < MAX_SERVICOS){
            servicos[indexValido] = nomeServico;
            indexValido++;
        }else {
            System.out.println("Array cheio!");
        }
    }

    public static void inserirPosicaoServico(Servico nome, int index){

        //verifica se o index é válido
        if (index >= indexValido || index < 0){
            System.out.println("index invalido");
            return;
        }
        //verifica se o vetor está cheio
        if (indexValido >= MAX_SERVICOS){
            System.out.println("O array esta cheio");
            return;
        }
        //Leva os elementos do vetor para a direita
        for (int i = indexValido; i > index; i--){
            servicos[i] = servicos[i - 1];
        }
        //insere a peça
        servicos[index] = nome;
        indexValido++;
    }

    public static void mostrarServico(){
        System.out.println("LISTA DE SERVICOS");
        for (int i = 0; i < indexValido; i++) {
            System.out.println(
                    "Indice " + i + ": " +
                            "Codigo: " + servicos[i].codigo +
                            " | Descricao: " + servicos[i].descricao +
                            " | Tempo: " + servicos[i].tempoMinutos + " minutos " +
                            " | Valor: R$ " + servicos[i].valor);
        }
    }

    public static int procurarServico(int codigo){
        for(int i = 0; i < indexValido; i++ ){
            if(servicos[i].codigo == codigo){
                return i;
            }
        }
        return -1;
    }

    public static void deletarServico(Servico y) {
        int indexServico = procurarServico(y.codigo);

        if (indexServico >= 0 && indexServico < indexValido) {

            // Puxa todos os serviços que estão à direita um espaço para a esquerda
            for (int i = indexServico; i < indexValido - 1; i++) {
                servicos[i] = servicos[i + 1];
            }
            // Diminui para marcar o proximo index valido
            indexValido--;

            System.out.println("Servico removido com sucesso!");
        }else{
            System.out.println("index invalido");
        }
    }

    public static void totalServicos(){
        int  total = indexValido;
        System.out.println("TOTAL DE Serviços: " + total);
    }
    public static void mudarServico(int codigoBusca, String novaDescricao, int novoTempo, double novoValor) {
        int codigoServico = procurarServico(codigoBusca);
        if (codigoServico != -1) {
            servicos[codigoServico].descricao = novaDescricao;
            servicos[codigoServico].tempoMinutos = novoTempo;
            servicos[codigoServico].valor = novoValor;
            System.out.println("Serviço atualizado com sucesso!");
        } else {
            System.out.println("Erro: Serviço não encontrado.");
        }


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
                            " | Preço: R$ " + pecas[i].precoVenda +
                            " | Quantidade: " + pecas[i].quantidade);
        }
    }

    public static void deletarPeca(int codigo){
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

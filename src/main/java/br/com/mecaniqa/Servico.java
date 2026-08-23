package br.com.mecaniqa;

public class Servico{
    public int codigo;
    public String descricao;
    public int tempoMinutos;
    public double valor;

    private static final int MAX_SERVICOS = 50;
    public static Servico[] servicos = new Servico[MAX_SERVICOS];
    public static int totalServicos = 0;
    public static int indexValido = 0;

    public Servico(int codigo, String descricao, int tempo, double valor){
        this.codigo = codigo;
        this.descricao = descricao;
        this.tempoMinutos = tempo;
        this.valor = valor;
    }

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
        }
    }

    public static void totalPecas(){
        int  total = indexValido;
        System.out.println("TOTAL DE PECAS: " + total);
    }
    public static void mudarServico(int codigoBusca, String novaDescricao, int novoTempo, double novoValor){
        int codigoServico = procurarServico(codigoBusca);
        if(codigoServico != -1){
            servicos[codigoServico].descricao = novaDescricao;
            servicos[codigoServico].tempoMinutos = novoTempo;
            servicos[codigoServico].valor = novoValor;
            System.out.println("Serviço atualizado com sucesso!");
        }else {
            System.out.println("Erro: Serviço não encontrado.");
        }

    }
}

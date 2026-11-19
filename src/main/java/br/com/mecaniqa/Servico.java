package br.com.mecaniqa;

public class Servico{
    // Boa, parabéns! Atributos públicos sem getters/setters.
    public int codigo;
    public String descricao;
    public int tempoMinutos;
    public double valor;

    // Assim como em Peca, o array estático e todos os métodos CRUD deveriam ficar isolados
    // na classe Gerenciador, mantendo Servico estritamente como uma struct (apenas atributos).
    private static final int MAX_SERVICOS = 50;
    public static Servico[] servicos = new Servico[MAX_SERVICOS];
    public static int indexValido = 0;

    public Servico(int codigo, String descricao, int tempo, double valor){
        this.codigo = codigo;
        this.descricao = descricao;
        this.tempoMinutos = tempo;
        this.valor = valor;
    }

    public static void inserirServico(Servico nomeServico){
        // Boa, parabéns! Verifica limite do array e usa indexValido para inserção direta.
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
        // Boa, parabéns! Busca linear correta retornando o índice ou -1.
        for(int i = 0; i < indexValido; i++ ){
            if(servicos[i].codigo == codigo){
                return i;
            }
        }
        return -1;
    }

    // Dica de nomenclatura: evitar nomes genéricos de 1 letra como "y" (melhor: "servico" ou receber "int codigo").
    public static void deletarServico(Servico y) {
        // Boa, parabéns! Reutiliza a busca linear e reorganiza os elementos sem deixar buracos.
        // Dica: vale atribuir servicos[indexValido] = null após decrementar indexValido.
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
    public static void mudarServico(int codigoBusca, String novaDescricao, int novoTempo, double novoValor){
        // Boa, parabéns! Chama procurarServico e atualiza os atributos públicos diretamente (e aqui usou o índice certinho!).
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

package br.com.mecaniqa;

public class Servico{
    public int codigo;
    public String descricao;
    public int tempoMinutos;
    public double valor;

    private static final int MAX_SERVICOS = 50;
    public static Servico[] servicos = new Servico[MAX_SERVICOS];
    public static int totalServicos = 0;

    public Servico(int codigo, String descricao, int tempo, double valor){
        this.codigo = codigo;
        this.descricao = descricao;
        this.tempoMinutos = tempo;
        this.valor = valor;
    }

    public static void inserirServico(Servico nomeServico){
        if(totalServicos < MAX_SERVICOS){
            servicos[totalServicos] = nomeServico;
            totalServicos++;
        }else {
            System.out.println("Array cheio!");
        }
    }

    public static void mostrarServico(){
        System.out.println("LISTA DE SERVICOS");
        for (int i = 0; i < totalServicos; i++) {
            System.out.println(
                    "Indice " + i + ": " +
                            "Codigo: " + servicos[i].codigo +
                            " | Descricao: " + servicos[i].descricao +
                            " | Tempo: " + servicos[i].tempoMinutos + " minutos " +
                            " | Valor: R$ " + servicos[i].valor);
        }
    }

    public static int procurarServico(int codigo){
        for(int i = 0; i < servicos.length; i++ ){
            if(servicos[i].codigo == codigo){
                return i;
            }
        }
        return -1;
    }

    public static void deletarServico(Servico y) {
        int indexServico = procurarServico(y.codigo);

            if (indexServico >= 0 && indexServico < totalServicos) {
                servicos[indexServico] = null;
                Servico.totalServicos--;
            }
        int indexValido = 0;

        for (int i = 0; i < servicos.length; i++) {
            if (servicos[i] != null) {
                servicos[indexValido] = servicos[i];
                if (i != indexValido) {
                    servicos[i] = null;
                }
                indexValido++;
            }
        }
    }
}

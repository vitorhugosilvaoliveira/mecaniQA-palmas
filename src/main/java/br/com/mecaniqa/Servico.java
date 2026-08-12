package br.com.mecaniqa;

public class Servico{
    public int codigo;
    public String descricao;
    public int tempoMinutos;
    public double valor;

    private static final int MAX_SERVICOS = 50;
    public static Servico[] servicos = new Servico[MAX_SERVICOS];
    private static int totalServicos = 0;

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
        System.out.println("LISTA DE SERVIÇOS");
        for (int i = 0; i < totalServicos; i++) {
            System.out.println(
                    "Índice " + i + ": " +
                            "Código: " + servicos[i].codigo +
                            " | Descrição: " + servicos[i].descricao +
                            " | Tempo: " + servicos[i].tempoMinutos + " minutos " +
                            " | Valor: R$ " + servicos[i].valor);
        }

    }
}

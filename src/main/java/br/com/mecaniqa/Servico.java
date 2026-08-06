package br.com.mecaniqa;

public class Servico{
    public int codigo;
    public String descricao;
    public int tempoMinutos;
    public double valor;

    public Servico(int codigo, String descricao, int tempo, double valor){
        this.codigo = codigo;
        this.descricao = descricao;
        this.tempoMinutos = tempo;
        this.valor = valor;
    }
}

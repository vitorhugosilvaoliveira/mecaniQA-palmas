package br.com.mecaniqa.entidades;

import br.com.mecaniqa.interfaces.Entidade;

public class Servico implements Entidade<Servico> {
    public static int contadorId = 1;
    public final int codigo;
    public String descricao;
    public int tempoMinutos;
    public double valor;

    public static GerenciadorArvore<Servico> arvoreServico = new GerenciadorArvore<>();

    public Servico(String descricao, int tempo, double valor){
        this.codigo = contadorId++;
        this.descricao = descricao;
        this.tempoMinutos = tempo;
        this.valor = valor;

        arvoreServico.inserir(this);
    }

    public String toString() {
        return this.codigo + ";" + tratarAtributo(this.descricao) + ";" + this.tempoMinutos + ";" + this.valor;
    }
    //metodo interno para ajustar o String e evitar que quebre o arquivo csv
    private String tratarAtributo(String atributo){

        if (atributo == null)
            return "";
        if (atributo.contains(";") || atributo.contains("\"") || atributo.contains("\n")){
            atributo = atributo.replace("\"", "\"\"");
            return "\"" + atributo + "\"";
        }
        return atributo;
    }

    @Override
    public int getCodigo() {return this.codigo;}
}

package br.com.mecaniqa.entidades;

import br.com.mecaniqa.csv.TratarAtributo;
import br.com.mecaniqa.interfaces.Entidade;

public class Servico implements Entidade<Servico> {
    public static int contadorId = 1;
    public final int codigo;
    public String descricao;
    public int tempoMinutos;
    public double valor;

    public static GerenciadorArvore<Servico> arvoreServico = new GerenciadorArvore<>();

    static {
        br.com.mecaniqa.csv.LeitorCsv.importar("Servicos");
    }

    public Servico(String descricao, int tempo, double valor){
        this.codigo = contadorId++;
        this.descricao = descricao;
        this.tempoMinutos = tempo;
        this.valor = valor;

        arvoreServico.inserir(this);
        br.com.mecaniqa.csv.EscritorCsv.adicionarObjetoCsv(
                this,
                "./dados/Servicos.csv",
                "Codigo; Descrição; Tempo; Valor");

    }
    public Servico(int codigo, String descricao, int tempo, double valor) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.tempoMinutos = tempo;
        this.valor = valor;

        arvoreServico.inserir(this);
        if(codigo >= contadorId){
            contadorId = codigo + 1;
        }
    }

    public String toString() {
        return this.codigo + ";" +
                TratarAtributo.atributo(this.descricao) +
                ";" + this.tempoMinutos + ";" + this.valor;
    }


    @Override
    public int getCodigo() {return this.codigo;}
}

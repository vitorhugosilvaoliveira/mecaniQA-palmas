package br.com.mecaniqa.entidades;

import br.com.mecaniqa.csv.TratarAtributo;
import br.com.mecaniqa.interfaces.Entidade;

public class Peca implements Entidade<Peca> {
    public static int contadorId = 1;
    public int codigo;
    public String nomePeca;
    public String nomeFabricante;
    public double precoCusto;
    public double precoVenda;
    public int quantidade;

    public static GerenciadorArvore<Peca> arvorePeca = new GerenciadorArvore<>();

    static {
        br.com.mecaniqa.csv.LeitorCsv.importar("Pecas");
    }

    public Peca(String nomePeca, String nomeFabricante, double precoCusto, double precoVenda, int quantidade) {
        this.codigo = contadorId++;
        this.nomePeca = nomePeca;
        this.nomeFabricante = nomeFabricante;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.quantidade = quantidade;

        arvorePeca.inserir(this);
        br.com.mecaniqa.csv.EscritorCsv.adicionarObjetoCsv(
                this,
                "./dados/Pecas.csv",
                "Codigo; Nome da peça; Nome do Fabricante; Preço de custo; preço de venda; Quantidade"
        );
    }
    public Peca(int codigo, String nomePeca, String nomeFabricante, double precoCusto, double precoVenda, int quantidade) {
        this.codigo = codigo;
        this.nomePeca = nomePeca;
        this.nomeFabricante = nomeFabricante;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.quantidade = quantidade;

        arvorePeca.inserir(this);
        if(codigo >= contadorId){
            contadorId = codigo + 1;
        }
    }

    public String toString() {
        return this.codigo +
                ";" + TratarAtributo.atributo(this.nomePeca) +
                ";" + TratarAtributo.atributo(this.nomeFabricante) +
                ";" + this.precoCusto + ";" + this.precoVenda +
                ";" + this.quantidade;
    }

    @Override
    public int getCodigo() {
        return this.codigo;
    }
}
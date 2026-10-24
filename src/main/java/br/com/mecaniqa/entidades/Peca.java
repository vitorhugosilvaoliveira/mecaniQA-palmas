package br.com.mecaniqa.entidades;

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

    public Peca(String nomePeca, String nomeFabricante, double precoCusto, double precoVenda, int quantidade) {
        this.codigo = contadorId++;
        this.nomePeca = nomePeca;
        this.nomeFabricante = nomeFabricante;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.quantidade = quantidade;

        arvorePeca.inserir(this);
    }

    public String toString() {
        return this.codigo + ";" + tratarAtributo(this.nomePeca) + ";" + tratarAtributo(this.nomeFabricante) + ";" + this.precoCusto + ";" + this.precoVenda + ";" + this.quantidade;
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
    public int getCodigo() {
        return this.codigo;
    }
}
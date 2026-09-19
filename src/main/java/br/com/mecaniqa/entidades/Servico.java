package br.com.mecaniqa.entidades;

import br.com.mecaniqa.csv.EscritorCsv;

public class Servico{
    public static int contadorId = 1;
    public int codigo;
    public String descricao;
    public int tempoMinutos;
    public double valor;

    public Servico(String descricao, int tempo, double valor){
        this.codigo = contadorId++;
        this.descricao = descricao;
        this.tempoMinutos = tempo;
        this.valor = valor;
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
}

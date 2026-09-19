package br.com.mecaniqa.entidades;

import br.com.mecaniqa.enums.Categoria;
import br.com.mecaniqa.nos.NoCarro;
import br.com.mecaniqa.nos.NoPlaca;

public class Carro {
    public String modelo;
    public String placa;
    public int ano;
    public String estiloCarroceria;
    public Categoria categoria;
    public final int codigoDono;
    public static NoPlaca head = null;
    public static NoCarro inicio = null;

    public Carro(String modelo, String placa, int ano, String estiloCarroceria, Categoria categoria, int codigoDono){

        if (placaExiste(placa))
            throw new IllegalArgumentException("Esta placa já foi cadastrada no sistema");

        this.modelo = modelo;
        this.placa = placa;
        this.ano = ano;
        this.estiloCarroceria = estiloCarroceria;
        this.categoria = categoria;
        this.codigoDono = codigoDono;
        cadastrarPlaca(this.placa);
    }

    public String toString() {
        return tratarAtributo(this.modelo) + ";" + tratarAtributo(this.placa) + ";" + this.ano + ";" + tratarAtributo(this.estiloCarroceria) + ";" + this.categoria + ";" + this.codigoDono;
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

    //metodo interno que verifica se a placa esta duplicada
    private static boolean placaExiste(String placa){

        NoPlaca atual = head;
        while (atual != null){
            if (atual.value.equals(placa)){
                return true;
            }
            atual = atual.next;
        }
        return false;
    }

    //lista interna de cadastro de placas
    private void cadastrarPlaca(String placa){

        NoPlaca novaPlaca = new NoPlaca(placa);

        if (head == null){
            head = novaPlaca;
        }else{
            NoPlaca atual = head;
            while (atual.next != null){
                atual = atual.next;
            }
            atual.next = novaPlaca;
        }
    }
    private void appendCarro(Carro value){

        NoCarro novoNo = new NoCarro(value);

        if (inicio == null){
            inicio = novoNo;
        }else {
            NoCarro atual = inicio;
            while(atual.next != null){
                atual = atual.next;
            }
            atual.next = novoNo;
        }
    }
}

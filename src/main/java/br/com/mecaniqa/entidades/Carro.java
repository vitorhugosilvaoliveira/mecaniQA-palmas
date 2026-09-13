package br.com.mecaniqa.entidades;

import br.com.mecaniqa.enums.Categoria;

public class Carro {
    public String modelo;
    public String placa;
    public int ano;
    public String estiloCarroceria;
    public Categoria categoria;
    public final int codigoDono;

    public Carro(String modelo, String placa, int ano, String estiloCarroceria, Categoria categoria, int codigoDono){
        this.modelo = modelo;
        this.placa = placa;
        this.ano = ano;
        this.estiloCarroceria = estiloCarroceria;
        this.categoria = categoria;
        this.codigoDono = codigoDono;
    }
}

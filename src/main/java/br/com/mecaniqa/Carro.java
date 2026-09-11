package br.com.mecaniqa;

public class Carro {
    public String modelo;
    public String placa;
    public int ano;
    public String estiloCarroceria;
    public Categoria categoria;
    public Cliente dono;

    public Carro(String modelo, String placa, int ano, String estiloCarroceria, Categoria categoria, Cliente dono){
        this.modelo = modelo;
        this.placa = placa;
        this.ano = ano;
        this.estiloCarroceria = estiloCarroceria;
        this.categoria = categoria;
        this.dono = dono;
    }
}

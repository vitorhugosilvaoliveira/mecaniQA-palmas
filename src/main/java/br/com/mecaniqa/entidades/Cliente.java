package br.com.mecaniqa.entidades;

public class Cliente {
    private static int contadorID = 1;
    public final int codigo;
    public String nome;
    public String telefone;
    public String email;

    public Cliente(String nome, String telefone, String email){
        this.codigo = contadorID;
        contadorID++;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }
}

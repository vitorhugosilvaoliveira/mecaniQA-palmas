package br.com.mecaniqa;

public class Cliente {
    public int codigo;
    public String nome;
    public String telefone;
    public String email;

    public Cliente(int codigo, String nome, String telefone, String email){
        this.codigo = codigo;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }
}

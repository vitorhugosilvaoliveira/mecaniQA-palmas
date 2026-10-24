package br.com.mecaniqa.entidades;

import br.com.mecaniqa.interfaces.Entidade;

public class Cliente implements Entidade<Cliente> {
    private static int contadorID = 1;
    public final int codigo;
    public String nome;
    public String telefone;
    public String email;

    public static GerenciadorArvore<Cliente> arvoreCliente = new GerenciadorArvore<>();

    public Cliente(String nome, String telefone, String email){
        this.codigo = contadorID++;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;

        arvoreCliente.inserir(this);
    }

    public String toString() {
        return this.codigo + ";" + tratarAtributo(this.nome) + ";" + tratarAtributo(this.telefone) + ";" + tratarAtributo(this.email);
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
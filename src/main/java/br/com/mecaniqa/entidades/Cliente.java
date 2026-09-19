package br.com.mecaniqa.entidades;

import br.com.mecaniqa.nos.NoCliente;

public class Cliente {
    private static int contadorID = 1;
    public final int codigo;
    public String nome;
    public String telefone;
    public String email;
    public static NoCliente head = null;

    public Cliente(String nome, String telefone, String email){
        this.codigo = contadorID++;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;

        appendCliente(this);
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

    private void appendCliente(Cliente value){

        NoCliente novoNo = new NoCliente(value);

        if (head == null){
            head = novoNo;
        }else {
            NoCliente atual = head;
            while(atual.next != null){
                atual = atual.next;
            }
            atual.next = novoNo;
        }
    }
}

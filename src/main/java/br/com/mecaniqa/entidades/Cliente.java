package br.com.mecaniqa.entidades;

import br.com.mecaniqa.csv.EscritorCsv;
import br.com.mecaniqa.csv.TratarAtributo;
import br.com.mecaniqa.interfaces.Entidade;

public class Cliente implements Entidade<Cliente> {
    private static int contadorID = 1;
    public final int codigo;
    public String nome;
    public String telefone;
    public String email;

    public static GerenciadorArvore<Cliente> arvoreCliente = new GerenciadorArvore<>();

    static {
        // executa esse comando primeiro(uma unica vez) para verificar os clientes existentes e retornar o codigo a partir disso.
        br.com.mecaniqa.csv.LeitorCsv.importar("Clientes");
    }

    public Cliente(String nome, String telefone, String email) {
        this.codigo = contadorID++;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;

        arvoreCliente.inserir(this);
        EscritorCsv.adicionarObjetoCsv(
                this,
                "./dados/Clientes.csv",
                "Código; Nome; Telefone; Email"
        );
    }
    //NOVO CONSTRUTOR: usado para continua de arcodo com id existe no arquivo .CSV
    public Cliente(int codigo, String nome, String telefone, String email) {
        this.codigo = codigo;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;

        // Repõe na árvore da memória
        arvoreCliente.inserir(this);

        // Atualiza o contador para que o próximo cliente novo não repita IDs
        if (codigo >= contadorID) {
            contadorID = codigo + 1;
        }
    }

    public String toString() {
        return this.codigo + ";" +
                TratarAtributo.atributo(this.nome) +
                ";" + TratarAtributo.atributo(this.telefone) +
                ";" + TratarAtributo.atributo(this.email);
    }

    @Override
    public int getCodigo() {
        return this.codigo;
    }
}
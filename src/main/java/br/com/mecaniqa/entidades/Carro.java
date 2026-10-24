package br.com.mecaniqa.entidades;

import br.com.mecaniqa.csv.TratarAtributo;
import br.com.mecaniqa.enums.Categoria;
import br.com.mecaniqa.interfaces.Entidade;
import br.com.mecaniqa.nos.NoPlaca;

public class Carro implements Entidade<Carro> {
    private static int contador = 1;
    public final int codigo;
    public String modelo;
    public String placa;
    public int ano;
    public String estiloCarroceria;
    public Categoria categoria;
    public final int codigoDono;
    public static NoPlaca head = null;

    public static GerenciadorArvore<Carro> arvoreCarro = new GerenciadorArvore<>();

    static {
        // executa esse comando primeiro(uma unica vez) para verificar os clientes existentes e retornar o codigo a partir disso.
        br.com.mecaniqa.csv.LeitorCsv.importar("Carros");
    }

    public Carro(String modelo, String placa, int ano, String estiloCarroceria, Categoria categoria, int codigoDono){

        if (placaExiste(placa)) {
            throw new IllegalArgumentException("Esta placa já foi cadastrada no sistema");
        }
        this.codigo = contador++;
        this.modelo = modelo;
        this.placa = placa;
        this.ano = ano;
        this.estiloCarroceria = estiloCarroceria;
        this.categoria = categoria;
        this.codigoDono = codigoDono;

        cadastrarPlaca(this.placa);
        arvoreCarro.inserir(this);
        br.com.mecaniqa.csv.EscritorCsv.adicionarObjetoCsv(
                this,
                "./dados/Carros.csv",
                "Código; Modelo; Placa; Ano; Estilo carroceria; Categoria; Id do proprietário"
        );
    }
    public Carro(int codigo, String modelo, String placa, int ano, String estiloCarroceria, Categoria categoria, int codigoDono){
        this.codigo = codigo; // Usa o ID exato do arquivo
        this.modelo = modelo;
        this.placa = placa;
        this.ano = ano;
        this.estiloCarroceria = estiloCarroceria;
        this.categoria = categoria;
        this.codigoDono = codigoDono;

        cadastrarPlaca(this.placa);
        arvoreCarro.inserir(this);

        // Atualiza o contador de IDs
        if (codigo >= contador) {
            contador = codigo + 1;
        }
    }

    public String toString() {
        return this.codigo + ";" +
                TratarAtributo.atributo(this.modelo) +
                ";" + TratarAtributo.atributo(this.placa) +
                ";" + this.ano +
                ";" + TratarAtributo.atributo(this.estiloCarroceria) + "" +
                ";" + this.categoria + ";" + this.codigoDono;
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

    @Override
    public int getCodigo() {
        return this.codigo;
    }
}

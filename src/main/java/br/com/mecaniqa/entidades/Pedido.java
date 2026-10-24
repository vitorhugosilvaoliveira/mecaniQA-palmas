package br.com.mecaniqa.entidades;

import br.com.mecaniqa.interfaces.Entidade;

/**
 * Pedido com os itens em uma lista simplesmente encadeada manual.
 * Os pedidos cadastrados ficam guardados em uma árvore AVL.
 */
public class Pedido implements Entidade<Pedido> {
    private static int contadorId = 1;

    public final int codigo;
    private ItemPedido inicio;
    private ItemPedido fim;
    private int quantidadeItens;
    private boolean fechado;

    public static GerenciadorArvore<Pedido> arvorePedido = new GerenciadorArvore<>();

    public Pedido() {
        this.codigo = contadorId++;
        this.inicio = null;
        this.fim = null;
        this.quantidadeItens = 0;
        this.fechado = false;

        arvorePedido.inserir(this);
    }

    public String toString() {
        return this.codigo + ";" + this.quantidadeItens + ";" + tratarAtributo(String.valueOf(this.fechado));
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

    public void adicionarItem(Peca peca, int quantidade) {
        validarPedidoAberto();

        ItemPedido novoItem = new ItemPedido(peca, quantidade);

        if (inicio == null) {
            inicio = novoItem;
            fim = novoItem;
        } else {
            fim.setProximo(novoItem);
            fim = novoItem;
        }

        quantidadeItens++;
    }

    public boolean removerItem(int codigoPeca) {
        validarPedidoAberto();

        ItemPedido anterior = null;
        ItemPedido atual = inicio;

        while (atual != null && atual.peca.codigo != codigoPeca) {
            anterior = atual;
            atual = atual.getProximo();
        }

        if (atual == null) {
            return false;
        }

        if (anterior == null) {
            inicio = atual.getProximo();
        } else {
            anterior.setProximo(atual.getProximo());
        }

        if (atual == fim) {
            fim = anterior;
        }

        quantidadeItens--;
        return true;
    }

    public double calcularValorTotal() {
        double total = 0.0;
        ItemPedido atual = inicio;

        while (atual != null) {
            total += atual.calcularSubtotal();
            atual = atual.getProximo();
        }

        return total;
    }

    public void fecharPedido() {
        this.fechado = true;
    }

    public boolean estaFechado() {
        return fechado;
    }

    public int quantidadeDeItens() {
        return quantidadeItens;
    }

    public ItemPedido getInicio() {
        return inicio;
    }

    @Override
    public int getCodigo() {
        return this.codigo;
    }

    private void validarPedidoAberto() {
        if (fechado) {
            throw new IllegalStateException(
                    "Nao e possivel alterar um pedido fechado."
            );
        }
    }
}
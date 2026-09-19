package br.com.mecaniqa.entidades;

/**
 * Pedido implementado com uma lista simplesmente encadeada manual.
 */
public class Pedido {
    private static int contadorId = 1;

    public final int codigo;
    private ItemPedido inicio;
    private ItemPedido fim;
    private int quantidadeItens;
    private boolean fechado;

    public Pedido() {
        this.codigo = contadorId++;
        this.inicio = null;
        this.fim = null;
        this.quantidadeItens = 0;
        this.fechado = false;
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

    private void validarPedidoAberto() {
        if (fechado) {
            throw new IllegalStateException(
                    "Não é possível alterar um pedido fechado."
            );
        }
    }
}

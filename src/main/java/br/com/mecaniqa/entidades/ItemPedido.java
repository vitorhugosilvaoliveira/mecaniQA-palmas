package br.com.mecaniqa.entidades;

/**
 * Nó da lista encadeada de itens do pedido.
 * Guarda a peça, a quantidade solicitada e o próximo nó.
 */
public class ItemPedido {
    public final Peca peca;
    public final int quantidade;
    private ItemPedido proximo;

    public ItemPedido(Peca peca, int quantidade) {
        if (peca == null) {
            throw new IllegalArgumentException("A peça não pode ser nula.");
        }

        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
        }

        this.peca = peca;
        this.quantidade = quantidade;
        this.proximo = null;
    }

    public double calcularSubtotal() {
        return peca.precoVenda * quantidade;
    }

    /** Leitura liberada para quem precisar percorrer a lista (ex.: listagem). */
    public ItemPedido getProximo() {
        return proximo;
    }

    /** Escrita restrita ao pacote: só o Pedido pode religar os nós. */
    void setProximo(ItemPedido proximo) {
        this.proximo = proximo;
    }
}

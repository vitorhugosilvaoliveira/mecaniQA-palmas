package br.com.mecaniqa.entidades;

/**
 * Associa uma peça à quantidade solicitada em um pedido.
 */
public class ItemPedido {
    public final Peca peca;
    public final int quantidade;

    public ItemPedido(Peca peca, int quantidade) {
        if (peca == null) {
            throw new IllegalArgumentException("A peça não pode ser nula.");
        }
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
        }

        this.peca = peca;
        this.quantidade = quantidade;
    }

    public double calcularSubtotal() {
        return peca.precoVenda * quantidade;
    }
}

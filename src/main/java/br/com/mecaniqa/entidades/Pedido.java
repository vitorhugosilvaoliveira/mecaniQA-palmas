package br.com.mecaniqa.entidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Pedido de peças armazenado em uma coleção dinâmica.
 */
public class Pedido {
    private static int contadorId = 1;

    public final int codigo;
    private final List<ItemPedido> itens;
    private boolean fechado;

    public Pedido() {
        this.codigo = contadorId++;
        this.itens = new ArrayList<>();
        this.fechado = false;
    }

    /**
     * Adiciona uma peça e sua quantidade ao pedido.
     */
    public void adicionarItem(Peca peca, int quantidade) {
        validarPedidoAberto();
        itens.add(new ItemPedido(peca, quantidade));
    }

    /**
     * Remove o primeiro item que possuir o código de peça informado.
     */
    public boolean removerItem(int codigoPeca) {
        validarPedidoAberto();

        for (int i = 0; i < itens.size(); i++) {
            if (itens.get(i).peca.codigo == codigoPeca) {
                itens.remove(i);
                return true;
            }
        }

        return false;
    }

    /**
     * Soma o preço de venda de cada peça multiplicado pela quantidade pedida.
     */
    public double calcularValorTotal() {
        double total = 0.0;

        for (ItemPedido item : itens) {
            total += item.calcularSubtotal();
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
        return itens.size();
    }

    /**
     * Permite consultar os itens sem permitir alterações externas na lista.
     */
    public List<ItemPedido> getItens() {
        return Collections.unmodifiableList(itens);
    }

    private void validarPedidoAberto() {
        if (fechado) {
            throw new IllegalStateException(
                    "Não é possível alterar um pedido fechado.");
        }
    }
}

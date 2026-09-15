package br.com.mecaniqa.entidades;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    private Peca criarPeca(int codigo, double precoVenda) {
        return new Peca(codigo, "Peça " + codigo, "Fabricante",
                precoVenda / 2, precoVenda, 100);
    }

    @Test
    void deveAdicionarItensEmListaDinamicaECalcularTotal() {
        Pedido pedido = new Pedido();

        pedido.adicionarItem(criarPeca(1, 20.0), 2);
        pedido.adicionarItem(criarPeca(2, 15.5), 3);

        assertEquals(2, pedido.quantidadeDeItens());
        assertEquals(86.5, pedido.calcularValorTotal(), 0.001);
    }

    @Test
    void deveRemoverItemPeloCodigoDaPeca() {
        Pedido pedido = new Pedido();
        pedido.adicionarItem(criarPeca(1, 20.0), 2);

        assertTrue(pedido.removerItem(1));
        assertEquals(0, pedido.quantidadeDeItens());
        assertEquals(0.0, pedido.calcularValorTotal(), 0.001);
    }

    @Test
    void deveInformarQuandoItemNaoForEncontrado() {
        Pedido pedido = new Pedido();

        assertFalse(pedido.removerItem(999));
    }

    @Test
    void deveBloquearAdicaoERemocaoDepoisDoFechamento() {
        Pedido pedido = new Pedido();
        Peca peca = criarPeca(1, 20.0);
        pedido.adicionarItem(peca, 1);
        pedido.fecharPedido();

        assertTrue(pedido.estaFechado());
        assertThrows(IllegalStateException.class,
                () -> pedido.adicionarItem(peca, 1));
        assertThrows(IllegalStateException.class,
                () -> pedido.removerItem(peca.codigo));
    }

    @Test
    void deveRejeitarQuantidadeInvalida() {
        Pedido pedido = new Pedido();

        assertThrows(IllegalArgumentException.class,
                () -> pedido.adicionarItem(criarPeca(1, 20.0), 0));
    }
}

package br.com.mecaniqa.nos;

import br.com.mecaniqa.entidades.Pedido;
import br.com.mecaniqa.interfaces.No;

public class NoPedido implements No {
    public Pedido value;
    public NoPedido next;


    public NoPedido(Pedido value){
        this.value = value;
        this.next = null;
    }


    @Override
    public Pedido getValue() {
        return this.value;
    }

    @Override
    public NoPedido getProximo() {
        return this.next;
    }
}

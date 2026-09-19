package br.com.mecaniqa.nos;

import br.com.mecaniqa.entidades.Cliente;
import br.com.mecaniqa.interfaces.No;

public class NoCliente implements No {
    public Cliente value;
    public NoCliente next;

    public NoCliente(Cliente value){
        this.value = value;
        this.next = null;
    }

    @Override
    public Cliente getValue() {
        return this.value;
    }

    @Override
    public NoCliente getProximo() {
        return this.next;
    }
}

package br.com.mecaniqa.nos;

import br.com.mecaniqa.entidades.Carro;
import br.com.mecaniqa.interfaces.No;

public class NoCarro implements No {

    public Carro value;
    public NoCarro next;

    public NoCarro(Carro value){
        this.value = value;
        this.next = null;
    }

    @Override
    public Carro getValue() {
        return this.value;
    }

    @Override
    public NoCarro getProximo() {
        return this.next;
    }
}

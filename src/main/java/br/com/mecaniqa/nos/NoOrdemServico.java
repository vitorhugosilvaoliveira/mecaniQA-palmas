package br.com.mecaniqa.nos;

import br.com.mecaniqa.entidades.OrdemServico;
import br.com.mecaniqa.interfaces.No;

public class NoOrdemServico implements No {
    public OrdemServico ordem;
    public NoOrdemServico next;

    public NoOrdemServico(OrdemServico ordem){
        this.ordem = ordem;
        this.next = null;
    }

    @Override
    public OrdemServico getValue() {
        return this.ordem;
    }

    @Override
    public NoOrdemServico getProximo() {
        return this.next;
    }
}

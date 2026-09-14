package br.com.mecaniqa.nos;
import br.com.mecaniqa.entidades.Servico;

public class NoServico {
    public Servico velue;
    public NoServico next;

    public NoServico(Servico velue){
        this.velue = velue;
        this.next = null;
    }
}

package br.com.mecaniqa.entidades;

import br.com.mecaniqa.interfaces.Entidade;
import br.com.mecaniqa.nos.NoOrdemServico;
import br.com.mecaniqa.nos.NoServico;
import br.com.mecaniqa.enums.Status;

public class OrdemServico implements Entidade<OrdemServico> {
    public static int contadorId = 1;
    public final int codigo;
    public Status statusOrdeServico;
    public Servico servico;
    public int totalServico;
    public NoServico head = null;

    public static GerenciadorArvore<OrdemServico> gerenciarOrdemServico = new GerenciadorArvore<>();

    static{
            br.com.mecaniqa.csv.LeitorCsv.importar("OrdemServico");
    }

    public OrdemServico(Status tipoOrdeServico, Servico servico) {
        if(tipoOrdeServico == Status.FINALIZADO) {
            throw new IllegalArgumentException("Não é possível criar uma ordem de serviço com estado FINALIZADO.");
        }
        this.codigo = contadorId++;
        this.statusOrdeServico = tipoOrdeServico;
        this.servico = servico;
        if (servico != null) {
            gerenciarOrdemServico.inserir(this );
        }
        br.com.mecaniqa.csv.EscritorCsv.adicionarObjetoCsv(
                this,
                "./dados/OrdemServico.csv",
                "Codigo; Tipo de serviço; ID do servico;");
    }
    public OrdemServico(int codigo, Status tipoOrdeServico, Servico servico) {
        if(tipoOrdeServico == Status.FINALIZADO) {
            throw new IllegalArgumentException("Não é possível criar uma ordem de serviço com estado FINALIZADO.");
        }
        this.codigo = codigo;
        this.statusOrdeServico = tipoOrdeServico;
        this.servico = servico;
        if (servico != null) {
            gerenciarOrdemServico.inserir(this );
        }

        if(codigo >= contadorId){
            contadorId = codigo + 1;
        }
    }

    public String toString() {
        return this.codigo + ";" + this.statusOrdeServico + ";" + this.totalServico;
    }

    public static int quantidadeServico(OrdemServico ordem) {
        if (ordem != null) {
            return ordem.totalServico;
        }
        return 0;
    }

    public void atualizarStatus(Status novoStatus, FilaAtendimento fila) {
        this.statusOrdeServico = novoStatus;

        if (novoStatus == Status.AGUARDANDO_EXECUCAO) {
            NoServico atual = this.head;
            while (atual != null) {
                fila.enfileirar(atual.velue);
                atual = atual.next;
            }
        }
    }
    @Override
    public int getCodigo() {return this.codigo; }
}
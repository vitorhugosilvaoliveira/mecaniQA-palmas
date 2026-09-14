package br.com.mecaniqa.entidades;

import br.com.mecaniqa.nos.NoServico;
import br.com.mecaniqa.enums.Status;

public class OrdemServico {
    public static int contadorId = 1;
    public final int codigo;
    public Status statusOrdeServico;
    public Servico servico;
    public int totalServico;
    public NoServico head = null;

    public OrdemServico(Status tipoOrdeServico, Servico servico) {
        this.codigo = contadorId++;
        this.statusOrdeServico = tipoOrdeServico;
        this.servico = servico;
        if (servico != null) {
            appendServico(servico);
        }
    }

    public void appendServico(Servico servico) {
        NoServico novoNo = new NoServico(servico);
        if (head == null) {
            head = novoNo;
        } else {
            NoServico aux = head;
            while (aux.next != null) {
                aux = aux.next;
            }
            aux.next = novoNo;
        }
        this.totalServico++;
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
}
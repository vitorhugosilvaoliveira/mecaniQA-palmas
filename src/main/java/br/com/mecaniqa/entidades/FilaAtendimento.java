package br.com.mecaniqa.entidades;

import br.com.mecaniqa.nos.NoServico;

public class FilaAtendimento {
    private NoServico inicio = null;
    private NoServico fim = null;
    private int tamanho = 0;

    public void enfileirar(Servico servico) {
        NoServico novoNo = new NoServico(servico);

        if (estaVazia()) {
            this.inicio = novoNo;
            this.fim = novoNo;
        } else {
            this.fim.next = novoNo;
            this.fim = novoNo;
        }
        this.tamanho++;
    }

    public Servico desenfileirar() {
        if (estaVazia()) {//se a fila está vazia retorna uma exceção.
            throw new IllegalStateException("Nenhum serviço encontrado na fila.");
        }

        // Acessando o serviço e atualizando a fila
        Servico emAtendimento = this.inicio.velue;
        this.inicio = this.inicio.next;

        if (this.inicio == null) {
            this.fim = null;
        }

        this.tamanho--;
        return emAtendimento;
    }

    public boolean estaVazia() {//verifica o a fila está vazia
        return this.inicio == null;
    }

    public int filaTamanho() {
        return this.tamanho;
    }
}
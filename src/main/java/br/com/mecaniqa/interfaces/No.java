package br.com.mecaniqa.interfaces;

//interface criada com o intuito de ajudar a classe EscritorCsv a usar o metodo de atualização da lista encadeada
public interface No<T> {
    Object getValue();
    T getProximo();
}

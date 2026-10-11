package br.com.mecaniqa.arvore;

public interface Arvore<T> {

    public void inserir(T elemento);
    public boolean remover(int codigo);
    public T encontrar(int codigo);
}

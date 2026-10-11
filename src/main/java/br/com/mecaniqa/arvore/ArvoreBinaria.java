package br.com.mecaniqa.arvore;

import br.com.mecaniqa.interfaces.Entidade;
import br.com.mecaniqa.nos.NoArvore;

public class ArvoreBinaria<T extends Entidade<T>> implements Arvore<T> {

    public NoArvore<T> raiz;

    public ArvoreBinaria(){
        this.raiz = null;
    }

    @Override
    public void inserir(T elemento) {
        this.raiz = add(this.raiz, elemento);
    }

    private NoArvore<T> add(NoArvore<T> atual, T registro){
        //verifica se o registro é null
        if (registro == null){
            return null;
        }
        //verifica se a raiz é nula
        if (atual == null){
            return new NoArvore<>(registro.getCodigo(), registro);
        }
        //verifica se o codigo do registro é maior que o código do nó atual
        else if (atual.id < registro.getCodigo()){
            atual.direita = add(atual.direita, registro);
        }
        //verifica se o codigo do registro é menor que do nó atual
        else if (atual.id > registro.getCodigo()) {
            atual.esquerda = add(atual.esquerda,registro);
        }
        return atual;
    }

    @Override
    public boolean remover(int codigo) {
        this.raiz = delete(this.raiz,codigo);
        return false;
    }

    private NoArvore<T> delete(NoArvore<T> atual, int codigo){

        //o elemento não existe
        if (atual == null){
            return null;
        }
        if (atual.registro.getCodigo() == codigo){
            
            //deletando uma folha ou árvore que só tem a raiz
            if(atual.direita == null && atual.esquerda == null){
                return null;
            } //deletando nó com um filho
            else if (atual.esquerda == null) {
                return atual.direita;
            } else if (atual.direita == null) {
                return atual.esquerda;
            }
            //deletando um nó com dois filhos

            //encontra o nó com maior código na subarvore da esquerda
            T maiorCodigo = acharMaiorCodigo(atual.esquerda);
            //atribui o valor do registro de maior código da subarvore da esquerda ao nó deletado
            atual.registro = maiorCodigo;
            //deleta o nó que foi escolhido com maior código do local original
            atual.esquerda = delete(atual.esquerda, maiorCodigo.getCodigo());
        }
        //se o código for diferente, chama a função de delete até encontrar o igual
        else if (atual.registro.getCodigo() > codigo) {
            atual.direita = delete(atual.direita, codigo);
        }else {
            atual.esquerda = delete(atual.esquerda,codigo);
        }
        return atual;
    }

    private T acharMaiorCodigo(NoArvore<T> atual){
        return atual.direita != null ? acharMaiorCodigo(atual.direita) : atual.registro;
    }

    @Override
    public T encontrar(int codigo) {
        //bloco envolvido por try-catch para evitar o NullPointerException
        try {
            return find(codigo,this.raiz).registro;
        }catch (NullPointerException e){
            System.out.println("O código do registro procurado não existe");
        }
        return null;
    }

    private NoArvore<T> find(int codigo,NoArvore<T> atual){
        //verifica se o nó atual é nulo
        if (atual == null){
            return null;
        }
        //se o código for igual retorna o nó
        if (atual.id == codigo){
            return atual;
        }
        //se o código for menor, chama o metodo find para procurar na esquerda
        else if (atual.id > codigo){
            atual = find(codigo,atual.esquerda);
        }
        //se o código for maior, chama o metodo find para proccurar na direita
        else{
            atual = find(codigo,atual.direita);
        }
        return atual;
    }

    }

package br.com.mecaniqa.entidades;
import br.com.mecaniqa.arvore.ArvoreAVL;
import br.com.mecaniqa.interfaces.Entidade;
import br.com.mecaniqa.nos.NoArvore;

public class GerenciadorArvore<T extends Entidade<T> > {

    private ArvoreAVL<T> arvoreAvl;

    public GerenciadorArvore() {
        this.arvoreAvl = new ArvoreAVL<>();


    }
    public void inserir(T registro){
        this.arvoreAvl.inserir(registro);
    }

    public void remover(int codigo ){
        this.arvoreAvl.remover(codigo);

    }
    public T encontrar (int codigo){
        return  this.arvoreAvl.encontrar(codigo);
    }
    public void exibirOrdem(){
        pecorrer(this.arvoreAvl.raiz);

    }
    private void pecorrer(NoArvore<T> raiz){
        if(raiz != null){
            pecorrer(raiz.esquerda);
            if(raiz == this.arvoreAvl.raiz){
                System.out.println("--> Raiz <--  " + raiz.registro);

            }else{
                System.out.println(raiz.registro);
            }
            pecorrer(raiz.direita);

        }
    }

    public void exit() {
    }
}
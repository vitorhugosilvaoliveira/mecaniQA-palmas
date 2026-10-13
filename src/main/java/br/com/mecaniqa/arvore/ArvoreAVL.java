package br.com.mecaniqa.arvore;

import br.com.mecaniqa.interfaces.Entidade;
import br.com.mecaniqa.nos.NoArvore;

public class ArvoreAVL<T extends Entidade<T>> implements Arvore<T> {

    public NoArvore<T> raiz;

    public ArvoreAVL() {
        this.raiz = null;
    }

    // Função utilitária para obter a altura do nó
    private int altura(NoArvore<T> no) {
        if (no == null) return 0;
        return no.altura; // altura precisa iniciar um 1
    }

    // Função utilitária para obter o fator de balanceamento
    private int fatorBalanceamento(NoArvore<T> no) {
        if (no == null) return 0;
        return altura(no.esquerda) - altura(no.direita);
    }

    // Rotação à direita
    private NoArvore<T> rotacaoDireita(NoArvore<T> y) {
        NoArvore<T> x = y.esquerda;
        NoArvore<T> T2 = x.direita;

        x.direita = y;
        y.esquerda = T2;

        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;
        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;

        return x;
    }

    // Rotação à esquerda
    private NoArvore<T> rotacaoEsquerda(NoArvore<T> x) {
        NoArvore<T> y = x.direita;
        NoArvore<T> T2 = y.esquerda;

        y.esquerda = x;
        x.direita = T2;

        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;
        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;

        return y;
    }

    @Override
    public void inserir(T elemento) {
        this.raiz = add(this.raiz, elemento);
    }


    private NoArvore<T> add(NoArvore<T> atual, T registro) {
        if (registro == null) return null;

        if (atual == null) {
            return new NoArvore<>(registro.getCodigo(), registro);
        }

        if (atual.id < registro.getCodigo()) {
            atual.direita = add(atual.direita, registro);
        } else if (atual.id > registro.getCodigo()) {
            atual.esquerda = add(atual.esquerda, registro);
        } else {
            return atual; // Códigos iguais não são inseridos novamente
        }

        // Atualiza a altura do nó ancestral
        atual.altura = 1 + Math.max(altura(atual.esquerda), altura(atual.direita));

        // Verifica o balanceamento
        int balanceamento = fatorBalanceamento(atual);

        // Casos de Rotação
        // Esquerda Esquerda
        if (balanceamento > 1 && registro.getCodigo() < atual.esquerda.id)
            return rotacaoDireita(atual);

        // Direita Direita
        if (balanceamento < -1 && registro.getCodigo() > atual.direita.id)
            return rotacaoEsquerda(atual);

        // Esquerda Direita
        if (balanceamento > 1 && registro.getCodigo() > atual.esquerda.id) {
            atual.esquerda = rotacaoEsquerda(atual.esquerda);
            return rotacaoDireita(atual);
        }

        // Direita Esquerda
        if (balanceamento < -1 && registro.getCodigo() < atual.direita.id) {
            atual.direita = rotacaoDireita(atual.direita);
            return rotacaoEsquerda(atual);
        }

        return atual;
    }

    @Override
    public boolean remover(int codigo) {
        // Adaptado para retornar booleano corretamente verificando se a raiz mudou ou se o nó existe
        T noRemover = encontrar(codigo);
        if(noRemover != null) {
            this.raiz = delete(this.raiz, codigo);
            return true;
        }
        return false;
    }


    private NoArvore<T> delete(NoArvore<T> atual, int codigo) {
        if (atual == null) {
            return null;
        }

        if (atual.id > codigo) {
            atual.esquerda = delete(atual.esquerda, codigo);
        } else if (atual.id < codigo) {
            atual.direita = delete(atual.direita, codigo);
        } else {
            // Nó com um ou nenhum filho
            if ((atual.esquerda == null) || (atual.direita == null)) {
                NoArvore<T> temp = null;
                if (temp == atual.esquerda)
                    temp = atual.direita;
                else
                    temp = atual.esquerda;

                if (temp == null) {
                    temp = atual;
                    atual = null;
                } else {
                    atual = temp;
                }
            } else {
                // Nó com dois filhos
                T maiorCodigo = acharMaiorCodigo(atual.esquerda);
                atual.registro = maiorCodigo;
                atual.id = maiorCodigo.getCodigo();
                atual.esquerda = delete(atual.esquerda, maiorCodigo.getCodigo());
            }
        }

        if (atual == null) return null;

        // Atualiza a altura
        atual.altura = Math.max(altura(atual.esquerda), altura(atual.direita)) + 1;

        // Verifica o balanceamento
        int balanceamento = fatorBalanceamento(atual);

        // Casos de Rotação na Remoção
        // Esquerda Esquerda
        if (balanceamento > 1 && fatorBalanceamento(atual.esquerda) >= 0)
            return rotacaoDireita(atual);

        // Esquerda Direita
        if (balanceamento > 1 && fatorBalanceamento(atual.esquerda) < 0) {
            atual.esquerda = rotacaoEsquerda(atual.esquerda);
            return rotacaoDireita(atual);
        }

        // Direita Direita
        if (balanceamento < -1 && fatorBalanceamento(atual.direita) <= 0)
            return rotacaoEsquerda(atual);

        // Direita Esquerda
        if (balanceamento < -1 && fatorBalanceamento(atual.direita) > 0) {
            atual.direita = rotacaoDireita(atual.direita);
            return rotacaoEsquerda(atual);
        }

        return atual;
    }


    private T acharMaiorCodigo(NoArvore<T> atual) {
        return atual.direita != null ? acharMaiorCodigo(atual.direita) : atual.registro;
    }

    @Override
    public T encontrar(int codigo) {
        try {
            return find(codigo, this.raiz).registro;
        } catch (NullPointerException e) {
            System.out.println("O código do registro procurado não existe");
        }
        return null;
    }


    private NoArvore<T> find(int codigo, NoArvore<T> atual) {
        if (atual == null) { //[cite: 2]
            return null;
        }
        if (atual.id == codigo) {
            return atual;
        } else if (atual.id > codigo) {
            return find(codigo, atual.esquerda);
        } else {
            return find(codigo, atual.direita);
        }
    }
}

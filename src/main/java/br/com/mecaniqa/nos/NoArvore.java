package br.com.mecaniqa.nos;
import br.com.mecaniqa.interfaces.Entidade;

public class NoArvore <T extends Entidade<T>> {
    public T registro;
    public int id;
    public int altura = 1;
    public NoArvore<T> esquerda;
    public NoArvore<T> direita;

    public NoArvore(int id, T registro) {
        this.id = id;
        this.registro = registro;
    }
}

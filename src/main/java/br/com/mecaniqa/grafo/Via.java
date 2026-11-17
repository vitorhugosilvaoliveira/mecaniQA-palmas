package br.com.mecaniqa.grafo;

import java.util.Objects;
import java.util.StringJoiner;

public class Via {

    public Local origem;
    public Local destino;

    public Via(Local origem, Local destino){
        this.origem = origem;
        this.destino = destino;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Via.class.getSimpleName() + "[", "]")
                .add("origem=" + origem)
                .add("destino=" + destino)
                .toString();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Via via = (Via) object;
        boolean mesmaOrdem = Objects.equals(origem, via.origem) && Objects.equals(destino, via.destino);
        boolean ordemInvertida = Objects.equals(origem, via.destino) && Objects.equals(destino, via.origem);
        return mesmaOrdem || ordemInvertida;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(origem) + Objects.hashCode(destino);
    }
}

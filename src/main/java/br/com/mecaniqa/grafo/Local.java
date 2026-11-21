package br.com.mecaniqa.grafo;

import java.util.Objects;

public class Local {

    public String nome;

    public Local(String nome){
        this.nome = nome;
    }

    @Override
    public String toString() {
        return this.nome;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Local local = (Local) object;
        return Objects.equals(nome, local.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }
}

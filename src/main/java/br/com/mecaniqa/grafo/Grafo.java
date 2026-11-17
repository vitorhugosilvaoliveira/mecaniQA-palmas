package br.com.mecaniqa.grafo;

import java.math.BigDecimal;
import java.util.*;

public class Grafo {
    // Mapas usados para armazenar o conjunto de locais e vias do grafo
    public Map<Local, List<Local>> localizacoes;
    public Map<Via, BigDecimal> distancias;

    //construtor que inicializa os mapas para serem preechidos
    public Grafo(){
        this.localizacoes = new HashMap<>();
        this.distancias = new HashMap<>();
    }

    public void addLocal(String nome){
        // Insere o local no mapa como chave e inicializa sua lista de adjacência
        localizacoes.putIfAbsent(new Local(nome), new ArrayList<>());
    }

    public void inserirRota(String local1, String local2, BigDecimal distancia){
        // Insere os locais no mapa
        addLocal(local1);
        addLocal(local2);
        // Cria o par de locais da via que os conecta
        Local localA = new Local(local1);
        Local localB = new Local(local2);
        //Cria a via
        Via via = new Via(localA,localB);

        // Acessa a lista de adjacência por meio da chave(local) e insere o local vizinho na lista
        this.localizacoes.get(localA).add(localB);
        this.localizacoes.get(localB).add(localA);
        // Insere a via no mapa com seu peso correspondente
        this.distancias.put(via,distancia);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Grafo.class.getSimpleName() + "[", "]")
                .add("localizacoes=" + localizacoes)
                .add("pesos=" + distancias)
                .toString();
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Grafo grafo = (Grafo) object;
        return Objects.equals(localizacoes, grafo.localizacoes) && Objects.equals(distancias, grafo.distancias);
    }

}

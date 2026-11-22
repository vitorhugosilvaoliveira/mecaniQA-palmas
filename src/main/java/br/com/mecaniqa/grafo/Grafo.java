package br.com.mecaniqa.grafo;
import java.util.*;

public class Grafo {
    // Mapas usados para armazenar o conjunto de locais e vias do grafo
    public Map<Local, List<Local>> localizacoes;
    public Map<Via, Double> pesos;

    public static Grafo instancia = new Grafo();

    static {
        br.com.mecaniqa.csv.LeitorCsv.importar("Rotas");
    }

    //construtor que inicializa os mapas para serem preechidos
    public Grafo(){
        this.localizacoes = new HashMap<>();
        this.pesos = new HashMap<>();
    }

    public void addLocal(String nome){
        // Insere o local no mapa como chave e inicializa sua lista de adjacência
        localizacoes.putIfAbsent(new Local(nome), new ArrayList<>());
    }

    public void inserirRota(String local1, String local2, double distancia){
        // Insere os locais no mapa
        addLocal(local1);
        addLocal(local2);
        // Cria o par de locais da via que os conecta
        Local localA = new Local(local1);
        Local localB = new Local(local2);
        //Cria a via
        Via via = new Via(localA,localB);
        Via viaVolta = new Via(localB,localA);

        // Acessa a lista de adjacência por meio da chave(local) e insere o local vizinho na lista
        this.localizacoes.get(localA).add(localB);
        this.localizacoes.get(localB).add(localA);
        // Insere a via no mapa com seu peso correspondente
        this.pesos.put(via,distancia);
        this.pesos.put(viaVolta,distancia);
    }
    // Devolve os pesos das arestas (vias)
    public double getPeso(Local origem, Local destino){
        Via via = new Via(origem, destino);
        return pesos.get(via);
    }
    // Devolve os vizinhos de um vértice(local)
    public List<Local> getVizinhos(String nome){
        Local local = new Local(nome);
        return localizacoes.get(local);
    }
    // Devolve o conjunto de vértices(locais) do grafo
    public Set<Local> getLocalizacoes(){
        return localizacoes.keySet();
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Grafo.class.getSimpleName() + "[", "]")
                .add("localizacoes=" + localizacoes)
                .add("pesos=" + pesos)
                .toString();
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Grafo grafo = (Grafo) object;
        return Objects.equals(localizacoes, grafo.localizacoes) && Objects.equals(pesos, grafo.pesos);
    }

}

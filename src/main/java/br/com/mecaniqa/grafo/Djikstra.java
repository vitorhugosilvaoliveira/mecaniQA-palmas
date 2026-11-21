package br.com.mecaniqa.grafo;

import java.util.*;

public class Djikstra {
    // Guarda os locais com suas distancias da origem (Centro_Distribuicao)
    public Map<Local, Double> distancias = new HashMap<>();
    // Guarda o predecessor de cada local
    public Map<Local, Local> predecessores = new HashMap<>();
    // Guarda os locais visitados
    public Set<Local> visitados = new HashSet<>();

    // Metodo principal que realiza o algoritmo
    public void inicializar(Grafo rotas, String origem){
        // Limpa os mapas antes de inicializar
        this.distancias.clear();
        this.predecessores.clear();
        this.visitados.clear();

        // Define o vértice de origem, no caso, Centro_Distribuicao
        Local origemGrafo = new Local(origem);

        // Percorre o conjunto de vértices do grafo
        for (Local local : rotas.getLocalizacoes()){
            // Para cada vértice do grafo, coloque a distancia do vértice no mapa com o valor infinito
            this.distancias.put(local, Double.POSITIVE_INFINITY);
        }
        // Defina a distancia da origem como 0
        this.distancias.put(origemGrafo,0.0);

        // Loop para achar os menores caminhos desde a origem
        while (visitados.size() < rotas.getLocalizacoes().size()){
            Local menor = null;
            // Para cada vértice no mapa de distancias
            for (Local local: this.distancias.keySet()){
                // Verifica se o local já foi visitado
                if (!visitados.contains(local)
                        && (menor == null || distancias.get(local) < distancias.get(menor))){
                    // Se o vértice não foi visitado e sua distancia é a menor conhecida (variavel menor), então ele é o menor no momento
                    menor = local;
                }
            }
            if (menor == null || distancias.get(menor) == Double.POSITIVE_INFINITY){
                break;
            }
            // Adiciona o vértice de menor distancia nos visitados
            visitados.add(menor);

            // Percorre pelos vértices vizinhos do menor encontrado
            for (Local vizinho: rotas.getVizinhos(menor.nome)){
                // Soma a distancia do vértice a origem com a distancia do vértice ao seu vizinho
                double distanciaNova = distancias.get(menor) + rotas.getPeso(menor,vizinho);
                // Se a soma das distancias for menor que que o caminho direto da origem para esse vértice vizinho
                // Ele atualiza a distancia mais curta no mapa e tambem seu predecessor
                if (distanciaNova < distancias.get(vizinho)){
                    distancias.put(vizinho, distanciaNova);
                    predecessores.put(vizinho, menor);
                }
            }
        }

    }

    public Map<Local, Double> getDistancias(){
        return this.distancias;
    }

    // Guarda o caminho realizado pelo algoritmo para chegar no destino
    public List<Local> getCaminho(Local destino){
        // Pilha para armazenar os vértices na ordem inversa
        Deque<Local> caminhoInverso = new ArrayDeque<>();
        // Lista que guardará os vertices na ordem correta e será retornada
        List<Local> caminho = new ArrayList<>();

        if (distancias.get(destino) == Double.POSITIVE_INFINITY){
            return caminho;
        }
        // Coloca numa pilha os caminhos de forma inversa
        Local atual = destino;
        while (atual != null){
            caminhoInverso.push(atual);
            atual = predecessores.get(atual);
        }
        // Pega o caminho inverso e faz o pop na ordem colocando na lista do caminho na ordem certa
        while (!caminhoInverso.isEmpty()){
            caminho.add(caminhoInverso.pop());
        }
        return caminho;
    }

}

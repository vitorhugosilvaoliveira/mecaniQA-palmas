package br.com.mecaniqa.csv;

import br.com.mecaniqa.entidades.*;
import br.com.mecaniqa.enums.Categoria;
import br.com.mecaniqa.enums.Status;
import br.com.mecaniqa.grafo.Grafo;
import java.math.BigDecimal;

public class CriadorObjeto {

    public static void criarObjeto(String[] atributos, String arquivo){
        Grafo grafo = new Grafo();
        switch (arquivo){
            case "./dados/Pecas.csv" -> new Peca(
                    Integer.parseInt(atributos[0]),
                    atributos[1],
                    atributos[2],
                    Double.parseDouble(atributos[3]),
                    Double.parseDouble(atributos[4]),
                    Integer.parseInt(atributos[5])
            );

            case "./dados/Servicos.csv" -> new Servico(
                        Integer.parseInt(atributos[0]) ,
                        atributos[1],
                        Integer.parseInt(atributos[2]),
                        Double.parseDouble(atributos[3])
            );
            case "./dados/Clientes.csv" -> new Cliente(
                    Integer.parseInt(atributos[0]),
                    atributos[1],
                    atributos[2],
                    atributos[3]
            );
            case "./dados/Carros.csv" -> new Carro(
                    Integer.parseInt(atributos[0]),
                    atributos[1],
                    atributos[2],
                    Integer.parseInt(atributos[3]),
                    atributos[4],
                    Categoria.valueOf(atributos[5]),
                    Integer.parseInt(atributos[6])
            );
            case "./dados/OrdemServico.csv" -> new OrdemServico(
                    Integer.parseInt(atributos[0]),
                    Status.valueOf(atributos[1]),
                    Servico.arvoreServico.encontrar(Integer.parseInt(atributos[2]))
            );

            case "./dados/Pedidos.csv" -> new Pedido();

            case "./dados/Rotas.csv" -> grafo.inserirRota(
                    atributos[0],
                    atributos[1],
                    BigDecimal.valueOf(Long.parseLong(atributos[2]))
            );
        }
    }
}

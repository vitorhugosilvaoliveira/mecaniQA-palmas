package br.com.mecaniqa;

import br.com.mecaniqa.csv.EscritorCsv;
import br.com.mecaniqa.csv.LeitorCsv;
import br.com.mecaniqa.entidades.Carro;
import br.com.mecaniqa.entidades.Cliente;
import br.com.mecaniqa.entidades.GerenciadorArvore;
import br.com.mecaniqa.enums.Categoria;

public class Main {

    public static void main(String[] args) {
        LeitorCsv.importar("Pecas");
        EscritorCsv.exportar("Pecas");

       Cliente cliente1 = new Cliente("matheus","759681316","ansdjbakdb@gmail.com");
       Cliente cliente2 = new Cliente("felas","70351651316","15135asdas@gmail.com");
       Cliente cliente3 = new Cliente("bichodoido","721513316","aksdhsvajabs@gmail.com");

        GerenciadorArvore<Cliente>  gerenciador = new GerenciadorArvore<>();
        gerenciador.inserir(cliente1);
        gerenciador.inserir(cliente2);
        gerenciador.inserir(cliente3);
        gerenciador.exibirOrdem();

        System.out.println("------------------------------------------------------------------");

        Carro carro1  = new Carro("fiat","las5s68",2023,"asnf,b", Categoria.SEDAN,1);
        Carro carro2  = new Carro("BMW","asdasda",2028,"san", Categoria.SEDAN,2);
        Carro carro3  = new Carro("Pegault","las5s6asf8",2020,"dan", Categoria.SEDAN,3);

        Carro.arvoreCarro.exibirOrdem();
    }
}

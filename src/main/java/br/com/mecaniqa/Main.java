package br.com.mecaniqa;

import br.com.mecaniqa.csv.EscritorCsv;
import br.com.mecaniqa.csv.LeitorCsv;
import br.com.mecaniqa.entidades.Carro;
import br.com.mecaniqa.entidades.Cliente;
import br.com.mecaniqa.entidades.Gerenciador;
import br.com.mecaniqa.entidades.GerenciadorArvore;
import br.com.mecaniqa.enums.Categoria;

public class Main {

    public static void main(String[] args) {
        LeitorCsv.importar("Carros");
        Carro.arvoreCarro.exibirOrdem();
        EscritorCsv.exportar("Carros");

    }
}


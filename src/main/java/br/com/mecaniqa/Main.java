package br.com.mecaniqa;

import br.com.mecaniqa.csv.EscritorCsv;
import br.com.mecaniqa.entidades.*;
import br.com.mecaniqa.enums.Categoria;
import br.com.mecaniqa.enums.Status;

public class Main {

    public static void main(String[] args) {

    }

    private static void exportarPecaCsv(){

        final String arquivoPecas = "./dados/Pecas.csv";
        final String cabecalhoPecas = "Código; Nome; Fabricante; Preço de custo; Preço de venda; Quantidade";

        EscritorCsv.atualizarEstaticoCsv(Gerenciador.pecas,arquivoPecas,cabecalhoPecas);
    }

    private static void exportarServicoCsv(){
        final String arquivo = "./dados/Servicos.csv";
        final String cabecalho = "Código; Descrição; Tempo (minutos); Valor";

        EscritorCsv.atualizarEstaticoCsv(Gerenciador.servicos,arquivo,cabecalho);
    }

    private static void exportarClienteCsv(){
        final String arquivo = "./dados/Clientes.csv";
        final String cabecalho = "Código; Nome; Telefone; Email";

        EscritorCsv.atualizarDinamicoCsv(Cliente.head,arquivo,cabecalho);
    }

    private static void exportarOsCsv(){
        final String arquivo = "./dados/Ordens de servico.csv";
        final String cabecalho = "Código; Status; Total de servicos";

        EscritorCsv.atualizarDinamicoCsv(OrdemServico.inicio,arquivo,cabecalho);
    }

    private static void exportarCarroCsv(){
        final String arquivo = "./dados/Carros.csv";
        final String cabecalho = "Modelo; Placa; Total de servicos";

        EscritorCsv.atualizarDinamicoCsv(Carro.inicio,arquivo,cabecalho);
    }

}


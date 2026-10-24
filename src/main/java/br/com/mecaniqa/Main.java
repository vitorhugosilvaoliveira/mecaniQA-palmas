package br.com.mecaniqa;

import br.com.mecaniqa.csv.EscritorCsv;
import br.com.mecaniqa.csv.LeitorCsv;
import br.com.mecaniqa.entidades.*;
import br.com.mecaniqa.enums.Categoria;
import br.com.mecaniqa.enums.Status;

public class Main {

    public static void main(String[] args) {
        LeitorCsv.importar("Carros");
        Carro.arvoreCarro.exibirOrdem();
        EscritorCsv.exportar("Carros");

        System.out.println("------------------------------------------------------------------");

        Cliente cliente1 = new Cliente("matheus","759681316","ansdjbakdb@gmail.com");
        Cliente cliente2 = new Cliente("felas","70351651316","15135asdas@gmail.com");
        Cliente cliente3 = new Cliente("bichodoido","721513316","aksdhsvajabs@gmail.com");

        Cliente.inserirCliente.exibirOrdem();

        System.out.println("------------------------------------------------------------------");

        Carro carro1  = new Carro("fiat","las5s68",2023,"asnf,b", Categoria.SEDAN,1);
        Carro carro2  = new Carro("BMW","asdasda",2028,"san", Categoria.SEDAN,2);
        Carro carro3  = new Carro("Pegault","las5s6asf8",2020,"dan", Categoria.SEDAN,3);

        Carro.arvoreCarro.exibirOrdem();

        System.out.println("------------------------------------------------------------------");

        Servico serv1 = new Servico("realizar a troca do motor", 240,15000.00);
        Servico serv2 = new Servico("realizar a troca da pastilha de freio ",60 ,15000.00);
        Servico serv3 = new Servico("realizar a troca do catalizador ", 120,15000.00);

        Servico.arvoreServico.exibirOrdem();

        System.out.println("------------------------------------------------------------------");

        OrdemServico OS1 = new OrdemServico(Status.EM_ABERTO, serv1);
        OrdemServico OS2 = new OrdemServico(Status.AGUARDANDO_EXECUCAO, serv2);
        OrdemServico OS3 = new OrdemServico(Status.EM_EXECUCAO, serv3);

        OrdemServico.gerenciarOrdemServico.exibirOrdem();
    }
}

package br.com.mecaniqa;

import static br.com.mecaniqa.Peca.pecas;
import static br.com.mecaniqa.Peca.totalPecas;

public class Gerenciador {

    public static void main(String[] args) {

        Peca pc1= new Peca(1, "parafuso", "Bosch", 2.50, 5.00, 100);
        Peca pc2= new Peca(2,"chave estrela","Phillips",3.00,6.50,50);
        Servico serv1 = new Servico(1,"manuntenção do motor do carro",65,300.00);
        Servico serv2 = new Servico(2,"manuntenção do motor do moto",30,150.00);

        Peca.inserirPeca(pc1);
        Peca.inserirPeca(pc2);
        Servico.inserirServico(serv1);
        Servico.inserirServico(serv2);
        Servico.mostrarServico();
        //Servico.deletarServico(serv1);
        Servico.mostrarServico();
        Servico.mudarServico(1,"Troca do oleo do carro.", 45,160.45);
        Servico.mostrarServico();

        Peca.inserirPeca(pc1);
        Peca.mostrarPeca();
        Peca.deletarPeca(2);
        Peca.mostrarPeca();
        Peca.totalPecas();
        Peca.mudarPeca(1,"chave de roda",15.90,100);
        Peca.mostrarPeca();
    }

}


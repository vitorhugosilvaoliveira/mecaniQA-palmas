package br.com.mecaniqa;

import static br.com.mecaniqa.Peca.pecas;

public class Gerenciador {
    public static void main(String[] args) {

        Peca pc1= new Peca(1, "parafuso", "Bosch", 2.50, 5.00, 100);
        Peca pc2= new Peca(2,"chave estrela","Phillips",3.00,6.50,50);
        Servico serv1 = new Servico(1,"manuntenção do motor do carro",65,300.00);
        Servico serv2 = new Servico(2,"troca de oleo do motor", 35, 150.55);

        Peca.inserirPeca(pc1);
        Peca.inserirPeca(pc2);
        Peca.deletarPeca(pc2);
        Peca.inserirPeca(pc1);
        Peca.mostrarPeca();
        Servico.inserirServico(serv1);
        Servico.mostrarServico();
        Servico.deletarServico(serv1);
        Servico.mostrarServico();
        Servico.inserirServico(serv2);
        Servico.mostrarServico();

    }

}


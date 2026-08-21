package br.com.mecaniqa;

import static br.com.mecaniqa.Peca.pecas;

public class Gerenciador {

    public static void main(String[] args) {

        Peca pc1= new Peca(1, "parafuso", "Bosch", 2.50, 5.00, 100);
        Peca pc2= new Peca(2,"chave estrela","Phillips",3.00,6.50,50);
        Servico serv1 = new Servico(1,"manuntenção do motor do carro",65,300.00);
        Peca pc3 = new Peca(3,"chave inglesa","Kingtony",3.98,6.50,40);
        Peca pc4 = new Peca(4,"parafusadeira","Bosch",89.00,125.00,30);
        Peca pc5 = new Peca(5,"chave combinada","Chavex",4.50,6.80,60);

        Peca.inserirPeca(pc1);
        Peca.inserirPeca(pc2);
        Peca.inserirPeca(pc3);
        Peca.inserirPeca(pc4);
        Peca.deletarPeca(2);
        Peca.inserirPeca(pc5);
        System.out.println(Peca.buscarPeca(pc4));

    }
}


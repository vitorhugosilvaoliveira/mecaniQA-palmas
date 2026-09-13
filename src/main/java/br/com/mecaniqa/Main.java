package br.com.mecaniqa;

import br.com.mecaniqa.entidades.*;
import br.com.mecaniqa.enums.Categoria;

public class Main {

    public static void main(String[] args) {

        Peca pc1= new Peca(1, "parafuso", "Bosch", 2.50, 5.00, 100);
        Peca pc2= new Peca(2,"chave estrela","Phillips",3.00,6.50,50);
        Servico serv1 = new Servico(1,"manuntenção do motor do carro",65,300.00);
        Servico serv2 = new Servico(2,"manuntenção do motor do moto",30,150.00);

        Cliente cliente1 = new Cliente("Márcio Andrade","75634908","Andramarc@gamil.com");
        Cliente cliente2 = new Cliente("Renata Silva","75634908","Andramarc@gamil.com");
        Cliente cliente3 = new Cliente("Ana souza","75634908","Andramarc@gamil.com");

        System.out.println(cliente2.codigo);

        Carro carro = new Carro("Fiat Uno","123abc",2003,"basico",Categoria.HATCH ,cliente1.codigo);

        System.out.println(carro.codigoDono);

        Gerenciador.inserirServico(serv1);
        Gerenciador.inserirServico(serv2);
        Gerenciador.mostrarServico();
        Gerenciador.deletarServico(serv1);
        Gerenciador.mostrarServico();
        Gerenciador.inserirServico(serv1);
        Gerenciador.mudarServico(1,"Troca do oleo do carro.", 45,160.45);
        Gerenciador.mostrarServico();
        Gerenciador.totalServicos();


        Gerenciador.inserirPeca(pc1);
        Gerenciador.inserirPeca(pc2);
        Gerenciador.mostrarPeca();
        Gerenciador.deletarPeca(1);
        Gerenciador.mostrarPeca();
        Gerenciador.inserirPeca(pc1);
        Gerenciador.totalPecas();
        Gerenciador.mudarPeca(1,"chave de roda",15.90,100);
        Gerenciador.mostrarPeca();
    }

}


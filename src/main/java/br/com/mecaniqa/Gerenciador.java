package br.com.mecaniqa;

public class Gerenciador {

        private static final int MAX_PECAS = 100;
        private static final int MAX_SERVICOS = 50;


        public static Peca[] pecas = new Peca[MAX_PECAS];
        private static Servico[] servicos = new Servico[MAX_SERVICOS];

        private static int totalPecas = 0;
        private static int totalServicos = 0;
    public static void main(String[] args) {

        inserirPeca(new Peca(1, "parafuso", "Bosch", 2.50, 5.00, 100));

        for (int i = 0; i < totalPecas; i++) {
            System.out.println("Índice " + i + ": " +
                    "Código: " + pecas[i].codigo +
                    " | Nome: " + pecas[i].nomePeca +
                    " | Preço: R$ " + pecas[i].precoVenda +
                     " | Quantidade: " + pecas[i].quantidade);
        }
    }
    public static void inserirPeca(Peca nome){
        if(totalPecas < MAX_PECAS){
            pecas[totalPecas] = nome;
            totalPecas++;
        }else{
            System.out.println("Array cheio!");
        }
    }
}


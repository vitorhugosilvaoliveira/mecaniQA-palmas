public class Gerenciador{
    private static final int MAX_PECAS = 100;
    private static final int MAX_SERVICOS = 50;

    
    private static Peca[] pecas = new Peca[MAX_PECAS];
    private static Servico[] servicos = new Servico[MAX_SERVICOS];

    private static int totalPecas = 0;
    private static int totalServicos = 0;
}
public static void main(String[] args) {
    for (int i = 0; i < pecas.length; i++) {
        System.out.println("Índice " + i + ": " + pecas[i]);
    }
}
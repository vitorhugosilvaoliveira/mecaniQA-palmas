package br.com.mecaniqa.grafo;
import br.com.mecaniqa.entidades.ItemPedido;
import br.com.mecaniqa.entidades.OrdemServico;
import br.com.mecaniqa.entidades.Pedido;

import java.util.Scanner;

public class MenuLogisticaEntrega {

    public static void menuLogisticaEntrega(Scanner scanner) {
        System.out.println("\n=== LOGÍSTICA DE ENTREGA ===");
        System.out.println("Locais cadastrados:");
        for (Local local : Grafo.instancia.getLocalizacoes()) {
            System.out.println(" - " + local);
        }

        System.out.print("Informe a filial de destino: ");
        String destinoNome = scanner.nextLine().trim();

        Local origem = new Local("Centro_Distribuicao");
        Local destino = new Local(destinoNome);

        if (!Grafo.instancia.getLocalizacoes().contains(destino)) {
            System.out.println("Filial de destino não encontrada no mapa.");
            return;
        }

        Djikstra djikstra = new Djikstra();
        djikstra.inicializar(Grafo.instancia, origem.toString());
        djikstra.exibirRotaCompleta(Grafo.instancia, origem, destino);

        System.out.print("Deseja vincular (1) Pedido, (2) Ordem de Serviço ou (0) Nenhum? ");
        int opcao = Integer.parseInt(scanner.nextLine().trim());

        if (opcao == 1) {
            System.out.print("Informe o ID do Pedido: ");
            int idPedido = Integer.parseInt(scanner.nextLine().trim());

            Pedido pedido = Pedido.arvorePedido.encontrar(idPedido);
            if (pedido != null) {
                System.out.println("Peças enviadas no caminhão (Pedido #" + pedido.getCodigo() + "):");
                ItemPedido atual = pedido.getInicio();
                if (atual == null) {
                    System.out.println("  - Nenhuma peça cadastrada neste pedido.");
                }
                while (atual != null) {
                    System.out.println("  - " + atual);
                    atual = atual.getProximo();
                }
            } else {
                System.out.println("Pedido não encontrado na árvore.");
            }
        } else if (opcao == 2) {
            System.out.print("Informe o ID da Ordem de Serviço: ");
            int idOs = Integer.parseInt(scanner.nextLine().trim());

            OrdemServico os = OrdemServico.gerenciarOrdemServico.encontrar(idOs);
            if (os != null) {
                System.out.println("Detalhes/serviço da Ordem de Serviço #" + os.getCodigo() + ":");
                System.out.println("  - " + os);
            } else {
                System.out.println("Ordem de Serviço não encontrada na árvore.");
            }
        }
    }
}

package br.com.mecaniqa.csv;

import br.com.mecaniqa.entidades.*;
import br.com.mecaniqa.interfaces.Entidade;
import br.com.mecaniqa.nos.NoArvore;

import java.io.*;

public class EscritorCsv {

    public static void exportar(String nomeArquivo){
        switch (nomeArquivo){
            case "Clientes" -> atualizarDinamicoCsv(Cliente.arvoreCliente.arvoreAvl.raiz,"./dados/Clientes.csv","Código; Nome; Telefone; Email");
            case "Carros" -> atualizarDinamicoCsv(Carro.arvoreCarro.arvoreAvl.raiz,"./dados/Carros.csv","Código; Modelo; Placa; Ano; Estilo carroceria; Categoria; Id do proprietário;");
            case "Pecas" -> atualizarDinamicoCsv(Peca.arvorePeca.arvoreAvl.raiz,"./dados/Pecas.csv","Código; Nome; Fabricante; Preço de custo; Preço de venda; Quantidade");
            case "Servicos" -> atualizarDinamicoCsv(Servico.arvoreServico.arvoreAvl.raiz,"./dados/Servicos.csv","Código; Descrição; Tempo (minutos); Valor");
            case "Pedidos" -> atualizarDinamicoCsv(Pedido.arvorePedido.arvoreAvl.raiz,"./dados/Pedidos.csv","Código; Quantidade de itens; Status (fechado)");
            case "Ordens de servico" -> atualizarDinamicoCsv(OrdemServico.gerenciarOrdemServico.arvoreAvl.raiz,"./dados/OrdemServico.csv","Codigo; Tipo de serviço; ID do servico");
        }
    }
    private static boolean verificarPasta(File arquivo){
        File pasta = arquivo.getParentFile();

        //verifica se a pasta já existe e se não, cria
        if(pasta != null && !pasta.exists()){
            boolean criada = pasta.mkdirs();
            if (!criada){
                System.out.println("Erro ao criar pasta");
                return false;
            }
        }
        return true;
    }

    public static void atualizarEstaticoCsv(Object[] lista, String caminhoArquivo, String cabecalho){

        if (lista.length == 0){
            System.out.println("Lista vazia");
            return;
        }

        File arquivo = new File(caminhoArquivo);
        if (!verificarPasta(arquivo)) return;

        try(FileWriter escritor = new FileWriter(caminhoArquivo,false); PrintWriter pw = new PrintWriter(escritor)){

            escritor.write('\uFEFF');
            pw.println(cabecalho);

            for (Object elemento : lista){
                if (elemento != null){
                    //adiciona a linha no arquivo csv com toString interno
                    pw.println(elemento);
                }
            }
        }
        catch (IOException e){
            System.err.println("Erro ao atualizar : " + e.getMessage());
        }
    }

    public static <T extends Entidade<T>> void atualizarDinamicoCsv(NoArvore<T> inicio, String caminhoArquivo, String cabecalho){

        File arquivo = new File(caminhoArquivo);
        if (!verificarPasta(arquivo)) return;

        try(FileWriter escritor = new FileWriter(caminhoArquivo,false); PrintWriter pw = new PrintWriter(escritor)){

            escritor.write('\uFEFF');
            pw.println(cabecalho);
            //adiciona a linha no arquivo csv com toString interno
            escreverEmOrdem(inicio,pw);
        }
        catch (IOException e){
            System.err.println("Erro ao atualizar : " + e.getMessage());
        }
    }

    private static<T extends Entidade<T>> void escreverEmOrdem(NoArvore<T> raiz, PrintWriter pw){
        if (raiz != null){
            escreverEmOrdem(raiz.esquerda,pw);
            pw.println(raiz.registro);
            escreverEmOrdem(raiz.direita,pw);
        }
    }

    public static void adicionarObjetoCsv(Object elemento, String caminhoArquivo, String cabecalho) {
        File arquivo = new File(caminhoArquivo);
        // Verifica se o ficheiro é novo ou está vazio para saber se escreve o cabeçalho
        boolean precisaCabecalho = !arquivo.exists() || arquivo.length() == 0;

        if (!verificarPasta(arquivo)) return;

        // O append: true garante que os dados antigos não sejam apagados
        try(FileWriter escritor = new FileWriter(caminhoArquivo, true);
            PrintWriter pw = new PrintWriter(escritor)){

            if (precisaCabecalho) {
                escritor.write('\uFEFF');
                pw.println(cabecalho);
            }

            // Adiciona apenas o objeto novo
            pw.println(elemento);

        } catch (IOException e){
            System.err.println("Erro ao adicionar linha : " + e.getMessage());
        }
    }
}

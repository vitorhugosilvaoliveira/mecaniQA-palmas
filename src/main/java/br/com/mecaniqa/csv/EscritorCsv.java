package br.com.mecaniqa.csv;

import br.com.mecaniqa.entidades.Cliente;
import br.com.mecaniqa.interfaces.No;
import br.com.mecaniqa.nos.NoCliente;
import br.com.mecaniqa.nos.NoServico;
import org.w3c.dom.Node;

import java.io.*;

public class EscritorCsv {

public static void adicionarNoCsv(Object elemento, String caminhoArquivo,String cabecalho){

    //cria um objeto da classe File com o caminho do arquivo csv
    File arquivo = new File(caminhoArquivo);

    if (!verificarPasta(arquivo)){
        return;
    }

    //se o arquivo não existe ou não tem linhas retorna true
    boolean precisaCabecalho = !arquivo.exists() || arquivo.length() == 0;

    try(FileWriter escritor = new FileWriter(caminhoArquivo,true); PrintWriter pw = new PrintWriter(escritor)) {

        //se o arquivo não existia ou for vazio cria o cabecalho
        if (precisaCabecalho){
            pw.println(cabecalho);
        }

        //adiciona a linha no arquivo csv com toString interno
        pw.println(elemento);
    }
    catch (IOException e){

        System.err.println("Erro ao adcionar : " + e.getMessage());
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

    public static <T extends No<T>> void atualizarDinamicoCsv(T inicio, String caminhoArquivo, String cabecalho){

            //evita o NullPointerException
            if (inicio == null){
                System.out.println("Lista vazia");
                return;
            }

            try(FileWriter escritor = new FileWriter(caminhoArquivo,false); PrintWriter pw = new PrintWriter(escritor)){

                escritor.write('\uFEFF');
            pw.println(cabecalho);

            T head = inicio;

            while(head.getProximo() != null){
                //adiciona a linha no arquivo csv com toString interno
                pw.println(head.getValue());
                head = head.getProximo();
            }
                pw.println(head.getProximo());
        }
        catch (IOException e){

            System.err.println("Erro ao atualizar : " + e.getMessage());
        }
    }
}

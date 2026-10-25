package br.com.mecaniqa.csv;

import br.com.mecaniqa.entidades.*;
import br.com.mecaniqa.enums.Categoria;
import br.com.mecaniqa.enums.Status;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeitorCsv {

    public static void importar(String nomeArquivo){
        lerArquivo(nomeArquivo);
    }

   private static void lerArquivo(String arquivo) {
        String line;
        arquivo = mudarArquivo(arquivo);

       try(BufferedReader br = new BufferedReader(new FileReader(arquivo))){
           br.readLine();
           while ((line = br.readLine()) != null){
               String[] atributos = line.split(";");
               switch (arquivo){
                   case "./dados/Pecas.csv" -> Gerenciador.inserirPeca(new Peca(Integer.parseInt(atributos[0]),atributos[1],atributos[2],Double.parseDouble(atributos[3]),Double.parseDouble(atributos[4]),Integer.parseInt(atributos[5])));
                   case "./dados/Servicos.csv" -> Gerenciador.inserirServico(new Servico(Integer.parseInt(atributos[0]) ,atributos[1],Integer.parseInt(atributos[2]),Double.parseDouble(atributos[3])));
                   case "./dados/Clientes.csv" -> new Cliente(Integer.parseInt(atributos[0]), atributos[1], atributos[2], atributos[3]);
                   case "./dados/Carros.csv" -> new Carro(Integer.parseInt(atributos[0]), atributos[1],atributos[2],Integer.parseInt(atributos[3]),atributos[4], Categoria.valueOf(atributos[5]),Integer.parseInt(atributos[6]));
                   case "./dados/OrdemServico.csv" -> new OrdemServico(Integer.parseInt(atributos[0]), Status.valueOf(atributos[1]), Servico.arvoreServico.encontrar(Integer.parseInt(atributos[2])));
               }
           }
       }catch(FileNotFoundException e){
           System.out.println("Arquivo não encontrado");
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
   }

    private static String mudarArquivo(String arquivo){
        //muda o caminho do arquivo de acordo com o nome de entrada
        switch (arquivo){
            case "Clientes" -> arquivo = "./dados/Clientes.csv";
            case "Carros" -> arquivo = "./dados/Carros.csv";
            case "Pecas" -> arquivo = "./dados/Pecas.csv";
            case "Servicos" -> arquivo = "./dados/Servicos.csv";
            case "OrdemServico" -> arquivo = "./dados/OrdemServico.csv";
        }
        return arquivo;
    }
}


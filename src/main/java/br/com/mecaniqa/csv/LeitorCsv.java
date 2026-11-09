package br.com.mecaniqa.csv;

import br.com.mecaniqa.entidades.*;
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
               CriadorObjeto.criarObjeto(atributos,arquivo);
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
            case "Rotas" -> arquivo = "./dados/Rotas.csv";
        }
        return arquivo;
    }
}


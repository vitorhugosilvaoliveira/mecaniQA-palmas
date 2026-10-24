package br.com.mecaniqa.csv;

public class TratarAtributo {
    //metodo interno para ajustar o String e evitar que quebre o arquivo csv
    public static String atributo(String atributo){
        if (atributo == null)
            return "";
        if (atributo.contains(";") || atributo.contains("\"") || atributo.contains("\n")){
            atributo = atributo.replace("\"", "\"\"");
            return "\"" + atributo + "\"";
        }
        return atributo;
    }
}

package br.com.mecaniqa;

import br.com.mecaniqa.csv.EscritorCsv;
import br.com.mecaniqa.csv.LeitorCsv;

public class Main {

    public static void main(String[] args) {
        LeitorCsv.importar("Pecas");
        EscritorCsv.exportar("Pecas");
    }
}


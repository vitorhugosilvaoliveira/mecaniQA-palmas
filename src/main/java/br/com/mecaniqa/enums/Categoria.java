package br.com.mecaniqa.enums;

public enum Categoria {
    HATCH("Hatch"),
    SEDAN("Sedan"),
    SUV("Suv");

    private String categoria;

    Categoria(String categoria){
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }
}

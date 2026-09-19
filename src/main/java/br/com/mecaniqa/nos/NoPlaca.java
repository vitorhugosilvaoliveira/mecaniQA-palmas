package br.com.mecaniqa.nos;

public class NoPlaca {
    public String value;
    public NoPlaca next;

    public NoPlaca(String value){
        this.value = value;
        this.next =  null;
    }
}

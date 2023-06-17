package br.com.uniritter.app1_2023_1.models;

import androidx.annotation.NonNull;

public class Dados {
    private String dado1;
    private String dado2;
    private String dado3;
    private String dado4;

    public Dados(String dado1, String dado2, String dado4, String dado3) {
        this.dado1 = dado1;
        this.dado2 = dado2;
        this.dado4 = dado4;
        this.dado3 = dado3;
    }

    @NonNull
    @Override
    public String toString(){
        return this.dado1+" -> "+this.dado2+" -> "+ this.dado4 +" ->" + this.dado3;

    }
}

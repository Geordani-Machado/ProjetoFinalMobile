package br.com.uniritter.app1_2023_1.models;

public class Item {
    private int id;

    private String nome , url;


    public Item(int id, String nome, String url) {
        this.id = id;
        this.nome = nome;
        this.url = url;

    }

    public int getId() {return id;}

    public String getNome() { return nome;}

    public String getUrl(){
        return url;
    }

}

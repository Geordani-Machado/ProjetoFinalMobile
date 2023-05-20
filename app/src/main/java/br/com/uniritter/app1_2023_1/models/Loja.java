package br.com.uniritter.app1_2023_1.models;

public class Loja {

    private int id;

    private Integer preco;

    private Integer quantidade;

    private Item item;

    public Loja (int id, int preco, Item item, Integer quantidade){
        this.id = id;
        this.preco = preco;
        this.quantidade = quantidade;
        this.item = item;
    }



    public Integer getQuantidade(){

        return quantidade;
    }
    public Integer getPreco(){

        return  preco;
    }
    public Item getItem(){

        return  item;
    }
}

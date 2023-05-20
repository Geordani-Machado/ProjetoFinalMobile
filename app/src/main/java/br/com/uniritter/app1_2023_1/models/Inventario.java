package br.com.uniritter.app1_2023_1.models;

public class Inventario {
    private int id;

    private Integer quantidade;

    private Item item;

    public Inventario(int id, Integer quantidade, Item item) {
        this.id = id;
        this.quantidade = quantidade;
        this.item = item;

    }

    public int getId() {
        return id;
    }


    public Integer getQuantidade(){
        return quantidade;
    }

    public Item getItem(){
        return item;
    }

}

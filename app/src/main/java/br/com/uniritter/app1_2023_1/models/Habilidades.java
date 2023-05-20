package br.com.uniritter.app1_2023_1.models;

public class Habilidades {
    private Integer id;
    private String  name;
    private Float forca;

    public Habilidades(Integer id, String name, Float forca) {
        this.id = id;
        this.name = name;
        this.forca = forca;
    }

    public String getName() {
        return name;
    }
    public Float getForca() {
        return forca;
    }
    public String getHabilidade() {
        return "Nome" + name + "Força" + forca;
    }
}


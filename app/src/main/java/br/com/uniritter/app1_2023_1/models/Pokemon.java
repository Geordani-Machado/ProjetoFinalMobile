package br.com.uniritter.app1_2023_1.models;

public class Pokemon {

    private Integer id;
    private String nome;
    private Integer idade;
    private Integer vida;

    private Integer level;
    private Habilidades habilidades;
    private Integer IDHabilidades;

    public Pokemon(Integer id ,String nome, Integer idade, Integer vida, Habilidades habilidades, Integer level) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.vida = vida;
        this.habilidades = habilidades;
    }

    public Pokemon(int id, String nome, int idade, int vida, int level) {
        this.id = id;
    }

    public Integer getId(){ return id;}
    public String getNome() {
        return nome;
    }
    public Integer getIdade() {
        return idade;
    }
    public Integer getVida() {
        return vida;
    }
}

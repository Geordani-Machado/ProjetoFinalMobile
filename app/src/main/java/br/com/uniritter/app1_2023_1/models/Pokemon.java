package br.com.uniritter.app1_2023_1.models;

public class Pokemon {

    private Integer id_pokemon;
    private String nome;
    private Integer idade;
    private Integer vida;

    private String Img;

    private Integer level;
    private Habilidades habilidades;
    private Integer IDHabilidades;

    public Pokemon(Integer id , String nome, Integer idade, Integer vida, String Img) {
        this.id_pokemon = id;
        this.nome = nome;
        this.idade = idade;
        this.vida = vida;
        this.Img = Img;
    }



    public Integer getId(){ return id_pokemon;}
    public String getNome() {
        return nome;
    }
    public Integer getIdade() {
        return idade;
    }
    public Integer getVida() {
        return vida;
    }
    public String getImg(){return Img;}
}

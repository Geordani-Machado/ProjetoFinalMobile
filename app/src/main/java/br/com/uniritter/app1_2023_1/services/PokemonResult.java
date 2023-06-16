package br.com.uniritter.app1_2023_1.services;


import com.google.gson.annotations.SerializedName;

public class PokemonResult {

    @SerializedName("id_pokemon")
    Integer id_pokemon;

    @SerializedName("nome")
    String nome;

    @SerializedName("idade")
    Integer idade;

    @SerializedName("vida")
    Integer vida;

    @SerializedName("Img")
    String Img;


    public int getID(){
        return id_pokemon;
    }
    public String getName(){
        return nome;
    }
    public Integer getIdade(){
        return idade;
    }
    public Integer getVida(){
        return vida;
    }
    public String getImg(){
        return Img;
    }

}

package br.com.uniritter.app1_2023_1.services;


import androidx.annotation.NonNull;

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

    @NonNull
    @Override
    public String toString(){
        return this.id_pokemon+" -> "+this.nome+" url: "+this.Img;

    }

    public PokemonResult(String nome, String url) {
        this.nome = nome;
        this.Img = url;
    }


    public int getID(){
        return id_pokemon;
    }
    public String getNome(){
        return nome;
    }
    public Integer getIdade(){
        return idade;
    }
    public Integer getVida(){
        return vida;
    }
    public String getUrl(){
        return Img;
    }



}

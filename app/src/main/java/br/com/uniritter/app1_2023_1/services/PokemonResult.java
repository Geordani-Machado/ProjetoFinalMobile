package br.com.uniritter.app1_2023_1.services;


import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class PokemonResult {

    @SerializedName("id_pokemon")
    Integer id_pokemon;

    @SerializedName("nome")
    String nome;

    @SerializedName("idade")
    String level;

    @SerializedName("vida")
    String vida;

    @SerializedName("Img")
    String Img;

    @NonNull
    @Override
    public String toString(){
        return
                " Nome: "+this.Img + " url: "+this.Img + " Level: "+this.level + " Vida: "+this.vida;
    }

    public PokemonResult(String nome, String url, String level, String vida) {
        this.nome = nome;
        this.Img = url;
        this.level = level;
        this.vida = vida;

    }


    public int getID(){
        return id_pokemon;
    }
    public String getNome(){
        return nome;
    }
    public String getLevel(){
        return level;
    }
    public String getVida(){
        return vida;
    }
    public String getUrl(){
        return Img;
    }



}

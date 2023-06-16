package br.com.uniritter.app1_2023_1.adapters;


public class Pokemon {

    private String Nome;
    private String Url;

    public Pokemon(String nome, String url) {
        this.Nome = nome;
        this.Url = url;
    }

    public String getNome() {
        return Nome;
    }


   public String getUrl() {
     return Url;
   }

}



package br.com.uniritter.app1_2023_1.adapters;


public class Pokemon {

    private String Nome;
    private String Url;

    private String Vida;

    private String Level;

    public Pokemon(String nome, String url,String vida, String level) {
        this.Nome = nome;
        this.Url = url;
        this.Vida = vida;
        this.Level = level;
    }

    public String getNome() {
        return Nome;
    }


   public String getUrl() {
     return Url;
   }

}



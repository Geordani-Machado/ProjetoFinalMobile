package br.com.uniritter.app1_2023_1.models;


public class Pokemon {

    private String Nome;
    private String Url;

    private int Level;

    private int Vida;

    public Pokemon(String nome, String url, int leval, int vida) {
        this.Nome = nome;
        this.Url = url;
        this.Level = leval;
        this.Vida = vida;
    }

    public String getNome() {
        return Nome;
    }


   public String getUrl() {
     return Url;
   }

   public int getVida(){return Vida;};

    public int getLevel(){return Level;};

}



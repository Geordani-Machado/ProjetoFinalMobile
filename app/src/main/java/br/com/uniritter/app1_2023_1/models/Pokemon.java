package br.com.uniritter.app1_2023_1.models;


public class Pokemon {

    private String Nome;
    private String Url;

    private String Level;

    private String Vida;

    public Pokemon(String nome, String url, String leval, String vida) {
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

   public String getVida(){return Vida;};

    public String getLevel(){return Level;};

}



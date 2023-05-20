package br.com.uniritter.app1_2023_1.models;

public class Todos {

    private int userID;
    private int id;
    private String title;
    private Boolean completed;

    public Todos(int userID, int id, String title, Boolean completed){
        this.userID = userID;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    public int getUserID(){
        return userID;
    }
    public int getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }
    public Boolean getCompleted(){
        return completed;
    }

    public String toString(){
        return "userID" + userID + "\nID" + id + "\ntitle" + title + "\ncompleted" + completed;
    }
}

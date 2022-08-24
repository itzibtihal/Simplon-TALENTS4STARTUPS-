package com.example.nawan.utils;

public class Categorie {
    private  int id;
    private String nom;

    public Categorie(){

    }

    public Categorie(int id) {
        this.id = id;
    }

    public Categorie(String nom){
        this.nom = nom;
    }
    public Categorie(int id,String nom){
        this.id = id;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}

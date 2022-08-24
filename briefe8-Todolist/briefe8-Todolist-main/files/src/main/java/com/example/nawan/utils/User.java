package com.example.nawan.utils;

public class User {
    private int id;
    private String nom;
    private String prenom;
    private String nomUtilisateur;
    private String password;

    public User(){

    }

    public User(String nom, String prenom, String nomUtilisateur,String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.nomUtilisateur = nomUtilisateur;
        this.password = password;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package com.example.demo;

public class Candidat {

    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String adresse;
    private String pays;

    //Constructeurs de la classe

    public Candidat(int id, String nom, String prenom, String email, String adresse, String pays) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.adresse = adresse;
        this.pays = pays;
    }

    public Candidat(String nom, String prenom, String email, String adresse, String pays) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.adresse = adresse;
        this.pays = pays;
    }

    public Candidat() {

    }


    //getters & setters

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


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getAdresse() {
        return adresse;
    }


    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }


    public String getPays() {
        return pays;
    }
    public void setPays(String pays) {
        this.pays = pays;
    }
}

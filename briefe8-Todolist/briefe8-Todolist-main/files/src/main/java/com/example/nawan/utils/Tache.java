package com.example.nawan.utils;

public class Tache {
    private int id;
    private String titre;
    private String description;
    private  String statut;
    private String deadline;
    private int idCategorie;

    public Tache() {
    }

    public Tache(int id) {
        this.id = id;
    }

    public Tache(String titre, String description, String statut, String deadline, int idCategorie) {
        this.titre = titre;
        this.description = description;
        this.statut = statut;
        this.deadline = deadline;
        this.idCategorie = idCategorie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }
}

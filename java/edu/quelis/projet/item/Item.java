package edu.quelis.projet.item;

import java.util.ArrayList;

public class Item {
    String nom;
    double prix;
    int image;

    ArrayList<Item> items = new ArrayList<>();

    public Item(String nom, double prix, int image, ArrayList<Item> items) {
        this.image = image;
        this.items = items;
        this.nom = nom;
        this.prix = prix;
    }



    public String getNom() {
        return nom;
    }

    public int getImage() {
        return image;
    }

    public double getPrix() {
        return prix;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }



    public void calculPrix(){
        //TODO -> formule pour calculer le nv prix

    }
}

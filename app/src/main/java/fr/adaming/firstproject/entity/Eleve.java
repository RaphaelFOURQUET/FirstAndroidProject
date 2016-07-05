package fr.adaming.firstproject.entity;

/**
 * Created by INTI-0332 on 04/07/2016.
 */
public class Eleve {

    private String nom;

    private String prenom;

    private boolean isMale;

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

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public Eleve() {

    }

    public Eleve(String nom, String prenom) {
        this.isMale = true;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Eleve(String nom, boolean isMale, String prenom) {
        this.nom = nom;
        this.isMale = isMale;
        this.prenom = prenom;
    }
}

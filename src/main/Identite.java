package main;
public class Identite {
    private String NIP;
    private String nom;
    private String prenom;

    public Identite(String pNIP, String pNom, String pPrenom) {
        this.NIP = pNIP;
        this.nom = pNom;
        this.prenom = pPrenom;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
}
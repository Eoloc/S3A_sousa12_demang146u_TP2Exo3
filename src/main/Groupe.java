package main;

import java.util.HashSet;
import java.util.Set;

public class Groupe {
    private Formation formation;
    private Set<Etudiant> etudiants;

    public Groupe(Formation f) {
        formation = f;
        etudiants = new HashSet<Etudiant>();
    }

    public boolean ajouterEtu(Etudiant e) {
        return etudiants.add(e);
    }

    public boolean supprimerEtu(Etudiant e) {
        return etudiants.remove(e);
    }

    public double moyenneMatiere(String matiere) {
        double moyenne = 0;

        return moyenne;
    }

    public double moyenneGenerale() {
        double moyenne = 0;

        return moyenne;
    }
}

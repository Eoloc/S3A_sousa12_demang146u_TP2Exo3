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
        if (e.getFormation().equals(this.formation))
            return etudiants.add(e);
        else
            return false;
    }

    public boolean supprimerEtu(Etudiant e) {
        return etudiants.remove(e);
    }

    public Double moyenneMatiere(String matiere) {
        if (!formation.getMatieres().contains(matiere))
            return null;
        Double moyenne = 0.;
        for (Etudiant e : etudiants) {
            moyenne += e.moyenneMatiere(matiere);
        }
        return moyenne;
    }

    public Double moyenneGenerale() {
        double moyenne = 0;

        return moyenne;
    }
}

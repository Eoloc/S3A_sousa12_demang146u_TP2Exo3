package main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
        if (!formation.getMatieres().contains(matiere) || etudiants.size() <= 0)
            return null;
        Double moyenne = 0.;
        int coef = 0;
        for (Etudiant e : etudiants) {
            Double moy = e.moyenneMatiere(matiere);
            if (moy != null) {
                moyenne += moy;
                coef++;
            }
        }
        return moyenne / coef;
    }

    public Double moyenneGenerale() {
        if (etudiants.size() <= 0)
            return null;
        double moyenne = 0;

        return moyenne;

    }

    public List<Etudiant> triParMerite() {
        List<Etudiant> list = new ArrayList<Etudiant>(etudiants);

        return list;
    }

    public List<Etudiant> triAlpha() {
        List<Etudiant> list = new ArrayList<Etudiant>(etudiants);

        return list;
    }
}

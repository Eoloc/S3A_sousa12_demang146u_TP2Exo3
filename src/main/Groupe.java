package main;

import java.util.*;

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
        moyenne = moyenne / coef;
        if (moyenne.isNaN())
            return null;
        else
            return moyenne;
    }

    public Double moyenneGenerale() {
        if (etudiants.size() <= 0)
            return null;
        Double moyenne = 0.;
        int coef = 0;
        for (Etudiant e : etudiants) {
            Double moy = e.moyenneGenerale();
            if (moy != null) {
                moyenne += moy;
                coef++;
            }
        }
        moyenne = moyenne / coef;
        if (moyenne.isNaN())
            return null;
        else
            return moyenne;
    }

    public List<Etudiant> triParMerite() {
        List<Etudiant> list = new ArrayList<Etudiant>(etudiants);
        list.sort(new Comparator<Etudiant>() {
            @Override
            public int compare(Etudiant e1, Etudiant e2) {
                if (e1.moyenneGenerale() < e2.moyenneGenerale()) return -1;
                else if (e1.moyenneGenerale() > e2.moyenneGenerale()) return 1;
                return 0;
            }
        });
        return list;
    }

    public List<Etudiant> triAlpha() {
        List<Etudiant> list = new ArrayList<Etudiant>(etudiants);
        list.sort(new Comparator<Etudiant>() {
            @Override
            public int compare(Etudiant e1, Etudiant e2) {
                if (!e1.getNom().equals(e2.getNom()))
                    return e1.getNom().compareTo(e2.getNom());
                else
                    return e1.getPrenom().compareTo(e2.getPrenom());
            }
        });
        return list;
    }
}

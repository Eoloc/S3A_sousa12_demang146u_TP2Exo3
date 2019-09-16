package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Etudiant {
    private Identite identite;
    private Formation formation;
    private HashMap<String, List<Double>> resultats;

    public Etudiant(Identite pIdentite, Formation pFormation) {
        this.identite = pIdentite;
        this.formation = pFormation;
        this.resultats = new HashMap<String, List<Double>>();
        for (String matiere : this.formation.getMatieres()){
            List<Double> listeNote = new ArrayList<Double>();
            this.resultats.put(matiere, listeNote);
        }
    }

    public void ajouterNote(String matiere, double note) {
        if (note >= 0 && note <= 20) {
            if (this.resultats.containsKey(matiere)) {
                List<Double> listeNote = this.resultats.get(matiere);
                listeNote.add(note);
            }
        }
    }

    public double moyenneMatiere(String matiere) {
        double moyenne = 0;
        if (this.resultats.containsKey(matiere)) {
            List<Double> listeNote = this.resultats.get(matiere);
            for (int i = 0; i < listeNote.size(); i++) {
                moyenne += listeNote.get(i);
            }
            moyenne = moyenne / listeNote.size();
        }
        return moyenne;
    }

    public double moyenneGenerale() {
        double moyenne = 0;
        double totalCoef = 0;
        for (String matiere : this.formation.getMatieres()) {
            moyenne += moyenneMatiere(matiere) * this.formation.getCoef(matiere);
            totalCoef += this.formation.getCoef(matiere);
        }
        moyenne = moyenne / totalCoef;
        return moyenne;
    }

}
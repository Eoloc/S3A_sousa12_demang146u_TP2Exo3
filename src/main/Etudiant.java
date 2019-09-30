package main;

import javax.xml.soap.Node;
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
        for (String matiere : this.formation.getMatieres()) {
            List<Double> listeNote = new ArrayList<Double>();
            this.resultats.put(matiere, listeNote);
        }
    }

    public void ajouterNote(String matiere, double note) throws NoteInvalideException, NoteOrFormationException {
        if (note < 0 || note > 20) {
            throw new NoteInvalideException("La note doit etre comprise entre 0 et 20");
        } else if (!resultats.containsKey(matiere)) {
            throw new NoteOrFormationException(matiere + "ne fait pas parti de la formation");
        } else {
            resultats.get(matiere).add(note);
        }
    }

    public Double moyenneMatiere(String matiere) {
        if (!formation.getMatieres().contains(matiere)) {
            return null;
        }
        Double moyenne = 0.;
        if (this.resultats.containsKey(matiere)) {
            List<Double> listeNote = this.resultats.get(matiere);
            for (int i = 0; i < listeNote.size(); i++) {
                moyenne += listeNote.get(i);
            }
            if (listeNote.size() == 0) {
                return null;
            }
            moyenne = moyenne / listeNote.size();
        }
        return moyenne;
    }

    public Double moyenneGenerale() throws FormationException {
        Double moyenne = 0.;
        Double totalCoef = 0.;
        Double moyenneMat = 0.;
        for (String matiere : formation.getMatieres()) {
            moyenneMat = moyenneMatiere(matiere);
            if (moyenneMat != null) {
                moyenne += moyenneMat * formation.getCoef(matiere);
                totalCoef += formation.getCoef(matiere);
            }
        }
        moyenne = moyenne / totalCoef;
        if (moyenne.isNaN())
            return null;
        else
            return moyenne;
    }

    public HashMap<String, List<Double>> getResultats() {
        return resultats;
    }

    public Formation getFormation() {
        return formation;
    }

}
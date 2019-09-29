package main;
import java.util.*;

public class Formation {
    private List<String> matieres;
    private Map<String, Double> coefs;

    public Formation() {
        matieres = new ArrayList<String>();
        coefs = new HashMap<String, Double>();
    }

    public void ajouterMatiere(String nom, double coef) throws FormationException {
    	if(nom != null ) {
    	    if(coef < 0) {
    	        throw new FormationException("Le coefficient d'une matière ne peut pas être négatif");
            } else {
                if (!matieres.contains(nom)) {
                    matieres.add(nom);
                    coefs.put(nom, coef);
                }
            }

    	}
        
    }

    public void supprimerMatiere(String nom) {
        if (matieres.contains(nom)) {
            matieres.remove(nom);
            coefs.remove(nom);
        }
    }

    public double getCoef(String nom) throws FormationException {
        if (matieres.contains(nom))
            return coefs.get(nom);
        else
            throw new FormationException("La matiere n'est pas dans la formation");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Formation)) return false;
        Formation formation = (Formation) o;
        return Objects.equals(matieres, formation.matieres) &&
                Objects.equals(coefs, formation.coefs);
    }

    public List<String> getMatieres() {
        return matieres;
    }

}

package main;
import java.util.*;

public class Formation {
    private List<String> matieres;
    private Map<String, Double> coefs;

    public Formation() {
        matieres = new ArrayList<String>();
        coefs = new HashMap<String, Double>();
    }

    public void ajouterMatiere(String nom, double coef) {
    	if(nom != null ) {
    		if (!matieres.contains(nom)) {
                matieres.add(nom);
                coefs.put(nom, coef);
            }
    	}
        
    }

    public void supprimerMatiere(String nom) {
        if (matieres.contains(nom)) {
            matieres.remove(nom);
            coefs.remove(nom);
        }
    }

    public double getCoef(String nom) {
        if (matieres.contains(nom))
            return coefs.get(nom);
        else
            return 0;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Formation {
    private List<String> matieres;
    private Map<String, Double> coefs;

    public Formation() {
        matieres = new ArrayList<String>();
        coefs = new HashMap<String, Double>();
    }

    public void ajouterMatiere(String nom, double coef) {
        if (!matieres.contains(nom)) {
            matieres.add(nom);
            coefs.put(nom, coef);
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
            return -1;
    }
}

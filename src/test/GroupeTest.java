package test;

import main.Etudiant;
import main.Formation;
import main.Groupe;
import main.Identite;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GroupeTest {

    Groupe groupe;
    Formation f;
    Etudiant etudiant1, etudiant2;

    @Before
    public void setUp() throws Exception {
        f = new Formation();
        f.ajouterMatiere("Mathématique", 9);
        f.ajouterMatiere("Informatique", 5);
        Identite id1 = new Identite("ETU0123", "Sousa", "Alexandre");
        Identite id2 = new Identite("ETU4567", "Demange", "Louis");
        etudiant1 = new Etudiant(id1, f);
        etudiant2 = new Etudiant(id2, f);
        groupe = new Groupe(f);
        groupe.ajouterEtu(etudiant1);
    }

    @Test
    public void ajouterEtu() {

        assertTrue("", );
    }

    @Test
    public void supprimerEtu() {
    }

    @Test
    public void moyenneMatiere() {
    }

    @Test
    public void moyenneGenerale() {
    }
}
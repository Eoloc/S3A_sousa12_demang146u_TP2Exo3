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
    Formation f, f2;
    Etudiant etudiant1, etudiant2, etudiant3;

    @Before
    public void setUp() throws Exception {
        f = new Formation();
        f.ajouterMatiere("Mathematique", 9);
        f.ajouterMatiere("Informatique", 5);
        f2 = new Formation();
        f2.ajouterMatiere("Français", 3);
        Identite id1 = new Identite("ETU0123", "Sousa", "Alexandre");
        Identite id2 = new Identite("ETU4567", "Demange", "Louis");
        Identite id3 = new Identite("ETU8910", "Jin", "Liyao");
        etudiant1 = new Etudiant(id1, f);
        etudiant2 = new Etudiant(id2, f);
        etudiant3 = new Etudiant(id3, f2);
        groupe = new Groupe(f);
        groupe.ajouterEtu(etudiant1);
    }

    @Test
    public void ajouterEtu() {
        /* ajout d'un étudiant */
        assertTrue("L'etudiant devrait être ajouté", groupe.ajouterEtu(etudiant2));

        /* ajout d'un étudiant qui n'a pas la même formation*/
        assertFalse("L'étudiant ne devrait pas être ajouté car il a une formation différente", groupe.ajouterEtu(etudiant3));
    }

    @Test
    public void supprimerEtu() {
        /* suppression d'un étudiant déjâ dans le groupe*/
        assertTrue("L'etudiant devrait être supprimé", groupe.supprimerEtu(etudiant1));

        /* suppression d'un étudiant n'étant pas dans le groupe*/
        assertFalse("L'étudiant ne devrait pas être supprimé car il n'est pas dans le groupe", groupe.supprimerEtu(etudiant2));

        /* suppression de la valeur null*/
        assertFalse("Null ne peut pas être supprimé", groupe.supprimerEtu(null));
    }

    @Test
    public void moyenneMatiere() {
        etudiant1.ajouterNote("Mathematique", 10);
        etudiant1.ajouterNote("Mathematique", 18);
        etudiant2.ajouterNote("Mathematique", 18);
        assertEquals(16, groupe.moyenneMatiere("Mathematique"), 0.001);
    }

    @Test
    public void moyenneGenerale() {
    }
}
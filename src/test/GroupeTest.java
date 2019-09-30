package test;

import main.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GroupeTest {

    Groupe groupe1;
    Formation f1, f2;
    Etudiant etudiant1, etudiant2, etudiant3;

    @Before
    public void setUp() throws Exception {
        f1 = new Formation();
        f1.ajouterMatiere("Mathematique", 9);
        f1.ajouterMatiere("Informatique", 5);
        f2 = new Formation();
        f2.ajouterMatiere("Français", 3);
        Identite id1 = new Identite("ETU0123", "Sousa", "Alexandre");
        Identite id2 = new Identite("ETU4567", "Demange", "Louis");
        Identite id3 = new Identite("ETU8910", "Jin", "Liyao");
        etudiant1 = new Etudiant(id1, f1);
        etudiant2 = new Etudiant(id2, f1);
        etudiant3 = new Etudiant(id3, f2);
        groupe1 = new Groupe(f1);
        groupe1.ajouterEtu(etudiant1);
    }

    @Test
    public void testAjouterEtu() {
        /* ajout d'un étudiant */
        assertTrue("L'etudiant devrait être ajouté", groupe1.ajouterEtu(etudiant2));

        /* ajout d'un étudiant qui n'a pas la même formation*/
        assertFalse("L'étudiant ne devrait pas être ajouté car il a une formation différente", groupe1.ajouterEtu(etudiant3));
    }

    @Test
    public void testSupprimerEtu() {
        /* suppression d'un étudiant déjâ dans le groupe*/
        assertTrue("L'etudiant devrait être supprimé", groupe1.supprimerEtu(etudiant1));

        /* suppression d'un étudiant n'étant pas dans le groupe*/
        assertFalse("L'étudiant ne devrait pas être supprimé car il n'est pas dans le groupe", groupe1.supprimerEtu(etudiant2));

        /* suppression de la valeur null*/
        assertFalse("Null ne peut pas être supprimé", groupe1.supprimerEtu(null));
    }

    @Test
    public void testMoyenneMatiere() throws NoteInvalideException, NoteOrFormationException {
        /* groupe normal */
        groupe1.ajouterEtu(etudiant2);
        etudiant1.ajouterNote("Mathematique", 10);
        etudiant1.ajouterNote("Mathematique", 18);
        etudiant2.ajouterNote("Mathematique", 18);
        assertEquals(16, groupe1.moyenneMatiere("Mathematique"), 0.001);

        /* groupe vide*/
        assertNull(new Groupe(f1).moyenneMatiere("Mathematique"));
    }

    @Test
    public void testMoyenneGenerale() throws NoteInvalideException, NoteOrFormationException {
        /* groupe vide*/
        assertNull(new Groupe(f1).moyenneGenerale());

        /* groupe sans notes*/
        groupe1.ajouterEtu(etudiant2);
        assertNull(groupe1.moyenneGenerale());

        /* un etudiant a pas de note*/
        etudiant1.ajouterNote("Mathematique", 10);
        etudiant1.ajouterNote("Informatique", 10);
        assertEquals(10, groupe1.moyenneGenerale(), 0.001);

        /* groupe normal*/
        etudiant2.ajouterNote("Mathematique", 18);
        etudiant2.ajouterNote("Informatique", 18);
        assertEquals(14, groupe1.moyenneGenerale(), 0.001);
    }

    @Test
    public void testTriParMerite() {

    }

    @Test
    public void testTriParAlpha() {
    }

}
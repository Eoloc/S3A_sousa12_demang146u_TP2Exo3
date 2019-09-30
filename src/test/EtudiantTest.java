package test;
import main.*;

import static org.junit.Assert.*;

public class EtudiantTest {
    private Etudiant etu;

    @org.junit.Before
    public void setUp() throws Exception {
        Formation f = new Formation();
        f.ajouterMatiere("Maths", 2);
        f.ajouterMatiere("Info", 5);
        Identite id = new Identite("ETU0123", "Sousa", "Alexandre");
        etu = new Etudiant(id, f);
    }

    @org.junit.Test
    public void testAjouterNote() throws NoteInvalideException, NoteOrFormationException {
        /* test d'ajout d'une note */
        etu.ajouterNote("Maths", 12);
        assertEquals(12, (double) etu.getResultats().get("Maths").get(0), 0.001);
    }

    @org.junit.Test(expected = NoteInvalideException.class)
    public void testAjouterNoteInvalide() throws NoteInvalideException, NoteOrFormationException {
        /* test qui leve une exception si on ajoute une note qui n'est pas comprise entre 0 et 20 */
        etu.ajouterNote("Maths", -1);
        etu.ajouterNote("Maths", 21);
    }

    @org.junit.Test(expected = NoteOrFormationException.class)
    public void testAjouterNoteOrFormation() throws NoteOrFormationException, NoteInvalideException {
        /* test qui leve une exception si on ajoute une note a une matiere qui n'appartient
           pas a la formation */
        etu.ajouterNote("Eco", 5);
    }

    @org.junit.Test
    public void testMoyenneMatiere() throws NoteInvalideException, NoteOrFormationException {
        /* test de la moyenne dans la formation */
        etu.ajouterNote("Maths", 10);
        etu.ajouterNote("Maths", 15);
        etu.ajouterNote("Maths", 20);
        assertEquals(15, etu.moyenneMatiere("Maths"), 0.001);

        /* pas de note dans la matiere */
        assertNull(etu.moyenneMatiere("Info"));

        /* moyenne pas dans la formation */
        assertNull(etu.moyenneMatiere("Eco"));
    }

    @org.junit.Test
    public void testMoyenneGenerale() throws FormationException, NoteInvalideException, NoteOrFormationException {
        /* aucune note */
        assertNull(etu.moyenneGenerale());

        /* pas de note dans toute les matiere de la foramtion */
    	etu.ajouterNote("Maths", 10);
        assertEquals(10.0, etu.moyenneGenerale(), 0.001);

        /* une note dans chaque matiere de la formation */
        etu.ajouterNote("Info", 20);
        assertEquals(17.143, etu.moyenneGenerale(), 0.001);
    }
}
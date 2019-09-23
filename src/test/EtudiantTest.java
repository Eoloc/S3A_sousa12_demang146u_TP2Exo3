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
    public void testAjouterNote() {
        /* ajout note normal */
        etu.ajouterNote("Maths", 12);
        assertEquals(12, (double) etu.getResultats().get("Maths").get(0), 0.001);

        /* ajout note pas dans la formation */
        etu.ajouterNote("Eco", 5);
        assertEquals(null, etu.getResultats().get("Eco"));
    }

    @org.junit.Test
    public void testMoyenneMatiere() {
        /* moyenne dans la formation */
        etu.ajouterNote("Maths", 10);
        etu.ajouterNote("Maths", 15);
        etu.ajouterNote("Maths", 20);
        assertEquals(15, etu.moyenneMatiere("Maths"), 0.001);

        /* moyenne pas dans la formation */
        assertNull(etu.moyenneMatiere("Eco"));
    }

    @org.junit.Test
    public void testMoyenneGenerale() {
        /* pas de note dans toute les matiere de la foramtion */
    	etu.ajouterNote("Maths", 10);
        assertEquals(10.0, etu.moyenneGenerale(), 0.001);

        /* une note dans chaque matiere de la formation */
        etu.ajouterNote("Info", 20);
        assertEquals(17.143, etu.moyenneGenerale(), 0.001);
    }
}
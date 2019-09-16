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
        etu.ajouterNote("Maths", 12);
        assertEquals();
    }

    @org.junit.Test
    public void testMoyenneMatiere() {
    }

    @org.junit.Test
    public void testmoyenneGenerale() {
    }
}
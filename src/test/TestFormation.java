package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.Formation;

public class TestFormation {
	
	Formation formation;

	@Before
	public void setUp() throws Exception {
		formation = new Formation();
		formation.ajouterMatiere("Mathématique", 9);
		formation.ajouterMatiere("SVT", 7);
	}

	@Test
	public void testAjouterMatiere() {
		assertTrue("Mathématique devrait être dans la formation", formation.getMatieres().contains("Mathématique"));
		formation.ajouterMatiere(null, 9);
		assertFalse("Null ne devrait pas être dans la formation", formation.getMatieres().contains(null));
	}

	@Test
	public void testSupprimerMatiere() {
		formation.supprimerMatiere("Mathématique");
		assertTrue("SVT devrait être dans la formation", formation.getMatieres().contains("SVT"));
		assertFalse("Mathématique ne devrait pas être dans la formation", formation.getMatieres().contains("Mathématique"));
	}

	@Test
	public void testGetCoef() {
		assertEquals("Le coeficient de Mathématique devrait être 9", 9, formation.getCoef("Mathématique"), 0.1);
		assertEquals("Le coeficient de SVT devrait être 7", 7, formation.getCoef("SVT"), 0.1);
		assertEquals("Le coeficient de Français devrait être 0 car elle n'existe pas", 0, formation.getCoef("Français"), 0.1);
	}

	@Test
	public void testEquals() {
		Formation formation2 = new Formation();
		formation2.ajouterMatiere("Mathématique", 9);
		formation2.ajouterMatiere("SVT", 7);
		
		Formation formation3 = new Formation();
		
		Formation formation4 = new Formation();
		formation4.ajouterMatiere("Mathématique", 9);
		formation4.ajouterMatiere("SVT", 7);
		formation4.ajouterMatiere("Histoire", 4);
		formation4.ajouterMatiere("Géographie", 4);
		formation4.ajouterMatiere("EPS", 1);
		
		assertTrue("Les formations 1 et 2 devrait être les mêmes", formation.equals(formation2));
		assertFalse("Les formations 1 et 3 ne devrait pas être les mêmes", formation.equals(formation3));
		assertFalse("Les formations 1 et 4 ne devrait pas être les mêmes", formation.equals(formation4));
		assertFalse("Les formations 2 et 3 ne devrait être pas les mêmes", formation2.equals(formation3));
	}

}

package test;

import static org.junit.Assert.*;

import main.FormationException;
import org.junit.Before;
import org.junit.Test;

import main.Formation;

public class TestFormation {
	
	Formation formation;

	@Before
	public void setUp() throws Exception {
		formation = new Formation();
		formation.ajouterMatiere("Math�matique", 9);
		formation.ajouterMatiere("SVT", 7);
	}

	@Test(expected = FormationException.class)
	public void testAjouterMatiereException() throws FormationException {
		formation.ajouterMatiere("Latin", -2);
	}

	@Test
	public void testAjouterMatiere() throws FormationException {
		/* ajout de la mati�re math�matique */
		assertTrue("Math�matique devrait �tre dans la formation", formation.getMatieres().contains("Math�matique"));

		/* ajout de la valeur null dans les mati�re */
		formation.ajouterMatiere(null, 9);
		assertFalse("Null ne devrait pas �tre dans la formation", formation.getMatieres().contains(null));
	}

	@Test
	public void testSupprimerMatiere() {
		formation.supprimerMatiere("Math�matique");
		assertTrue("SVT devrait �tre dans la formation", formation.getMatieres().contains("SVT"));
		assertFalse("Math�matique ne devrait pas �tre dans la formation", formation.getMatieres().contains("Math�matique"));
	}

	@Test(expected = FormationException.class)
	public void testGetCoefException() throws FormationException {
		assertEquals("Le coeficient de Fran�ais devrait �tre 0 car elle n'existe pas", 0, formation.getCoef("Fran�ais"), 0.1);
	}

	@Test
	public void testGetCoef() throws FormationException {
		assertEquals("Le coeficient de Math�matique devrait �tre 9", 9, formation.getCoef("Math�matique"), 0.1);
		assertEquals("Le coeficient de SVT devrait �tre 7", 7, formation.getCoef("SVT"), 0.1);
	}

	@Test
	public void testEquals() throws FormationException {
		Formation formation2 = new Formation();
		formation2.ajouterMatiere("Math�matique", 9);
		formation2.ajouterMatiere("SVT", 7);
		
		Formation formation3 = new Formation();
		
		Formation formation4 = new Formation();
		formation4.ajouterMatiere("Math�matique", 9);
		formation4.ajouterMatiere("SVT", 7);
		formation4.ajouterMatiere("Histoire", 4);
		formation4.ajouterMatiere("G�ographie", 4);
		formation4.ajouterMatiere("EPS", 1);
		
		assertTrue("Les formations 1 et 2 devrait �tre les m�mes", formation.equals(formation2));
		assertFalse("Les formations 1 et 3 ne devrait pas �tre les m�mes", formation.equals(formation3));
		assertFalse("Les formations 1 et 4 ne devrait pas �tre les m�mes", formation.equals(formation4));
		assertFalse("Les formations 2 et 3 ne devrait �tre pas les m�mes", formation2.equals(formation3));
	}

}

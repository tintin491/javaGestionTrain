package models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import exceptions.PrixBilletInvalidException;

/**
 * Classe de test pour la classe Billet.
 */
public class TestBillet {

    private Voyage voyage;
    private Passager passager;

    /**
     * Initialisation des objets avant chaque test.
     */
    @BeforeEach
    public void setUp() {
        voyage = new Voyage();
        passager = new Passager();
    }

    /**
     * Test du constructeur avec un prix valide.
     *
     * @throws PrixBilletInvalidException si le prix est invalide
     */
    @Test
    public void testConstructeurAvecPrixValide() throws PrixBilletInvalidException {
        Billet billet = new Billet(voyage, passager, 100.0);
        assertNotNull(billet);
        assertEquals(100.0, billet.getPrix());
        assertFalse(billet.isAnnule());
    }

    /**
     * Test du constructeur avec un prix invalide (négatif).
     */
    @Test
    public void testConstructeurAvecPrixInvalide() {
        assertThrows(PrixBilletInvalidException.class, () -> new Billet(voyage, passager, -10.0));
    }

    /**
     * Test du constructeur avec un identifiant.
     */
    @Test
    public void testConstructeurAvecId() {
        Billet billet = new Billet("B123", voyage, passager, 50.0, false);
        assertEquals("B123", billet.getId());
        assertEquals(50.0, billet.getPrix());
        assertFalse(billet.isAnnule());
    }

    /**
     * Test de l'annulation d'un billet.
     *
     * @throws PrixBilletInvalidException si le prix est invalide
     */
    @Test
    public void testAnnulerBillet() throws PrixBilletInvalidException {
        Billet billet = new Billet(voyage, passager, 75.0);
        assertFalse(billet.isAnnule());
        billet.annuler();
        assertTrue(billet.isAnnule());
    }

}
package models;

import exceptions.PrixBilletInvalidException;

/**
 * La classe Billet représente un billet de train
 * Elle contient des informations sur l'identifiant ,
 * le voyage, le passager et le prix  du billet.
 */
public class Billet {
    /**
     * L'identifiant du billet.
     */
    private String id;
    /**
     * Le voyage lié au billet.
     */
    private Voyage voyage;
    /**
     * Le passager lié au billet.
     */
    private Passager passager;
    /**
     * Le prix du billet.
     */
    private double prix;

    /**
     * Indique si le billet est annuler ou non.
     */
    private boolean isAnnuler;


    /**
     * Constructeur de la classe Billet.
     * Permet de créer un billet avec les informations spécifiées.
     *
     * @param voyage Le voyage lié au billet.
     * @param passager Le passager lié au billet.
     * @param prix Le prix du billet
     * @throws PrixBilletInvalidException Si le prix est inférieure à zéro.
     */
    public Billet(Voyage voyage, Passager passager, double prix) throws PrixBilletInvalidException{
        if (prix < 0) {
            throw new PrixBilletInvalidException("La prix doit être supérieure ou égale à zéro.");
        }
        this.id = String.valueOf(java.util.UUID.randomUUID());
        this.voyage = voyage;
        this.passager = passager;
        this.prix = prix;
        this.isAnnuler = false;
    }

    /**
     * @return L'identifiant du billet.
     */
    public String getId() {
        return id;
    }

    /**
     * @return Le voyage liée au billet.
     */
    public Voyage getVoyage() {
        return voyage;
    }

    /**
     * @return Le passager liée au billet.
     */
    public Passager getPassager() {
        return passager;
    }

    /**
     * @return Le prix du billet.
     */
    public double getPrix() {
        return prix;
    }

    /**
     * @return Une chaîne de caractères représentant le billet.
     */
    @Override
    public String toString() {
        return "Billet{" +
                "id='" + id + '\'' +
                ", voyage=" + voyage +
                ", passager=" + passager +
                ", prix=" + prix +
                '}';
    }

    /**
     * Annule le billet.
     * Le billet ne pourra plus être utilisé.
     */
    public void annuler() {
        isAnnuler = true;
    }

    /**
     * @return true si le billet est annuler, false sinon.
     */
    public boolean isAnnuler() {
        return isAnnuler;
    }
}

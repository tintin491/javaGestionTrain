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
     * Indique si le billet est annulé ou non.
     */
    private boolean isAnnule;


    /**
     * Constructeur de la classe Billet.
     * Permet de créer un billet avec les informations spécifiées.
     * Constructeur pour la création de nouveau billet
     *
     * @param voyage Le voyage lié au billet.
     * @param passager Le passager lié au billet.
     * @param prix Le prix du billet
     * @throws PrixBilletInvalidException Si le prix est inférieur à zéro.
     */
    public Billet(Voyage voyage, Passager passager, double prix) throws PrixBilletInvalidException{
        if (prix < 0) {
            throw new PrixBilletInvalidException("La prix doit être supérieur ou égal à zéro.");
        }
        this.voyage = voyage;
        this.passager = passager;
        this.prix = prix;
        this.isAnnule = false;
    }

    /**
     * Constructeur de la classe Billet.
     * Permet de créer un billet avec les informations spécifiées.
     *
     * @param id identifiant du biller
     * @param voyage Le voyage lié au billet.
     * @param passager Le passager lié au billet.
     * @param prix Le prix du billet
     * @param isAnnule Indique si le billet est annuler ou non
     */
    public Billet(String id, Voyage voyage, Passager passager, double prix, boolean isAnnule){
        this.id = id;
        this.voyage = voyage;
        this.passager = passager;
        this.prix = prix;
        this.isAnnule = isAnnule;
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
     * Annule le billet.
     * Le billet ne pourra plus être utilisé.
     */
    public void annuler() {
        isAnnule = true;
    }

    /**
     * @return true si le billet est annulé, false sinon.
     */
    public boolean isAnnule() {
        return isAnnule;
    }
}

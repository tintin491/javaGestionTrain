package models;

/**
 * La classe Gare représente une gare ferroviaire où les trains partent et arrivent.
 * Elle contient des informations sur
 * le nom, l'adresse et la liste des trains disponibles de la gare.
 */
public class Gare {

    /**
     * Identifiant de la gare.
     */
    private String id;

    /**
     * Le nom de la gare.
     */
    private String nom;

    /**
     * L'adresse de la gare.
     */
    private String adresse;

    /**
     * Constructeur de la classe Gare.
     * Permet de créer une gare avec un nom, une adresse
     * Constructeur utiisée pour la création de nouvelle gare
     *
     * @param nom Le nom de la gare.
     * @param adresse L'adresse de la gare.
     */
    public Gare(String nom, String adresse){
        setNom(nom);
        setAdresse(adresse);
    }

    /**
     * Constructeur de la classe Gare.
     * Permet de créer une gare avec un nom, une adresse.
     * Constructeur utiisée pour récupéation de gare depuis la base de données
     *
     * @param nom Le nom de la gare.
     * @param adresse L'adresse de la gare.
     */
    public Gare(String id, String nom, String adresse){
        setId(id);
        setNom(nom);
        setAdresse(adresse);
    }

    /**
     * @return L'identifiant de la gare .
     */
    public String getId() {
        return id;
    }

    /**
     * @return Le nom de la gare.
     */
    public String getNom() {
        return nom;
    }

    /**
     * @return L'adresse de la gare.
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * Modifie le nom de la gare
     * @param nom de la gare
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Modifie l'adresse de la gare
     * @param adresse de la gare
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }


    /**
     * Modifie la l'identifiant  de la gare
     * @param id da la gare
     */
    private void setId(String id) {
        this.id = id;
    }
}

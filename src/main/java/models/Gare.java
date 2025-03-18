package models;

import java.util.ArrayList;

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
     * Train lié à la gare
     */
    private ArrayList<Train> trains;

    /**
     * Constructeur de la classe Gare.
     * Permet de créer une gare avec un nom, une adresse et une liste de trains.
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
     * Permet de créer une gare avec un nom, une adresse et une liste de trains.
     *
     * @param nom Le nom de la gare.
     * @param adresse L'adresse de la gare.
     */
    public Gare(String id, String nom, String adresse){
        this.id = id;
        setNom(nom);
        setAdresse(adresse);
    }

    /**
     * @return L'identifiant de .
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
     * @return La liste des trains de la gare
     */
    public ArrayList<Train> getTrains() {
        return trains;
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
     * Modifie la liste de train de la gare
     * @param trains de la gare
     */
    public void setTrains(ArrayList<Train> trains) {
        this.trains = trains;
    }
}

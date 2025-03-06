package model;
import java.util.ArrayList;

/**
 * La classe Gare représente une gare ferroviaire où les trains partent et arrivent.
 * Elle contient des informations sur le nom, l'adresse et la liste des trains disponibles dans la gare.
 *
 * <p>La gare peut avoir plusieurs trains associés à elle, et elle gère les informations liées à ces trains.</p>
 *
 */
public class Gare {

    /**
     * Le nom de la gare.
     */
    private String nom;

    /**
     * L'adresse de la gare.
     */
    private String adresse;

    /**
     * La liste des trains présents dans la gare.
     */
    private ArrayList<Train> listeTrains;

    /**
     * Constructeur de la classe Gare.
     * Permet de créer une gare avec un nom, une adresse et une liste de trains.
     *
     * @param nom Le nom de la gare.
     * @param adresse L'adresse de la gare.
     */
    public Gare(String nom, String adresse) {
        this.nom = nom;
        this.adresse = adresse;
        this.listeTrains = new ArrayList<>();  // Initialisation de la liste des trains
    }

    /**
     * Retourne le nom de la gare.
     *
     * @return Le nom de la gare.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Retourne l'adresse de la gare.
     *
     * @return L'adresse de la gare.
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * Ajoute un train à la liste des trains de la gare.
     *
     * @param train Le train à ajouter.
     */
    public void ajouterTrain(Train train) {
        if (train != null) {
            this.listeTrains.add(train);
        } else {
            System.out.println("Erreur : Le train ne peut pas être null.");
        }
    }

    /**
     * Supprime un train de la liste des trains de la gare.
     *
     * @param train Le train à supprimer.
     */
    public void supprimerTrain(Train train) {
        this.listeTrains.remove(train);
    }

    /**
     * Retourne la liste des trains présents dans la gare.
     *
     * @return Une liste de trains.
     */
    public ArrayList<Train> listeTrains() {
        return listeTrains;
    }

    /**
     * Recherche un train dans la gare en utilisant son identifiant.
     *
     * @param id L'identifiant du train.
     * @return Un train ou NULL
     */
    public Train trouverTrainParId(String id) {
        for (Train train : listeTrains) {
            if (train.getId().equals(id)) {
                return train;
            }
        }
        return null;
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères de la gare,
     * @return Une chaîne représentant la gare.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Gare: ").append(nom).append("\n");
        sb.append("Adresse: ").append(adresse).append("\n");
        sb.append("Trains disponibles: ").append(listeTrains.size()).append("\n");

        for (Train train : listeTrains) {
            sb.append(train.toString()).append("\n");
        }

        return sb.toString();
    }
}

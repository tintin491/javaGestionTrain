package models;

import java.time.LocalDateTime;

/**
 * La classe Horaire représente le liens entre un gare et un train à un date/heure
 * Elle contient des informations sur
 * l'identifiant de la gare, l'identifiant du train et une date.
 */
public class Horaire {
    /**
     * Train lié à l'horaire
     */
    private Train train;

    /**
     * Gare lié à l'horaire
     */
    private Gare gare;

    /**
     * Date/heure d'arrivé.
     */
    private LocalDateTime heureArrivee;

    /**
     * Date/heure de départ.
     */
    private LocalDateTime heureDepart;

    /**
     * Constructeur de la classe Horaire.
     * Permet de créer une horaire avec un train, une gare et un date
     *
     * @param train Le train.
     * @param gare La Gare.
     * @param heureArrivee heure d'arrivé
     * @param heureDepart heure de départ
     */
    public Horaire(Train train, Gare gare, LocalDateTime heureArrivee, LocalDateTime heureDepart) {
        setTrain(train);
        setGare(gare);
        setHeureArrivee(heureArrivee);
        setHeureDepart(heureDepart);
    }

    /**
     * @return Le train lié à l'horaire.
     */
    public Train getTrain() {
        return train;
    }

    /**
     * Modifie le train
     * @param train lié
     */
    public void setTrain(Train train) {
        this.train = train;
    }

    /**
     * @return La gare lié à l'horaire.
     */
    public Gare getGare() {
        return gare;
    }

    /**
     * Modifie la gare
     * @param gare lié
     */
    public void setGare(Gare gare) {
        this.gare = gare;
    }

    /**
     * @return L'heure d'arrivé.
     */
    public LocalDateTime getHeureArrivee() {
        return heureArrivee;
    }

    /**
     * @return L'heure d'arrivé.
     */
    public LocalDateTime getHeureDepart() {
        return heureDepart;
    }

    /**
     * Modifie la datetime
     * @param heureArrivee lié
     */
    public void setHeureArrivee(LocalDateTime heureArrivee) {
        this.heureArrivee = heureArrivee;
    }

    /**
     * Modifie la datetime
     * @param heureDepart lié
     */
    public void setHeureDepart(LocalDateTime heureDepart) {
        this.heureDepart = heureDepart;
    }
}

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
     * Date/heure.
     */
    private LocalDateTime heure;

    /**
     * Constructeur de la classe Horaire.
     * Permet de créer une horaire avec un train, une gare et un date
     *
     * @param train Le train.
     * @param gare La Gare.
     * @param heure L'heure
     */
    public Horaire(Train train, Gare gare, LocalDateTime heure) {
        this.train = train;
        this.gare = gare;
        this.heure = heure;
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
     * @return L'heure lié à l'horaire.
     */
    public LocalDateTime getHeure() {
        return heure;
    }

    /**
     * Modifie la datetime
     * @param heure lié
     */
    public void setHeure(LocalDateTime heure) {
        this.heure = heure;
    }
}

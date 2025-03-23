package services;

import models.Horaire;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class HoraireService {

    /**
     * Fonction pour rajouter une horaire.
     * @param horaire Horaire à ajouter
     */
    public void addHoraire(Horaire horaire) {
    }

    /**
     * Fonction pour supprimer une horaire.
     * @param horaire Horaire à ajouter
     */
    public void deleteHoraire(Horaire horaire) {
        //Todo
    }

    /**
     * Fonction pour update une horaire.
     * @param horaire Horaire à ajouter
     */
    public void updateHoraire(Horaire horaire) {
        //Todo
    }

    /**
     * Fonction qui recherche une liste d'horaire en fonction del'identifiant d'une gare
     * @param idGare identiant de la gare
     * @return une ArrayList<Horaire>
     */
    public ArrayList<Horaire> getHoraireByGareId (String idGare) {
        //Todo
        return null;
    }

    /**
     * Fonction qui recherche une liste d'horaire en fonction de l'identifiant d'un train
     * @param idTrain identiant du train
     * @return une ArrayList<Horaire>
     */
    public ArrayList<Horaire> getHoraireByTrainId (String idTrain) {
        //Todo
        return null;
    }

    /**
     * Fonction qui recherche une liste d'horaire en fonction d'une date
     * @param date la date
     * @return ArrayList<Horaire>
     */
    public ArrayList<Horaire> getHoraireByDate (LocalDateTime date) {
        //Todo
        return null;
    }

    /**
     * Fonction qui recherche une liste d'horaire en fonction de l'identifiant d'un train et d'une gare
     * @param idTrain identiant du train
     * @param idGare identiant de la gare
     * @return une ArrayList<Horaire>
     */
    public ArrayList<Horaire> getHoraireByTrainIdAndGareId (String idTrain, String idGare) {
        //Todo
        return null;
    }

    /**
     * Fonction qui recherche une liste d'horaire en fonction de l'identifiant d'un train et d'une gare
     * @param idTrain identiant du train
     * @param date la date
     * @return une ArrayList<Horaire>
     */
    public ArrayList<Horaire> getHoraireByTrainIdAndDate (String idTrain, LocalDateTime date) {
        //Todo
        return null;
    }

    /**
     * Fonction qui recherche une liste d'horaire en fonction de l'identifiant d'un train et d'une gare
     * @param idGare identiant de la gare
     * @param date la date
     * @return une ArrayList<Horaire>
     */
    public ArrayList<Horaire> getHoraireByGareIdAndDate (String idGare, LocalDateTime date) {
        //Todo
        return null;
    }

}

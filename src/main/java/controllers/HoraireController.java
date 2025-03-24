package controllers;

import models.Horaire;
import services.HoraireService;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class HoraireController {

    private final HoraireService horaireService;

    public HoraireController() {
        this.horaireService = new HoraireService();
    }

    /**
     * Fonction qui récupére la liste d'horaire
     * @return une ArrayList<Horaire>
     */
    public ArrayList<Horaire> getAllHoraire() {
        return horaireService.getAllHoraire();
    }

    /**
     * Fonction qui recherche une liste d'horaire en fonction de l'identifiant d'un train
     * @param idTrain identiant du train
     * @return une ArrayList<Horaire>
     */
    public ArrayList<Horaire>  getHoraireByTrainId(String idTrain) {
        return horaireService.getHoraireByTrainId(idTrain);
    }

    /**
     * Fonction qui recherche une liste d'horaire en fonction de l'identifiant d'un train et d'une gare
     * @param idTrain identiant du train
     * @param idGare identiant de la gare
     * @return une ArrayList<Horaire>
     */
    public ArrayList<Horaire>  getHoraireByTrainIdAndGareId(String idTrain, String idGare) {
        return horaireService.getHoraireByTrainIdAndGareId(idTrain, idGare);
    }

    /**
     * Fonction qui recherche une liste d'horaire en fonction d'une date de d"part
     * @param date la date de départ
     * @return ArrayList<Horaire>
     */
    public ArrayList<Horaire> getHoraireByDateDepart (LocalDateTime date) {
        return horaireService.getHoraireByDateDepart(date);
    }

    /**
     * Fonction qui recherche une liste d'horaire en fonction d'une date d'arrivé
     * @param date la date d'arrivee
     * @return ArrayList<Horaire>
     */
    public ArrayList<Horaire> getHoraireByDateArrivee (LocalDateTime date) {
        return horaireService.getHoraireByDateArrivee(date);
    }

    /**
     * Fonction qui recherche une liste d'horaire en fonction de l'identifiant d'une gare
     * @param idGare identiant de la gare
     * @return ArrayList<Horaire>
     */
    public ArrayList<Horaire>  getHoraireByGareId(String idGare) {
        return horaireService.getHoraireByGareId(idGare);
    }

    /**
     * Fonction pour ajouter une gare.
     * @param horaire Horaire à ajouter
     */
    public void addHoraire(Horaire horaire) {
        horaireService.addHoraire(horaire);
    }

    /**
     * Fonction pour update une horaire.
     * @param horaire Horaire à ajouter
     */
    public void updateHoraire(Horaire horaire) {
        horaireService.updateHoraire(horaire);
    }

    /**
     * Fonction pour delete une horaire.
     * @param horaire Horaire à ajouter
     */
    public void deleteHoraire(Horaire horaire) {
        horaireService.deleteHoraire(horaire);
    }

}

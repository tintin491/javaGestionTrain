package controllers;

import models.Gare;
import services.GareService;
import services.TrainService;

import java.util.ArrayList;

public class GareController {

    private final GareService gareService;

    public GareController() {
        this.gareService = new GareService();
    }

    /**
     * Fonction qui récupére toutes les gares avec leur trains
     * @param trainService le service des train
     * @return une liste de gare
     */
    public ArrayList<Gare> getAllGareWithTrain(TrainService trainService) {
        return gareService.getAllGaresWithTrain(trainService);
    }

    /**
     * Fonction qui recherche une gare en fonction de son identifiant avec ces trains
     * @param id identiant de la gare
     * @param trainService le service des train
     * @return une gare ou NUll
     */
    public Gare getGAreByIdWithTrain(TrainService trainService, String id) {
        return gareService.getGareByIdWithTrain(trainService, id);
    }

    /**
     * Fonction qui récupére toutes les gares avec leur trains
     * @return une liste de gare
     */
    public ArrayList<Gare> getAllGare() {
        return gareService.getAllGares();
    }

    /**
     * Fonction qui recherche une gare en fonction de son identifiant avec ces trains
     * @param id identiant de la gare
     * @return une gare ou NUll
     */
    public Gare getGAreByIdWithTrain( String id) {
        return gareService.getGareById(id);
    }

    /**
     * Fonction pour rajouter une gare.
     * @param nom de la gare
     * @param adresse de la gare
     */
    public void addGare(String nom, String adresse) {
        Gare newGare = new Gare(nom, adresse);
        gareService.addGare(newGare);
    }
}

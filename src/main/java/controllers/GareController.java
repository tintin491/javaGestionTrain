package controllers;

import models.Gare;
import services.GareService;

import java.util.ArrayList;

public class GareController {

    private final GareService gareService;

    public GareController() {
        this.gareService = new GareService();
    }

    /**
     * Fonction qui récupére toutes les gares
     * @return une liste de gare
     */
    public ArrayList<Gare> getAllGares() {
        return gareService.getAllGares();
    }

    /**
     * Fonction qui recherche une gare en fonction de son identifiant
     * @param id identiant de la gare
     * @return une gare ou NUll
     */
    public Gare getGareByI(String id) {
        return gareService.getGareByI(id);
    }

    /**
     * Fonction pour ajouter une gare.
     * @param gare Gare à ajouter
     */
    public void addGare(Gare gare) {
        gareService.addGare(gare);
    }

    /**
     * Fonction pour update une gare.
     * @param gare Gare à update
     */
    public void updateGare(Gare gare) {
        gareService.updateGare(gare);
    }

    /**
     * Fonction pour supprimer une gare.
     * @param gare Gare à supprimer
     */
    public void deleteGare(Gare gare) {
        gareService.deleteGare(gare);
    }
}

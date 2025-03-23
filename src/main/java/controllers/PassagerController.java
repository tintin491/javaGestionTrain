package controllers;

import models.Passager;
import services.PassagerService;
import java.util.ArrayList;

public class PassagerController {
    private final PassagerService passagerService;

    public PassagerController() {
        this.passagerService = new PassagerService();
    }

    /**
     * Fonction qui récupére toutes les passager
     * @return une liste de passager
     */
    public ArrayList<Passager> getAllPassagers()  {
        return passagerService.getAllPassagers();
    }

    /**
     * Fonction qui recherche un passager en fonction de son identifiant
     * @param id identiant du passagers
     * @return un passager ou NUll
     */
    public Passager getPassagerByI(String id)  {
        return passagerService.getPassagerById(id);
    }

    /**
     * Fonction pour ajouter un passager.
     * @param passager passager à ajouter
     */
    public void addPassager(Passager passager) {
        passagerService.addPassager(passager);
    }

    /**
     * Fonction pour update un passager.
     * @param passager passager à update
     */
    public void updatePassager(Passager passager) {
        passagerService.updatePassager(passager);
    }

    /**
     * Fonction pour supprimer un passager.
     * @param passager passager à supprimer
     */
    public void deletePassager(Passager passager) {
        passagerService.deletePassager(passager);
    }
}

package controllers;

import models.Billet;
import services.BilletService;

import java.util.ArrayList;

public class BilletController {
    private final BilletService billetService;

    public BilletController() {
        this.billetService = new BilletService();
    }

    /**
     * Fonction qui récupére toutes les billets
     * @return une liste de billet
     */
    public ArrayList<Billet> getAllBillet() {
        return billetService.getAllBillet();
    }

    /**
     * Fonction qui recherche un billet en fonction de son identifiant
     * @param id identiant du billet
     * @return un billet ou NUll
     */
    public Billet getBilletByI(String id) {
        return billetService.getBilletByI(id);
    }

    /**
     * Fonction pour ajouter un billet.
     * @param billet Billet à ajouter
     */
    public void addBillet(Billet billet) {
        billetService.addBillet(billet);
    }

    /**
     * Fonction pour update un billet.
     * @param billet Billet à update
     */
    public void updateBillet(Billet billet) {
        billetService.updateBillet(billet);
    }

    /**
     * Fonction pour supprimer un billet.
     * @param billet Billet à supprimer
     */
    public void deleteBillet(Billet billet) {
        billetService.deleteBillet(billet);
    }
}

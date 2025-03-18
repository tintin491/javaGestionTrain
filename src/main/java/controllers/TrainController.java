package controllers;

import exceptions.CapaciteTrainInvalidException;
import models.Train;
import services.TrainService;

import java.util.ArrayList;

public class TrainController {

    private final TrainService trainService;

    public TrainController() {
        this.trainService = new TrainService();
    }

    /**
     * Fonction qui récupére tous les trains
     * @return une liste de Train
     */
    public ArrayList<Train> getAllTrains() {
        return trainService.getAllTrains();
    }

    /**
     * Fonction qui recherche un Train en fonction de son identifiant
     * @param id identiant du train
     * @return un Train ou NUll
     */
    public Train getTrainById(String id) {
        return trainService.getTrainById(id);
    }

    /**
     * Fonction pour rajouter un train.
     * @param type Le type du train.
     * @param capacite La capacité du train.
     * @param enService Indique si le train est en service ou non.
     */
    public void addTrain(String type, int capacite, boolean enService) throws CapaciteTrainInvalidException {
        Train newTrain = new Train(type, capacite, enService);
        trainService.addTrain(newTrain);
    }
}


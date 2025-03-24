package controllers;
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
     * Fonction pour ajouter un train.
     * @param train Train à ajouter
     * */
    public void addTrain(Train train) {
        trainService.addTrain(train);
    }

    /**
     * Fonction pour update un train.
     * @param train Train à update
     * */
    public void updateTrain(Train train){
        trainService.updateTrain(train);
    }
}


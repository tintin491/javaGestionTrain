import controllers.GareController;
import controllers.PassagerController;
import controllers.TrainController;
import database.DatabaseManager;
import models.Gare;
import models.Passager;
import models.Train;

public class Main {
    public static void main(String[] args) throws Exception {
        DatabaseManager.initializeDatabase();
        TrainController trainController = new TrainController();
        GareController gareController = new GareController();
        PassagerController passagerController = new PassagerController();

        var trainA =   new Train("TGV", 300, true);
        var trainB =   new Train("TGV2", 300, true);
        trainController.addTrain(trainA);
        trainController.addTrain(trainB);

        var a = trainController.getAllTrains();
        System.out.println("liste:" + a);
        var b = trainController.getTrainById("1");
        System.out.println("id" + b);

        var gareA =   new Gare("Gare1", "Rue");
        var gareB =   new Gare("Gare2", "Rue");
        gareController.addGare(gareA);
        gareController.addGare(gareB);

        var c = gareController.getAllGares();
        System.out.println("liste:" + c);
        var d = gareController.getGareByI("1");
        System.out.println("id" + d);

        var passagerA =   new Passager("nom1", "prenom1", "email1");
        var passagerB =   new Passager("nom2", "prenom2", "email2");
        passagerController.addPassager(passagerA);
        passagerController.addPassager(passagerB);

        var e = passagerController.getAllPassagers();
        System.out.println("liste:" + e);
        var f = passagerController.getPassagerByI("1");
        System.out.println("id" + f);
    }
}
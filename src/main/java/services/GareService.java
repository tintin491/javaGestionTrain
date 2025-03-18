package services;

import exceptions.CapaciteTrainInvalidException;
import models.Gare;
import models.Train;

import java.sql.*;
import java.util.ArrayList;

public class GareService {
    private static final String DB_URL = "jdbc:sqlite:gestion_gare.db"; // Base de données SQLite
    private Connection connection;

    public GareService() {
        try {
            connection = DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Fonction pour rajouter une gare.
     * @param gare Gare à ajouter
     */
    public void addGare(Gare gare) {
        String sql = "INSERT INTO Gare (nom, adresse) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(    1,  gare.getNom());
            pstmt.setString(2, gare.getAdresse());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Fonction qui recherche un gare en fonction de son identifiant
     * @param id identiant de la gare
     * @param trainService Le service du train
     * @return un Train ou NUll
     */
    public Gare getGareByIdWithTrain(TrainService trainService, String id) {
        Gare gare;
        String sql = "SELECT id, nom, adresse FROM Gare WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                gare = new Gare(rs.getString("nom"), rs.getString("adresse"));
                ArrayList<Train> trains = trainService.getTrainByGare(gare.getId());
                gare.setTrains(trains);
            }
        } catch (SQLException | CapaciteTrainInvalidException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Fonction qui recherche un gare en fonction de son identifiant
     * @param id identiant de la gare
     * @return un Train ou NUll
     */
    public Gare getGareById(String id) {
        String sql = "SELECT id, nom, adresse FROM Gare WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                new Gare(rs.getString("nom"), rs.getString("adresse"));

            }
        } catch (SQLException e ) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Fonction qui récupére toutes les gares avec leurs trains
     * @param trainService service du train
     * @return une liste de gare
     */
    public ArrayList<Gare> getAllGaresWithTrain(TrainService trainService) {
        ArrayList<Gare> gares = new ArrayList<>();
        String sql = "SELECT id, nom, adresse FROM Gare";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Gare gare = new Gare(
                        rs.getString("id"),
                        rs.getString("nom"),
                        rs.getString("adresse"));
                ArrayList<Train> trains = trainService.getTrainByGare(gare.getId());
                gares.add(gare);

                gare.setTrains(trains);
            }
        } catch (SQLException | CapaciteTrainInvalidException e) {
            e.printStackTrace();
        }
        return gares;
    }

    /**
     * Fonction qui récupére toutes les gares
     * @return une liste de gare
     */
    public ArrayList<Gare> getAllGares() {
        ArrayList<Gare> gares = new ArrayList<>();
        String sql = "SELECT id, nom, adresse FROM Gare";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                gares.add(new Gare(
                        rs.getString("id"),
                        rs.getString("nom"),
                        rs.getString("adresse")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gares;
    }

}

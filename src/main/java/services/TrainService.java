package services;

import exceptions.CapaciteTrainInvalidException;
import models.Train;
import java.sql.*;
import java.util.ArrayList;

public class TrainService {

    private static final String DB_URL = "jdbc:sqlite:gestion_gare.db"; // Base de données SQLite
    private Connection connection;

    public TrainService() {
        try {
            connection = DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Fonction pour rajouter un train.
     * @param train Train à ajouter
     */
    public void addTrain(Train train) {
        String sql = "INSERT INTO Train (text_type, capacite, enService) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(    1, train.getType());
            pstmt.setInt(2, train.getCapacite());
            pstmt.setBoolean(3, train.isEnService());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Fonction qui recherche un Train en fonction de son identifiant
     * @param id identiant du train
     * @return un Train ou NUll
     */
    public Train getTrainById(String id) {
        String sql = "SELECT * FROM Train WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Train(
                        rs.getString("id"),
                        rs.getString("text_type"),
                        rs.getInt("capacite"),
                        rs.getBoolean("enService")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Fonction qui récupére tous les trains
     * @return une liste de Train
     */
    public ArrayList<Train> getAllTrains() {
        ArrayList<Train> trains = new ArrayList<>();
        String sql = "SELECT id, text_type, capacite, enService FROM Train";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                trains.add(new Train(
                        rs.getString("id"),
                        rs.getString("text_type"),
                        rs.getInt("capacite"),
                        rs.getBoolean("enService")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trains;
    }

    /**
     * Fonction qui récupére tous les trains lié à une gare
     * @param idGare Identifiant de la gare
     * @return une liste de Train
     */
    public ArrayList<Train> getTrainByGare(String idGare) throws SQLException, CapaciteTrainInvalidException {
        ArrayList<Train> trains = new ArrayList<>();
        String selectTrainsSQL = "SELECT t.type, t.capacite, t.enService " +
                "FROM Train t " +
                "JOIN GareTrain gt ON t.id = gt.train_id " +
                "JOIN Gare g ON gt.gare_id = g.id " +
                "WHERE g.id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(selectTrainsSQL)) {
            pstmt.setString(1, idGare);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String type = rs.getString("type");
                int capacite = rs.getInt("capacite");
                boolean enService = rs.getBoolean("enService");
                trains.add(new Train(type, capacite, enService));
            }
        }

        return trains;
    }
}

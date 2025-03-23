package services;

import database.DatabaseConnection;
import exceptions.CapaciteTrainInvalidException;
import models.Train;
import java.sql.*;
import java.util.ArrayList;

public class TrainService {

    /**
     * Fonction pour rajouter un train.
     * @param train Train à ajouter
     */
    public void addTrain(Train train) {
        String sql = "INSERT INTO Train (text_type, capacite, enService) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = DatabaseConnection.getConnection().prepareStatement(sql)) {
            pstmt.setString(    1, train.getType());
            pstmt.setInt(2, train.getCapacite());
            pstmt.setBoolean(3, train.isEnService());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Fonction pour update un train.
     * @param train Train à update
     */
    public void updateTrain(Train train) {
        String sql = "UPDATE Train SET text_type = ?, capacite = ?, enServie = ? WHERE id = ?";
        try (PreparedStatement pstmt = DatabaseConnection.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, train.getType());
            pstmt.setInt(2, train.getCapacite());
            pstmt.setBoolean(3, train.isEnService());
            pstmt.setString(4, train.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Fonction pour supprimer un train.
     * @param train Train à supprimer
     */
    public void deleteTrain(Train train) {
        String sql = "DELETE FROM Train WHERE id = ?";
        try (PreparedStatement pstmt = DatabaseConnection.getConnection().prepareStatement(sql)) {
            pstmt.setString(    1, train.getId());
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
        try (PreparedStatement pstmt = DatabaseConnection.getConnection().prepareStatement(sql)) {
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
        } catch (SQLException | CapaciteTrainInvalidException e) {
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
        try (Statement stmt = DatabaseConnection.getConnection().createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                trains.add(new Train(
                        rs.getString("id"),
                        rs.getString("text_type"),
                        rs.getInt("capacite"),
                        rs.getBoolean("enService")
                ));
            }
        } catch (SQLException | CapaciteTrainInvalidException e) {
            e.printStackTrace();
        }
        return trains;
    }
}

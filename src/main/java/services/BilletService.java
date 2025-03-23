package services;

import database.DatabaseConnection;
import models.Billet;
import java.sql.*;
import java.util.ArrayList;

public class BilletService {

    /**
     * Fonction pour ajouter un billet.
     * @param billet biller à ajouter
     */
    public void addGare(Billet billet) {
        String sql = "INSERT INTO Billet (passagerId, passagerId, prix, isAnnuler) VALUES (?, ?, ?, true)";
        try (PreparedStatement pstmt = DatabaseConnection.getConnection().prepareStatement(sql)) {
            pstmt.setString(    1,  billet.getPassager().getId());
            pstmt.setString(2, billet.getVoyage().getId());
            pstmt.setDouble(3, billet.getPrix());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Fonction pour update un billet.
     * @param billet Billet à update
     */
    public void updateGare(Billet billet) {
        String sql = "UPDATE Gare SET passagerId  = ?, passagerId = ?, prix = ?, isAnnuler = ? WHERE id = ?";
        try (PreparedStatement pstmt = DatabaseConnection.getConnection().prepareStatement(sql)) {
            pstmt.setString(    1,  billet.getPassager().getId());
            pstmt.setString(2, billet.getVoyage().getId());
            pstmt.setDouble(3, billet.getPrix());
            pstmt.setBoolean(4, billet.isAnnuler());
            pstmt.setString(    5,  billet.getId());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Fonction pour supprimer un billet.
     * @param billet Billet à supprimer
     */
    public void deleteGare(Billet billet) {
        String sql = "DELETE FROM Billet WHERE id = ?";
        try (PreparedStatement pstmt = DatabaseConnection.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, billet.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Fonction qui recherche un billet en fonction de son identifiant
     * @param id identiant de la gare
     * @return un Billet ou NUll
     */
    public Billet getBilletByI(String id) {
        //Todo
        return null;
    }

    /**
     * Fonction qui récupére tous les billets
     * @return une liste de billet
     */
    public ArrayList<Billet> getAllBillet() {
        ArrayList<Billet> billets = new ArrayList<>();
        String sql = "SELECT id, nom, adresse FROM Billet";
        try (Statement stmt = DatabaseConnection.getConnection().createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Todo
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return billets;
    }
}

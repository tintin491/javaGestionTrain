package services;

import database.DatabaseConnection;
import models.Gare;
import java.sql.*;
import java.util.ArrayList;

public class GareService {

    /**
     * Fonction pour rajouter une gare.
     * @param gare Gare à ajouter
     */
    public void addGare(Gare gare) {
        String sql = "INSERT INTO Gare (nom, adresse) VALUES (?, ?)";
        try (PreparedStatement pstmt = DatabaseConnection.getConnection().prepareStatement(sql)) {
            pstmt.setString(    1,  gare.getNom());
            pstmt.setString(2, gare.getAdresse());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Fonction pour update une gare.
     * @param gare Gare à update
     */
    public void updateGare(Gare gare) {
        String sql = "UPDATE Gare SET nom = ?, adresse = ? WHERE id = ?";
        try (PreparedStatement pstmt = DatabaseConnection.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, gare.getNom());
            pstmt.setString(2, gare.getAdresse());
            pstmt.setString(3, gare.getId());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Fonction pour supprimer une gare.
     * @param gare Gare à supprimer
     */
    public void deleteGare(Gare gare) {
        String sql = "DELETE FROM Gare WHERE id = ?";
        try (PreparedStatement pstmt = DatabaseConnection.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, gare.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Fonction qui recherche une gare en fonction de son identifiant
     * @param id identiant de la gare
     * @return un Gare ou NUll
     */
    public Gare getGareByI(String id) {
        String sql =  "SELECT id, nom, adresse FROM Gare where id = ?";
        try (PreparedStatement pstmt = DatabaseConnection.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Gare(rs.getString("id"), rs.getString("nom"), rs.getString("adresse"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Fonction qui récupére toutes les gares
     * @return une liste de gare
     */
    public ArrayList<Gare> getAllGares() {
        ArrayList<Gare> gares = new ArrayList<>();
        String sql = "SELECT id, nom, adresse FROM Gare";
        try (Statement stmt = DatabaseConnection.getConnection().createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Gare gare = new Gare(
                        rs.getString("id"),
                        rs.getString("nom"),
                        rs.getString("adresse"));
                gares.add(gare);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gares;
    }
}

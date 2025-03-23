package services;

import database.DatabaseConnection;
import models.Passager;

import java.sql.*;
import java.util.ArrayList;

public class PassagerService {
    /**
     * Fonction pour rajouter un passager.
     * @param passager Passager à ajouter
     */
    public void addPassager(Passager passager) {
        String sql = "INSERT INTO Passager (nom, prenom, email) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = DatabaseConnection.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, passager.getNom());
            pstmt.setString(2, passager.getPrenom());
            pstmt.setString(3, passager.getEmail());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Fonction pour update un passager.
     * @param passager Passager à update
     */
    public void updatePassager(Passager passager) {
        String sql = "UPDATE Passager SET nom = ?, prenom = ?, email = ? WHERE id = ?";
        try (PreparedStatement pstmt = DatabaseConnection.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, passager.getNom());
            pstmt.setString(2, passager.getPrenom());
            pstmt.setString(3, passager.getEmail());
            pstmt.setString(4, passager.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Fonction pour supprimer un passager.
     * @param passager Passager à supprimer
     */
    public void deletePassager(Passager passager) {
        String sql = "DELETE FROM Passager WHERE id = ?";
        try (PreparedStatement pstmt = DatabaseConnection.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, passager.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Fonction qui récupére tous les passagers
     * @return une liste de Passsagers
     */
    public ArrayList<Passager> getAllPassagers() {
        ArrayList<Passager> passagers = new ArrayList<>();
        String sql = "SELECT * FROM Passager";
        try (Statement stmt = DatabaseConnection.getConnection().createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Passager passager = new Passager(
                        rs.getString("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("email")
                );
                passagers.add(passager);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return passagers;
    }

    /**
     * Fonction qui recherche un Passager en fonction de son identifiant
     * @param id identiant du passager
     * @return un Train ou NUll
     */
    public Passager getPassagerById(String id) {
        String sql = "SELECT * FROM Passager WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Passager(
                            rs.getString("id"),
                            rs.getString("nom"),
                            rs.getString("prenom"),
                            rs.getString("email")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

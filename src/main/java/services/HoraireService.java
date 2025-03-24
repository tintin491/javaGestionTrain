package services;

import database.DatabaseConnection;
import exceptions.CapaciteTrainInvalidException;
import models.Gare;
import models.Horaire;
import models.Train;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class HoraireService {

    /**
     * Fonction pour rajouter une horaire.
     * @param horaire Horaire à ajouter
     */
    public void addHoraire(Horaire horaire) {
        String query = "INSERT INTO horaires (gare_id, train_id, heure_depart, heure_arrivee) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = DatabaseConnection.getConnection().prepareStatement(query)) {
            Timestamp heureDepartTimestamp = Timestamp.valueOf(horaire.getHeureDepart());
            Timestamp heureArriveeTimestamp = Timestamp.valueOf(horaire.getHeureArrivee());

            pstmt.setString(1, horaire.getGare().getId());
            pstmt.setString(2, horaire.getTrain().getId());
            pstmt.setTimestamp(3, heureDepartTimestamp);
            pstmt.setTimestamp(4, heureArriveeTimestamp);
            pstmt.executeUpdate();
            System.out.println("Horaire ajouté : " + horaire);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Fonction pour supprimer une horaire.
     * @param horaire Horaire à ajouter
     */
    public void deleteHoraire(Horaire horaire) {
        String query = "DELETE FROM horaires WHERE train_id = ? AND gare_id = ? AND heure_depart = ?";
        try (PreparedStatement pstmt = DatabaseConnection.getConnection().prepareStatement(query)) {
            Timestamp heureDepartTimestamp = Timestamp.valueOf(horaire.getHeureDepart());

            pstmt.setString(1, horaire.getTrain().getId());
            pstmt.setString(2, horaire.getGare().getId());
            pstmt.setTimestamp(3, heureDepartTimestamp);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Fonction pour update une horaire.
     * @param horaire Horaire à ajouter
     */
    public void updateHoraire(Horaire horaire) {
        String query = "UPDATE Horaire SET date_depart = ?, date_arrive = ? WHERE gare_id = ? AND train_id = ? AND date_arrive = ?";
        try (PreparedStatement pstmt = DatabaseConnection.getConnection().prepareStatement(query)) {
            Timestamp heureDepartTimestamp = Timestamp.valueOf(horaire.getHeureDepart());
            Timestamp heureArriveeTimestamp = Timestamp.valueOf(horaire.getHeureArrivee());

            pstmt.setTimestamp(1,heureDepartTimestamp);
            pstmt.setString(2, horaire.getGare().getId());
            pstmt.setString(3, horaire.getTrain().getId());
            pstmt.setTimestamp(4, heureArriveeTimestamp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Fonction qui recherche la liste d'horaire
     * @return une ArrayList<Horaire>
     */
    public ArrayList<Horaire> getAllHoraire () {
        ArrayList<Horaire> horaires = new ArrayList<>();
        String query = "SELECT H.gare_id, H.train_id, H.date_arrive, H.date_depart, " +
                "T.capacite, T.type, T.enService, G.nom, G.adresse" +
                "G.nom AS gare_nom, G.adresse AS gare_adresse," +
                "T.nom AS train_nom, T.type AS train_type" +
                "FROM Horaire H" +
                "JOIN Gare G ON H.gare_id = G.id" +
                "JOIN Train T ON H.train_id = T.id";

        try (PreparedStatement pstmt = DatabaseConnection.getConnection().prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                LocalDateTime dateArrivee = rs.getTimestamp("date_arrive").toLocalDateTime();
                LocalDateTime dateDepart = rs.getTimestamp("date_depart").toLocalDateTime();

                Train train = new Train(rs.getString("train_id"),rs.getString("type"), rs.getInt("capacite"), rs.getBoolean("enService"));
                Gare gare = new Gare(rs.getString("gare_id"), rs.getString("nom"), rs.getString("adresse"));
                Horaire horaire = new Horaire(train,gare, dateArrivee, dateDepart);
                horaires.add(horaire);
            }

        } catch (SQLException | CapaciteTrainInvalidException e) {
            System.err.println("Erreur lors de la récupération des horaires: " + e.getMessage());
        }
        return horaires;
    }


    /**
     * Fonction qui recherche une liste d'horaire en fonction de l'identifiant d'une gare
     * @param idGare identiant de la gare
     * @return ArrayList<Horaire>
     */
    public ArrayList<Horaire> getHoraireByGareId (String idGare) {
        ArrayList<Horaire> horaires = new ArrayList<>();
        String query = "SELECT H.gare_id, H.train_id, H.date_arrive, H.date_depart, " +
                       "T.capacite, T.type, T.enService, G.nom, G.adresse" +
                       "G.nom AS gare_nom, G.adresse AS gare_adresse," +
                       "T.nom AS train_nom, T.type AS train_type" +
                       "FROM Horaire H" +
                       "JOIN Gare G ON H.gare_id = G.id" +
                       "JOIN Train T ON H.train_id = T.id" +
                       "WHERE H.gare_id = ?";

        try (PreparedStatement pstmt = DatabaseConnection.getConnection().prepareStatement(query)) {
            pstmt.setString(1, idGare);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                LocalDateTime dateArrivee = rs.getTimestamp("date_arrive").toLocalDateTime();
                LocalDateTime dateDepart = rs.getTimestamp("date_depart").toLocalDateTime();

                Train train = new Train(rs.getString("train_id"),rs.getString("type"), rs.getInt("capacite"), rs.getBoolean("enService"));
                Gare gare = new Gare(rs.getString("gare_id"), rs.getString("nom"), rs.getString("adresse"));
                Horaire horaire = new Horaire(train,gare, dateArrivee, dateDepart);
                horaires.add(horaire);
            }

        } catch (SQLException | CapaciteTrainInvalidException e) {
            System.err.println("Erreur lors de la récupération des horaires: " + e.getMessage());
        }
        return horaires;
    }

    /**
     * Fonction qui recherche une liste d'horaire en fonction de l'identifiant d'un train
     * @param idTrain identiant du train
     * @return une ArrayList<Horaire>
     */
    public ArrayList<Horaire> getHoraireByTrainId (String idTrain) {
        ArrayList<Horaire> horaires = new ArrayList<>();
        String query = "SELECT H.gare_id, H.train_id, H.date_arrive, H.date_depart, " +
                "T.capacite, T.type, T.enService, G.nom, G.adresse" +
                "G.nom AS gare_nom, G.adresse AS gare_adresse," +
                "T.nom AS train_nom, T.type AS train_type" +
                "FROM Horaire H" +
                "JOIN Gare G ON H.gare_id = G.id\n" +
                "JOIN Train T ON H.train_id = T.id\n" +
                "WHERE H.train_id = ?";

        try (PreparedStatement pstmt = DatabaseConnection.getConnection().prepareStatement(query)) {
            pstmt.setString(1, idTrain);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                LocalDateTime dateArrivee = rs.getTimestamp("date_arrive").toLocalDateTime();
                LocalDateTime dateDepart = rs.getTimestamp("date_depart").toLocalDateTime();

                Train train = new Train(rs.getString("train_id"),rs.getString("type"), rs.getInt("capacite"), rs.getBoolean("enService"));
                Gare gare = new Gare(rs.getString("gare_id"), rs.getString("nom"), rs.getString("adresse"));
                Horaire horaire = new Horaire(train,gare, dateArrivee, dateDepart);
                horaires.add(horaire);
            }

        } catch (SQLException | CapaciteTrainInvalidException e) {
            System.err.println("Erreur lors de la récupération des horaires: " + e.getMessage());
        }
        return horaires;
    }

    /**
     * Fonction qui recherche une liste d'horaire en fonction d'une date d'arrivé
     * @param date la date d'arrivee
     * @return ArrayList<Horaire>
     */
    public ArrayList<Horaire> getHoraireByDateArrivee (LocalDateTime date) {
        ArrayList<Horaire> horaires = new ArrayList<>();
        String query = "SELECT H.gare_id, H.train_id, H.date_arrive, H.date_depart, " +
                "T.capacite, T.type, T.enService, G.nom, G.adresse" +
                "G.nom AS gare_nom, G.adresse AS gare_adresse," +
                "T.nom AS train_nom, T.type AS train_type" +
                "FROM Horaire H" +
                "JOIN Gare G ON H.gare_id = G.id\n" +
                "JOIN Train T ON H.train_id = T.id\n" +
                "WHERE H.date_arrive = ?";

        try (PreparedStatement pstmt = DatabaseConnection.getConnection().prepareStatement(query)) {
            Timestamp heureArriveeTimestamp = Timestamp.valueOf(date);
            pstmt.setTimestamp(1,heureArriveeTimestamp);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                LocalDateTime dateArrivee = rs.getTimestamp("date_arrive").toLocalDateTime();
                LocalDateTime dateDepart = rs.getTimestamp("date_depart").toLocalDateTime();

                Train train = new Train(rs.getString("train_id"),rs.getString("type"), rs.getInt("capacite"), rs.getBoolean("enService"));
                Gare gare = new Gare(rs.getString("gare_id"), rs.getString("nom"), rs.getString("adresse"));
                Horaire horaire = new Horaire(train,gare, dateArrivee, dateDepart);
                horaires.add(horaire);
            }

        } catch (SQLException | CapaciteTrainInvalidException e) {
            System.err.println("Erreur lors de la récupération des horaires: " + e.getMessage());
        }
        return horaires;
    }

    /**
     * Fonction qui recherche une liste d'horaire en fonction d'une date de départ
     * @param date la date de départ
     * @return ArrayList<Horaire>
     */
    public ArrayList<Horaire> getHoraireByDateDepart (LocalDateTime date) {
        ArrayList<Horaire> horaires = new ArrayList<>();
        String query = "SELECT H.gare_id, H.train_id, H.date_arrive, H.date_depart, " +
                "T.capacite, T.type, T.enService, G.nom, G.adresse" +
                "G.nom AS gare_nom, G.adresse AS gare_adresse," +
                "T.nom AS train_nom, T.type AS train_type" +
                "FROM Horaire H" +
                "JOIN Gare G ON H.gare_id = G.id" +
                "JOIN Train T ON H.train_id = T.id" +
                "WHERE H.date_depart = ?";

        try (PreparedStatement pstmt = DatabaseConnection.getConnection().prepareStatement(query)) {
            Timestamp heureDepartTimestamp = Timestamp.valueOf(date);
            pstmt.setTimestamp(1,heureDepartTimestamp);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                LocalDateTime dateArrivee = rs.getTimestamp("date_arrive").toLocalDateTime();
                LocalDateTime dateDepart = rs.getTimestamp("date_depart").toLocalDateTime();

                Train train = new Train(rs.getString("train_id"),rs.getString("type"), rs.getInt("capacite"), rs.getBoolean("enService"));
                Gare gare = new Gare(rs.getString("gare_id"), rs.getString("nom"), rs.getString("adresse"));
                Horaire horaire = new Horaire(train,gare, dateArrivee, dateDepart);
                horaires.add(horaire);
            }

        } catch (SQLException | CapaciteTrainInvalidException e) {
            System.err.println("Erreur lors de la récupération des horaires: " + e.getMessage());
        }
        return horaires;
    }


    /**
     * Fonction qui recherche une liste d'horaire en fonction de l'identifiant d'un train et d'une gare
     * @param idTrain identiant du train
     * @param idGare identiant de la gare
     * @return une ArrayList<Horaire>
     */
    public ArrayList<Horaire> getHoraireByTrainIdAndGareId (String idTrain, String idGare) {
        ArrayList<Horaire> horaires = new ArrayList<>();
        String query = "SELECT H.gare_id, H.train_id, H.date_arrive, H.date_depart, " +
                "T.capacite, T.type, T.enService, G.nom, G.adresse" +
                "G.nom AS gare_nom, G.adresse AS gare_adresse," +
                "T.nom AS train_nom, T.type AS train_type" +
                "FROM Horaire H" +
                "JOIN Gare G ON H.gare_id = G.id" +
                "JOIN Train T ON H.train_id = T.id" +
                "WHERE H.date_arrive = ? ANS H.train_id = ?";

        try (PreparedStatement pstmt = DatabaseConnection.getConnection().prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();
            pstmt.setString(2, idGare);
            pstmt.setString(1, idTrain);

            while (rs.next()) {
                LocalDateTime dateArrivee = rs.getTimestamp("date_arrive").toLocalDateTime();
                LocalDateTime dateDepart = rs.getTimestamp("date_depart").toLocalDateTime();

                Train train = new Train(rs.getString("train_id"),rs.getString("type"), rs.getInt("capacite"), rs.getBoolean("enService"));
                Gare gare = new Gare(rs.getString("gare_id"), rs.getString("nom"), rs.getString("adresse"));
                Horaire horaire = new Horaire(train,gare, dateArrivee, dateDepart);
                horaires.add(horaire);
            }

        } catch (SQLException | CapaciteTrainInvalidException e) {
            System.err.println("Erreur lors de la récupération des horaires: " + e.getMessage());
        }
        return horaires;
    }
}

package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Classe qui gère la connexion à la base de données SQLite et l'initialisation des tables.
 * Elle permet d'ouvrir une connexion à la base de données et de créer les tables si elles n'existent pas encore.
 */
public class DatabaseManager {

    private static final String DB_URL = "jdbc:sqlite:gestion_gare.db";

    /**
     * Classe qui gère la connexion à la base de données SQLite et l'initialisation des tables.
     * Elle permet d'ouvrir une connexion à la base de données et de créer les tables si elles n'existent pas encore.
     * @return La connection à la base de données.
     */
    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(DB_URL);
    }

    /**
     * Méthode pour initialiser la base de données en créant les tables si elles n'existent pas.
     * Elle crée les tables nécessaires pour les entités : Train, Gare, Voyage, Passager, Billet, Employe.
     */
    public static void initializeDatabase() throws Exception {
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement()) {
            String createTrainTable = "CREATE TABLE IF NOT EXISTS Train ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "text_type TEXT NOT NULL, "
                    + "capacite INTEGER NOT NULL, "
                    + "enService BOOLEAN NOT NULL)";
            stmt.execute(createTrainTable);

            String createTrainGareTable = "CREATE TABLE IF NOT EXISTS TrainGare ("
                    + "gare_id INTEGER,"
                    + "train_id INTEGER,"
                    + "PRIMARY KEY (gare_id, train_id),"
                    + "FOREIGN KEY (gare_id) REFERENCES Gare(id),"
                    + "FOREIGN KEY (train_id) REFERENCES Train(id),";
            stmt.execute(createTrainGareTable);

            String createGareTable = "CREATE TABLE IF NOT EXISTS Gare ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "nom TEXT NOT NULL, "
                    + "adresse TEXT NOT NULL)";
            stmt.execute(createGareTable);

            String createVoyageTable = "CREATE TABLE IF NOT EXISTS Voyage ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "trainId TEXT NOT NULL, "
                    + "gareDepartId INTEGER NOT NULL, "
                    + "gareArriveeId INTEGER NOT NULL, "
                    + "horaire DATETIME NOT NULL, "
                    + "FOREIGN KEY(trainId) REFERENCES Train(id), "
                    + "FOREIGN KEY(gareDepartId) REFERENCES Gare(id), "
                    + "FOREIGN KEY(gareArriveeId) REFERENCES Gare(id))";
            stmt.execute(createVoyageTable);

            String createPassagerTable = "CREATE TABLE IF NOT EXISTS Passager ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "nom TEXT NOT NULL, "
                    + "prenom TEXT NOT NULL, "
                    + "email TEXT UNIQUE NOT NULL)";
            stmt.execute(createPassagerTable);

            String createBilletTable = "CREATE TABLE IF NOT EXISTS Billet ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "passagerId INTEGER NOT NULL, "
                    + "voyageId INTEGER NOT NULL, "
                    + "prix DECIMAL(10, 2) NOT NULL, "
                    + "FOREIGN KEY(passagerId) REFERENCES Passager(id), "
                    + "FOREIGN KEY(voyageId) REFERENCES Voyage(id))";
            stmt.execute(createBilletTable);

            String createEmployeTable = "CREATE TABLE IF NOT EXISTS Employe ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "nom TEXT NOT NULL, "
                    + "poste TEXT NOT NULL)";
            stmt.execute(createEmployeTable);

        }
    }
}

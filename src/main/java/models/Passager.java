package models;

import exceptions.EmailPassagerInvalidEception;

import java.util.ArrayList;
import java.util.List;

/**
 * La classe Passager représente un passager
 * Elle contient des informations sur
 * le nom, le prenom, le mail et la liste des historique de biller  du passager.
 */
public class Passager {
    /**
     * Le nom du passager.
     */
    private String nom;
    /**
     * Le prenom du passager.
     */
    public String prenom;
    /**
     * L'email du passager.
     */
    private String email;
    /**
     * L'historique des billets du passager.
     */
    private List<Billet> historiqueBillets;

    /**
     * Constructeur de la classe Passager.
     * Permet de créer un passager avec les informations spécifiées.
     *
     * @param nom Le nom du passager
     * @param prenom Le prenom du passager
     * @param email L'email du passager
     * @throws EmailPassagerInvalidEception Si le mail existe dèja.
     */
    public Passager(String nom, String prenom,  String email) throws EmailPassagerInvalidEception {
        //Todo condition mail unique
        if(true){
            throw new EmailPassagerInvalidEception("Le mail doit être unique");
        }
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.historiqueBillets = new ArrayList<>();
    }

    /**
     * @return Le nom du passager
     */
    public String getNom() {
        return nom;
    }

    /**
     * @return Le mail du passager
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return Le prenom du passager
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @return La liste de l'historique des billets du passager
     */
    public List<Billet> getHistoriqueBillets() {
        return historiqueBillets;
    }

    /**
     * Ajoute un billet à la liste de l'historique des billets.
     *
     * @param billet Le billet à ajouter.
     */
    public void ajouterBillet(Billet billet) {
        historiqueBillets.add(billet);
    }

    /**
     * Annule un billet dans la liste de l'historique des billets.
     *
     * @param billet Le billet à annuler.
     */
    public void annulerBillet(Billet billet) {
        //Todo
    }


    /**
     * @return Une chaîne de caractères représentant le billet.
     */
    @Override
    public String toString() {
        return "Passager{" +
                "nom='" + nom + '\'' + // Affiche le nom du passager
                ", email='" + email + '\'' + // Affiche l'e-mail du passager
                ", historiqueBillets=" + historiqueBillets + // Affiche la liste des billets réservés
                '}';
    }
}

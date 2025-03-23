package models;

/**
 * La classe Passager représente un passager
 * Elle contient des informations sur
 * le nom, le prenom, le mail et la liste des historique de biller  du passager.
 */
public class Passager {

    /**
     * Le identifiant du passager.
     */
    private String id;

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
     * Constructeur de la classe Passager.
     * Permet de créer un passager avec les informations spécifiées.
     * Constructeur à utilisée pour la création de Passager
     *
     * @param nom Le nom du passager
     * @param prenom Le prenom du passager
     * @param email L'email du passager
     */
    public Passager(String nom, String prenom,  String email)  {
        setNom(nom);
        setEmail(email);
        setPrenom(prenom);
    }

    /**
     * Constructeur de la classe Passager.
     * Permet de créer un passager avec les informations spécifiées.
     * Constructeur à utilisée pour la récupétion des Passager depuis la abse de données
     *
     * @param id Identifiant
     * @param nom Le nom du passager
     * @param prenom Le prenom du passager
     * @param email L'email du passager
     */
    public Passager(String id, String nom, String prenom,  String email)  {
        setId(id);
        setNom(nom);
        setPrenom(prenom);
        setEmail(email);
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
     * @return L'identifiant du passager
     */
    public String getId() {
        return id;
    }

    /**
     * Modifie le nom du passager
     * @param nom du passager
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Modifie le prenom du passager
     * @param prenom du passager
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Modifie l'email du passager
     * @param email du passager
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Modifie l'identifiant  du passager
     * @param id du passager
     */
    private void setId(String id) {
        this.id = id;
    }
}

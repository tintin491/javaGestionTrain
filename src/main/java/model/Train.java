package model;

import exceptions.CapaciteTrainInvalidException;

/**
 * La classe Train représente un train dans une gare.
 * Elle contient des informations sur l'identifiant du train,
 * son type, sa capacité et son statut de service.
 *
 * <p>Cette classe permet de gérer les trains, d'ajouter un train,
 * de vérifier sa capacité et de mettre le train hors service.</p>
 */
public class Train {

    /**
     * L'identifiant du train.
     */
    private String id;

    /**
     * Le type du train.
     */
    private String type;

    /**
     * La capacité maximale du train.
     */
    private int capacite;

    /**
     * Indique si le train est en service ou non.
     */
    private boolean enService;

    /**
     * Constructeur de la classe Train.
     * Permet de créer un train avec les informations spécifiées.
     *
     * @param id L'identifiant du train.
     * @param type Le type du train.
     * @param capacite La capacité du train.
     * @throws CapaciteTrainInvalidException Si la capacité est inférieure ou égale à zéro.
     */
    public Train(String id, String type, int capacite) throws CapaciteTrainInvalidException {
        if (capacite <= 0) {
            throw new CapaciteTrainInvalidException("La capacité doit être supérieure à zéro.");
        }
        this.id = id;
        this.type = type;
        this.capacite = capacite;
        this.enService = true;  // Le train est en service par défaut
    }

    /**
     * Constructeur de la classe Train.
     * Permet de créer un train avec les informations spécifiées.
     *
     * @param id L'identifiant du train.
     * @param type Le type du train.
     * @param capacite La capacité du train.
     * @param enService Indique si le train est en service ou non.
     * @throws CapaciteTrainInvalidException Si la capacité est inférieure ou égale à zéro.
     */
    public Train(String id, String type, int capacite, boolean enService) throws CapaciteTrainInvalidException {
        if (capacite <= 0) {
            throw new CapaciteTrainInvalidException("La capacité doit être supérieure à zéro.");
        }
        this.id = id;
        this.type = type;
        this.capacite = capacite;
        this.enService = enService;
    }

    /**
     * Retourne l'identifiant du train.
     *
     * @return L'identifiant du train.
     */
    public String getId() {
        return id;
    }

    /**
     * Retourne le type du train.
     *
     * @return Le type du train.
     */
    public String getType() {
        return type;
    }

    /**
     * Retourne la capacité du train.
     *
     * @return La capacité du train.
     */
    public int getCapacite() {
        return capacite;
    }

    /**
     * Vérifie si le train est actuellement en service.
     *
     * @return true si le train est en service, false sinon.
     */
    public boolean isEnService() {
        return enService;
    }

    /**
     * Met le train hors service.
     * Le train ne pourra plus être utilisé une fois qu'il est hors service.
     */
    public void mettreHorsService() {
        this.enService = false;
    }

    /**
     * Remet le train en service.
     * Le train peut être utilisé à nouveau après avoir été remis en service.
     */
    public void remettreEnService() {
        this.enService = true;
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères les informations train.
     *
     * @return Une chaîne de caractères représentant le train.
     */
    @Override
    public String toString() {
        return "Train{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", capacite=" + capacite +
                ", enService=" + enService +
                '}';
    }
}

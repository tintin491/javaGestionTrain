package models;

import exceptions.CapaciteTrainInvalidException;

/**
 * La classe Train représente un train dans une gare.
 * Elle contient des informations sur l'identifiant,
 * le type, la capacité et le statut de service du train.
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
     * @param id Identifiant du train
     * @param type Le type du train.
     * @param capacite La capacité du train.
     * @param enService Indique si le train est en service ou non.
     * @throws CapaciteTrainInvalidException Si la capacité est inférieure ou égale à zéro
     */
    public Train( String id, String type, int capacite, boolean enService)throws CapaciteTrainInvalidException {
        setId(id);
        setType(type);
        setCapacite(capacite);
        setEnService(enService);
    }

    /**
     * Constructeur de la classe Train.
     * Permet de créer un train avec les informations spécifiées.
     *
     * @param type Le type du train.
     * @param capacite La capacité du train.
     * @param enService Indique si le train est en service ou non.
     * @throws CapaciteTrainInvalidException Si la capacité est inférieure ou égale à zéro.
     */
    public Train(String type, int capacite, boolean enService) throws CapaciteTrainInvalidException {
        setType(type);
        setCapacite(capacite);
        setEnService(enService);
    }

    /**
     * @return L'identifiant du train.
     */
    public String getId() {
        return id;
    }

    /**
     * @return Le type du train.
     */
    public String getType() {
        return type;
    }

    /**
     * Modifie le type du train
     * @param type du train
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Modifie la capacite  du train
     * @param capacite du train
     */
    public void setCapacite(int capacite) throws CapaciteTrainInvalidException {
        if (capacite <= 0) {
            throw new CapaciteTrainInvalidException("La capacité doit être supérieure à zéro.");
        }
        this.capacite = capacite;
    }

    /**
     * @return La capacité du train.
     */
    public int getCapacite() {
        return capacite;
    }

    /**
     * @return true si le train est en service, false sinon.
     */
    public boolean isEnService() {
        return enService;
    }

    /**
     * Modifie le service du train.
     * @param enService Indique si le train est en service ou non.
     */
    public void setEnService(boolean enService) {
        this.enService = enService;
    }


    /**
     * Modifie la l'identifiant  du train
     * @param id du train
     */
    private void setId(String id) {
        this.id = id;
    }
}

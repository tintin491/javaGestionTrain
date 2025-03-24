package models;

import exceptions.VoyageHoraireException;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * La classe Voyage représente un voyage de train
 * Elle contient des informations sur l'identifiant ,
 * les horaire, , le passager et le prix  du billet.
 */
public class Voyage {

    /**
     * L'identifiant du billet.
     */
    private String id;

    /**
     * @return L'identifiant du voyage .
     */
    public String getId() {
        return id;
    }
}

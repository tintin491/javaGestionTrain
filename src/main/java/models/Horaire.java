package models;

import java.time.LocalDateTime;

public class Horaire {
    private Train train;
    private Gare gare;
    private LocalDateTime heure;

    public Horaire(Train train, Gare gare, LocalDateTime heure) {
        this.train = train;
        this.gare = gare;
        this.heure = heure;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Gare getGare() {
        return gare;
    }

    public void setGare(Gare gare) {
        this.gare = gare;
    }

    public LocalDateTime getHeure() {
        return heure;
    }

    public void setHeure(LocalDateTime heure) {
        this.heure = heure;
    }

    @Override
    public String toString() {
        return "Horaire{train=" + train.getId() + ", gare=" + gare.getNom() + ", heure=" + heure + "}";
    }
}

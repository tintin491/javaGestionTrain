package models;

import exceptions.VoyageHoraireException;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Voyage {
    Horaire horaireDepart;
    Horaire horaireArrivee;
    private ArrayList<Horaire> listeHoraire;

    public Voyage(Horaire horaireDepart, Horaire horaireArrivee, ArrayList<Horaire> listeHoraire) throws VoyageHoraireException {
        if(horaireDepart.getHeure().isBefore(horaireArrivee.getHeure()) | (horaireDepart.getTrain() != horaireArrivee.getTrain() && listeHoraire.isEmpty())){
            throw new VoyageHoraireException("Erreur dans les horaires de voyage");
        }
        this.horaireDepart = horaireDepart;
        this.horaireArrivee = horaireArrivee;
        this.listeHoraire = listeHoraire;
    }

    public Train getTrain() {
        return horaireDepart.getTrain();
    }

    public Gare getGareDepart() {
        return horaireDepart.getGare();
    }

    public Gare getGareArrivee() {
        return horaireArrivee.getGare();
    }

    public LocalDateTime getHeureDepart() {
        return horaireDepart.getHeure();
    }

    public LocalDateTime getHeureArrivee() {
        return horaireArrivee.getHeure();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Horaire{")
                .append("Train: ").append(horaireArrivee.getTrain().getId())
                .append(", de ").append(horaireDepart.getGare().getNom())
                .append(" à ").append(horaireArrivee.getGare().getNom())
                .append(", Départ: ").append(horaireDepart.getHeure())
                .append(", Arrivée: ").append(horaireArrivee.getHeure());

        if (listeHoraire != null && !listeHoraire.isEmpty()) {
            sb.append(", Gares intermédiaires: ");
            listeHoraire.forEach((horaire) -> sb.append(horaire.getGare())
                    .append(" à ")
                    .append(horaire.getHeure())
                    .append(", "));
            sb.setLength(sb.length() - 2);
        }


        sb.append("}");
        return sb.toString();
    }

    public boolean isValid() {
        return horaireDepart.getHeure().isBefore(horaireArrivee.getHeure());
    }
}

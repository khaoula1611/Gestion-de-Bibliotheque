package com.bibliotheque.empruntservice;

import com.bibliotheque.empruntservice.model.Emprunt;
import com.bibliotheque.empruntservice.model.enums.StatutEmprunt;
import com.bibliotheque.empruntservice.service.EmpruntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
@EnableFeignClients
public class EmpruntserviceApplication implements CommandLineRunner {

    @Autowired
    private EmpruntService empruntService;

    public static void main(String[] args) {
        SpringApplication.run(EmpruntserviceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Créer un emprunt
        //createEmprunt();

        // Modifier un emprunt
        //updateEmprunt();

        // Supprimer un emprunt
        //deleteEmprunt();
    }

    /*private void createEmprunt() {
        Emprunt emprunt = new Emprunt();

        // Assurez-vous que les IDs sont valides
        emprunt.setLivreId(2L); // ID du livre
        emprunt.setUtilisateurId(2L); // ID de l'utilisateur

        // Date d'emprunt et date de retour prévue
        LocalDateTime dateEmprunt = LocalDateTime.now(); // Utilisation de la date et heure actuelles
        LocalDateTime dateRetourPrevue = dateEmprunt.plusDays(15); // Date de retour prévue (15 jours après l'emprunt)
        LocalDateTime dateRetourEffective = dateRetourPrevue; // Initialiser avec une valeur par défaut

        emprunt.setDateEmprunt(dateEmprunt); // Assignation de la date d'emprunt
        emprunt.setDateRetourPrevue(dateRetourPrevue); // Assignation de la date de retour prévue
        emprunt.setDateRetourEffective(dateRetourEffective); // Assignation de la date de retour effective

        emprunt.setStatut(StatutEmprunt.EN_COURS); // Statut initial de l'emprunt

        // Sauvegarde de l'emprunt dans la base de données
        Emprunt savedEmprunt = empruntService.saveEmprunt(emprunt);

        // Affichage de l'emprunt sauvegardé pour vérification
        System.out.println("Emprunt créé : " + savedEmprunt);
    }

    private void updateEmprunt() {
        Long empruntId = 1L; // ID de l'emprunt existant

        // Récupération de l'emprunt existant depuis le service
        Emprunt emprunt = empruntService.findById(empruntId);
        if (emprunt == null) {
            System.out.println("Emprunt avec ID " + empruntId + " introuvable.");
            return;
        }

        // Mise à jour des champs nécessaires
        emprunt.setLivreId(2L); // Nouveau livre
        emprunt.setUtilisateurId(2L); // Utilisateur existant
        emprunt.setDateEmprunt(LocalDateTime.now()); // Nouvelle date d'emprunt
        emprunt.setDateRetourPrevue(LocalDateTime.now().plusDays(20)); // Nouvelle date de retour prévue

        // Mise à jour du statut de l'emprunt
        emprunt.setStatut(StatutEmprunt.RETOURNE); // Exemple : changer le statut à "TERMINÉ"

        // Mettre à jour l'emprunt dans la base de données
        Emprunt updatedEmprunt = empruntService.updateEmprunt(empruntId, emprunt);

        // Vérification et affichage du résultat
        if (updatedEmprunt != null) {
            System.out.println("Emprunt mis à jour : " + updatedEmprunt);
        } else {
            System.out.println("Échec de la mise à jour de l'emprunt avec ID " + empruntId);
        }
    }


    private void deleteEmprunt() {
        Long empruntId = 1L; // ID de l'emprunt à supprimer
        boolean isDeleted = empruntService.deleteEmprunt(empruntId);
        if (isDeleted) {
            System.out.println("Emprunt avec ID " + empruntId + " supprimé.");
        } else {
            System.out.println("Échec de la suppression de l'emprunt avec ID " + empruntId);
        }
    }*/
}

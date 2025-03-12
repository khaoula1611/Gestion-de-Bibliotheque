package com.bibliotheque.userservice;

import com.bibliotheque.userservice.Service.UtilisateurService;
import com.bibliotheque.userservice.model.Utilisateur;
import com.bibliotheque.userservice.model.enums.TypeUtilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UserserviceApplication implements CommandLineRunner {
    @Autowired
    private UtilisateurService utilisateurService;


    public static void main(String[] args) {
        SpringApplication.run(UserserviceApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        // Exemple d'ajout d'un utilisateur à la base de données
       // addUtilisateur();
        // Exemple de modification d'un utilisateur existant
        //updateUtilisateur(1L); // Remplacez 1L par l'ID réel de l'utilisateur
        //deleteUtilisateur(1L); // Remplacez 1L par l'ID réel de l'utilisateur à supprimer
    }
    /*private void addUtilisateur() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setMatricule("U12345");
        utilisateur.setNom("Dupont");
        utilisateur.setPrenom("Jean");
        utilisateur.setEmail("jean.dupont@example.com");
        utilisateur.setTelephone("0600000000");
        utilisateur.setType(TypeUtilisateur.ADMINISTRATEUR);

        utilisateurService.saveUtilisateur(utilisateur);
        System.out.println("Utilisateur ajouté avec succès : " + utilisateur);
    }*/
    /*private void updateUtilisateur(Long id) {
        // Rechercher l'utilisateur existant par ID
        Utilisateur utilisateur = utilisateurService.getUtilisateurById(id);

        if (utilisateur != null) {
            // Modifier les informations nécessaires
            utilisateur.setNom("Durand");
            utilisateur.setPrenom("Marie");
            utilisateur.setEmail("marie.durand@example.com");
            utilisateur.setTelephone("0700000000");
            utilisateur.setType(TypeUtilisateur.ADMINISTRATEUR);

            // Sauvegarder les modifications dans la base de données
            utilisateurService.saveUtilisateur(utilisateur);
            System.out.println("Utilisateur mis à jour avec succès : " + utilisateur);
        } else {
            System.out.println("Utilisateur avec l'ID " + id + " n'existe pas.");
        }*/
        /*private void deleteUtilisateur(Long id) {
            // Vérifier si l'utilisateur existe avant de le supprimer
            Utilisateur utilisateur = utilisateurService.getUtilisateurById(id);

            if (utilisateur != null) {
                // Supprimer l'utilisateur de la base de données
                utilisateurService.deleteUtilisateur(id);
                System.out.println("Utilisateur supprimé avec succès : " + utilisateur);
            } else {
                System.out.println("Utilisateur avec l'ID " + id + " n'existe pas.");
            }
        }*/

    }


package com.bibliotheque.livreservice;

import com.bibliotheque.livreservice.model.Livre;
import com.bibliotheque.livreservice.Repository.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LivreserviceApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(LivreserviceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Exemple de création de livre
        //createLivre();

        // Exemple de modification de livre
        //updateLivre(1L);  // Utiliser un ID existant pour mettre à jour un livre

        // Exemple de suppression de livre
        //deleteLivre(1L);  // Utiliser un ID existant pour supprimer un livre
    }

    /*private void createLivre() {
        Livre livre = new Livre();
        livre.setIsbn("978-1234567898");
        livre.setTitre("Spring Boot pour les débutants");
        livre.setAuteur("Jean Dupont");
        livre.setEdition("Editeur A");
        livre.setAnneePublication(2020);
        livre.setCategorie("Technologie");
        livre.setNombreExemplaires(10);
        livre.setEmplacement("Rayon 1");

        // Sauvegarde du livre dans la base de données
        livreRepository.save(livre);
        System.out.println("Livre ajouté avec succès : " + livre);
    }*/

    /*private void updateLivre(Long id) {
        // Recherche d'un livre existant par son ID
        Livre livre = livreRepository.findById(id).orElse(null);

        if (livre != null) {
            // Modification des informations du livre
            livre.setTitre("Spring Boot pour les experts");
            livre.setAuteur("Jean Dupont modifié");
            livre.setAnneePublication(2021);
            livre.setCategorie("Technologie avancée");
            livre.setNombreExemplaires(15);
            livre.setEmplacement("Rayon 2");

            // Sauvegarde du livre mis à jour dans la base de données
            livreRepository.save(livre);
            System.out.println("Livre mis à jour avec succès : " + livre);
        } else {
            System.out.println("Livre avec l'ID " + id + " non trouvé.");
        }
    }*/

    /*private void deleteLivre(Long id) {
        // Vérification si le livre existe avant de le supprimer
        if (livreRepository.existsById(id)) {
            livreRepository.deleteById(id);
            System.out.println("Livre supprimé avec succès, ID : " + id);
        } else {
            System.out.println("Livre avec l'ID " + id + " non trouvé.");
        }
    }*/
}

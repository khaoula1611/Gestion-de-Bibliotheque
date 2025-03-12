package com.bibliotheque.empruntservice.service;

import com.bibliotheque.empruntservice.client.LivreClient;
import com.bibliotheque.empruntservice.client.UtilisateurClient;
import com.bibliotheque.empruntservice.model.Emprunt;
import com.bibliotheque.empruntservice.Repository.EmpruntRepository;
import com.bibliotheque.empruntservice.model.Livre;
import com.bibliotheque.empruntservice.model.Utilisateur;
import com.bibliotheque.empruntservice.model.enums.StatutEmprunt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EmpruntService {

    @Autowired
    private EmpruntRepository empruntRepository;

    @Autowired
    private LivreClient livreClient;

    @Autowired
    private UtilisateurClient utilisateurClient;


    public Emprunt findById(Long id) {
        Optional<Emprunt> empruntOptional = empruntRepository.findById(id);
        return empruntOptional.orElse(null);
    }
    public Emprunt saveEmprunt(Emprunt emprunt) {


        Livre livre = livreClient.getLivreById(emprunt.getLivreId());
        Utilisateur utilisateur =utilisateurClient.getUtilisateurById(emprunt.getUtilisateurId());

        if (livre.getNombreExemplaires() <= 0) {
            throw new IllegalStateException("Aucun exemplaire disponible pour ce livre.");
        }
        livre.setNombreExemplaires(livre.getNombreExemplaires() - 1);
        emprunt.setLivre(livre);
        emprunt.setUtilisateur(utilisateur);
        livreClient.saveLivre(livre);
        return empruntRepository.save(emprunt);
    }

    public Emprunt updateEmprunt(Long id, Emprunt emprunt) {
        if (empruntRepository.existsById(id)) {
            return empruntRepository.save(emprunt);
        }
        return null; // ou une exception si nécessaire
    }

    public Emprunt getEmpruntById(Long id) {
        Optional<Emprunt> emprunt = empruntRepository.findById(id);
        return emprunt.orElse(null); // retourne null ou une exception si l'emprunt n'existe pas
    }

    public List<Emprunt> getAllEmprunts() {
        List<Emprunt> emprunts = empruntRepository.findAll();
        for (Emprunt emprunt : emprunts) {
            // Récupérer l'utilisateur par son ID
            Utilisateur utilisateur = utilisateurClient.getUtilisateurById(emprunt.getUtilisateurId());
            emprunt.setUtilisateur(utilisateur);

            // Récupérer le livre par son ID
            Livre livre = livreClient.getLivreById(emprunt.getLivreId());
            emprunt.setLivre(livre);
        }
        return emprunts;
    }

    public boolean deleteEmprunt(Long id) {
        if (empruntRepository.existsById(id)) {
            empruntRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public void deleteEmpruntsByLivreId(Long livreId) {
        empruntRepository.deleteByLivreId(livreId);
    }
    public Livre getLivreDetails(Long livreId) {
        return livreClient.getLivreById(livreId);
    }

    public Utilisateur getUtilisateurDetails(Long utilisateurId) {
        return utilisateurClient.getUtilisateurById(utilisateurId);
    }
}

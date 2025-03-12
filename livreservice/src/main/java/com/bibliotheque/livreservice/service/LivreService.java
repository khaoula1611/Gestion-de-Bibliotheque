package com.bibliotheque.livreservice.service;

import com.bibliotheque.livreservice.model.Livre;
import com.bibliotheque.livreservice.Repository.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivreService {

    private final LivreRepository livreRepository;

    @Autowired
    public LivreService(LivreRepository livreRepository) {
        this.livreRepository = livreRepository;
    }

    public Livre saveLivre(Livre livre) {
        return livreRepository.save(livre);
    }

    public Livre updateLivre(Long id, Livre livre) {
        Optional<Livre> livreOptional = livreRepository.findById(id);
        if (livreOptional.isPresent()) {
            return livreRepository.save(livre); // La méthode save() gère l'ID
        }
        return null; // Retourne null si le livre n'existe pas
    }


    public Livre getLivreById(Long id) {
        Optional<Livre> livre = livreRepository.findById(id);
        return livre.orElse(null);
    }

    public Livre getLivreByIsbn(String isbn) {
        return livreRepository.findByIsbn(isbn);
    }

    public List<Livre> getAllLivres() {
        List<Livre> livres = livreRepository.findAll();
        if (livres.isEmpty()) {
            return null;
        }
        return livreRepository.findAll();
    }

    public boolean deleteLivre(Long id) {
        if (livreRepository.existsById(id)) {
            livreRepository.deleteById(id);
            return true;
        }
        return false;
    }


}

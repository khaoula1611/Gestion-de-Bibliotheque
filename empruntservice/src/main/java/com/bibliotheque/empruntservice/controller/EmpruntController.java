package com.bibliotheque.empruntservice.controller;

import com.bibliotheque.empruntservice.model.Emprunt;
import com.bibliotheque.empruntservice.model.Livre;
import com.bibliotheque.empruntservice.model.Utilisateur;
import com.bibliotheque.empruntservice.model.enums.StatutEmprunt;
import com.bibliotheque.empruntservice.service.EmpruntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/emprunts")
public class EmpruntController {

    @Autowired
    private  EmpruntService empruntService;

    @PostMapping
    public Emprunt creerEmprunt( @RequestBody Emprunt emprunt) {
        emprunt.setStatut(StatutEmprunt.EN_COURS);
        return empruntService.saveEmprunt(emprunt);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Emprunt> updateEmprunt(@PathVariable Long id, @RequestBody Emprunt emprunt) {
        Emprunt updatedEmprunt = empruntService.updateEmprunt(id, emprunt);
        if (updatedEmprunt == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedEmprunt, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Emprunt> getEmprunt(@PathVariable Long id) {
        Emprunt emprunt = empruntService.getEmpruntById(id);
        if (emprunt == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(emprunt, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Emprunt>> getAllEmprunts() {
        List<Emprunt> emprunts = empruntService.getAllEmprunts();
        return new ResponseEntity<>(emprunts, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmprunt(@PathVariable Long id) {
        boolean isDeleted = empruntService.deleteEmprunt(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/livre/{id}")
    public Livre getLivre(@PathVariable Long id) {
        return empruntService.getLivreDetails(id);
}

    @GetMapping("/utilisateur/{id}")
    public Utilisateur getUtilisateur(@PathVariable Long id) {
        // Appeler la méthode dans EmpruntService pour récupérer un utilisateur
        return empruntService.getUtilisateurDetails(id);
    }

    @DeleteMapping("/byLivre/{idLivre}")
    public ResponseEntity<?> deleteEmpruntsByLivre(@PathVariable Long idLivre) {
        empruntService.deleteEmpruntsByLivreId(idLivre);
        return ResponseEntity.ok("Tous les emprunts associés au livre ont été supprimés.");
    }
}

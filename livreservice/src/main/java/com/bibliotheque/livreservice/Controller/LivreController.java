package com.bibliotheque.livreservice.Controller;

import com.bibliotheque.livreservice.model.Livre;
import com.bibliotheque.livreservice.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/livres")
public class LivreController {

    private final LivreService livreService;

    @Autowired
    public LivreController(LivreService livreService) {
        this.livreService = livreService;
    }

    @PostMapping
    public ResponseEntity<Livre> createLivre(@RequestBody Livre livre) {
        Livre newLivre = livreService.saveLivre(livre);
        return new ResponseEntity<>(newLivre, HttpStatus.CREATED);
    }



    @GetMapping("/{id}")
    public ResponseEntity<Livre> getLivreById(@PathVariable Long id) {
        Livre livre = livreService.getLivreById(id);
        return livre != null ? new ResponseEntity<>(livre, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<Livre> getLivreByIsbn(@PathVariable String isbn) {
        Livre livre = livreService.getLivreByIsbn(isbn);
        return livre != null ? new ResponseEntity<>(livre, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public List<Livre> getAllLivres() {
        return livreService.getAllLivres();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLivre(@PathVariable Long id) {
        boolean deleted = livreService.deleteLivre(id);
        return deleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Livre> updateLivre( @PathVariable("id") Long id,@RequestBody Livre livre) {
        Livre updatedLivre = livreService.updateLivre(id, livre);
        if (updatedLivre != null) {
            return new ResponseEntity<>(updatedLivre, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(updatedLivre, HttpStatus.NOT_FOUND);}
    }
    @PutMapping("/save")
    public Livre saveLivre(@RequestBody Livre livre) {
        return  livreService.saveLivre(livre);

    }
    @GetMapping("/disponibles")
    public List<Livre> getLivresDisponibles() {
        return livreService.getAllLivres()
                .stream()
                .filter(livre -> livre.getNombreExemplaires() > 0)
                .collect(Collectors.toList());
    }
}

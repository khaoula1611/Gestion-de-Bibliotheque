package com.bibliotheque.userservice.Controller;

import com.bibliotheque.userservice.Service.UtilisateurService;
import com.bibliotheque.userservice.model.Utilisateur;

import com.bibliotheque.userservice.model.enums.TypeUtilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurService.getAllUtilisateurs();
    }

    @GetMapping("/etudiants")
    public List<Utilisateur> getAllEtudiantrs() {
        return utilisateurService.getAllEtudiant();
    }

    @GetMapping("/{id}")
    public Utilisateur getUtilisateurById(@PathVariable Long id) {
        return utilisateurService.getUtilisateurById(id);
    }

    @PostMapping
    public Utilisateur saveUtilisateur(@RequestBody Utilisateur utilisateur) {
        return utilisateurService.saveUtilisateur(utilisateur);
    }
    @PostMapping("saveEtudiant")
    public Utilisateur saveEtudiant(@RequestBody Utilisateur utilisateur) {
        return utilisateurService.saveEtudiant(utilisateur);
    }

    @DeleteMapping("/{id}")
    public void deleteUtilisateur(@PathVariable Long id) {
        utilisateurService.deleteUtilisateur(id);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");

        Optional<Utilisateur> utilisateurOpt = utilisateurService.authenticate(email, password);

        if (utilisateurOpt.isPresent()) {
            Utilisateur utilisateur = utilisateurOpt.get();
            if ("ADMINISTRATEUR".equals(utilisateur.getType().toString())) {
                return ResponseEntity.ok().body(Map.of("message", "Login successful"));
            } else {
                return ResponseEntity.status(403).body(Map.of("error", "Access denied: Only administrators are allowed to login"));
            }
        } else {
            return ResponseEntity.status(401).body(Map.of("error", "Invalid email or password"));
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Utilisateur> updateEtudiant(@PathVariable("id") Long id, @RequestBody Utilisateur updatedEtudiant) {
        Utilisateur etudiant = utilisateurService.updateEtudiant(id, updatedEtudiant);
        if (etudiant != null) {
            return new ResponseEntity<>(etudiant, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // If Etudiant not found
        }
    }


    @GetMapping("/type/{type}")
    public List<Utilisateur> getUtilisateursByType(@PathVariable TypeUtilisateur type) {
        return utilisateurService.getUtilisateursByType(type);
    }
}

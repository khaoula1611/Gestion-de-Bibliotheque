package com.bibliotheque.userservice.Service;

import com.bibliotheque.userservice.Repository.UtilisateurRepository;
import com.bibliotheque.userservice.model.Utilisateur;

import com.bibliotheque.userservice.model.enums.TypeUtilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }
    public List<Utilisateur> getAllEtudiant() {
        return utilisateurRepository.findByType(TypeUtilisateur.STUDENT);
    }

    public List<Utilisateur> getUtilisateursByType(TypeUtilisateur type) {
        return utilisateurRepository.findByType(type);
    }

    public Utilisateur getUtilisateurById(Long id) {
        return utilisateurRepository.findById(id).orElse(null);
    }

    public Utilisateur saveUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    public Utilisateur saveEtudiant(Utilisateur utilisateur) {
        utilisateur.setTypeUtilisateur(TypeUtilisateur.STUDENT);
        return utilisateurRepository.save(utilisateur);
    }
    public Utilisateur updateEtudiant(Long id, Utilisateur updatedEtudiant) {
        // Check if Etudiant with the given id exists
        Optional<Utilisateur> existingEtudiant = utilisateurRepository.findById(id);
        if (existingEtudiant.isPresent()) {
            Utilisateur etudiant = existingEtudiant.get();
            // Update fields
            etudiant.setMatricule(updatedEtudiant.getMatricule());
            etudiant.setNom(updatedEtudiant.getNom());
            etudiant.setPrenom(updatedEtudiant.getPrenom());
            etudiant.setEmail(updatedEtudiant.getEmail());
            etudiant.setTelephone(updatedEtudiant.getTelephone());
            // Save updated Etudiant to the database
            return utilisateurRepository.save(etudiant);
        }
        return null; // Return null if Etudiant not found
    }

    public void deleteUtilisateur(Long id) {
        utilisateurRepository.deleteById(id);
    }

    public Optional<Utilisateur> authenticate(String email, String password) {
        return utilisateurRepository.findByEmail(email)
                .filter(utilisateur -> utilisateur.getPassword().equals(password));
    }




}

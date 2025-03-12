package com.bibliotheque.userservice.Repository;

import com.bibliotheque.userservice.model.Utilisateur;
import com.bibliotheque.userservice.model.enums.TypeUtilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    // Ajoutez des méthodes personnalisées si nécessaire
    Optional<Utilisateur> findByEmail(String email);
    List<Utilisateur> findByType(TypeUtilisateur type);
}

package com.bibliotheque.empruntservice.Repository;

import com.bibliotheque.empruntservice.model.Emprunt;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpruntRepository extends JpaRepository<Emprunt, Long> {
    // Vous pouvez ajouter des méthodes personnalisées si nécessaire
    // Exemple : Optional<Emprunt> findByUtilisateurId(Long utilisateurId);
//    @Transactional
//    @Modifying
    void deleteByLivreId(Long livreId);
}

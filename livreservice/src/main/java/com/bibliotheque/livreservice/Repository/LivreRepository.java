package com.bibliotheque.livreservice.Repository;

import com.bibliotheque.livreservice.model.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivreRepository extends JpaRepository<Livre, Long> {
    Livre findByIsbn(String isbn);
}

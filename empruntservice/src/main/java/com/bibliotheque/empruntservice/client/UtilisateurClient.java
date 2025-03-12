package com.bibliotheque.empruntservice.client;

import com.bibliotheque.empruntservice.model.Utilisateur;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "userservice", url = "http://localhost:8080") // L'URL de votre microservice Utilisateur
public interface UtilisateurClient {

    @GetMapping("/api/utilisateurs/{id}")
    Utilisateur getUtilisateurById(@PathVariable("id") Long id);
}

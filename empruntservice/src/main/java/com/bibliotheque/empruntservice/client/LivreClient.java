package com.bibliotheque.empruntservice.client;

import com.bibliotheque.empruntservice.model.Livre;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "livreservice", url = "http://localhost:8081/api/livres") // L'URL de votre microservice Livre
public interface LivreClient {

    @GetMapping("/{id}")
    Livre getLivreById(@PathVariable("id") Long id);

    @PutMapping("/{id}")
    Livre updateLivre(@PathVariable("id") Long id, @RequestBody Livre livre);

    @PutMapping("/save")
    Livre saveLivre(@RequestBody Livre livre);
}

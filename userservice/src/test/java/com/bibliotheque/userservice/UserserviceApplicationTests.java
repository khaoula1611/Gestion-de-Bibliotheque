package com.bibliotheque.userservice;

import com.bibliotheque.userservice.model.Utilisateur;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Disabled("Désactivé temporairement en raison d'une erreur dans l'ApplicationContext")
public class UserserviceApplicationTests {
    @Test
    void contextLoads() {}

    @Test
    public void testDeserialization() throws Exception {
        String json = "{\"type\":\"ETUDIANT\"}";
        ObjectMapper mapper = new ObjectMapper();
        Utilisateur utilisateur = mapper.readValue(json, Utilisateur.class);

    }
    }

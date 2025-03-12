package com.bibliotheque.userservice.config;

import com.bibliotheque.userservice.model.enums.TypeUtilisateur;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class TypeUtilisateurDeserializer extends JsonDeserializer<TypeUtilisateur> {

    @Override
    public TypeUtilisateur deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String value = p.getText();
        try {
            return TypeUtilisateur.valueOf(value);
        } catch (IllegalArgumentException e) {
            // Si la valeur est inconnue, retourner la valeur par défaut
            return TypeUtilisateur.INCONNU;
        }
    }
}
package com.bibliotheque.userservice.model.enums;

import com.bibliotheque.userservice.config.TypeUtilisateurDeserializer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
public enum TypeUtilisateur {

    STUDENT,
    ADMINISTRATEUR,

    @JsonDeserialize(using = TypeUtilisateurDeserializer.class)
    INCONNU;
}

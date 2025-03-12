package com.bibliotheque.empruntservice.model;


import com.bibliotheque.empruntservice.model.enums.TypeUtilisateur;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Utilisateur {


    private Long id;
    private String matricule;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;

    @Enumerated(EnumType.STRING)
    private TypeUtilisateur type;

//    @OneToMany(mappedBy = "utilisateur")
//    private List<Emprunt> emprunts;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getMatricule() { return matricule; }
    public void setMatricule(String matricule) { this.matricule = matricule; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }
    public TypeUtilisateur getType() { return type; }
    public void setType(TypeUtilisateur type) { this.type = type; }

}

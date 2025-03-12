package com.bibliotheque.userservice.model;

import com.bibliotheque.userservice.model.enums.TypeUtilisateur;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String matricule;

    @NotNull
    private String nom;

    @NotNull
    private String prenom;


    @Email
    @Column(unique = true, nullable = false)
    private String email;

    private String telephone;

    private String password;

    @Enumerated(EnumType.STRING)
    private TypeUtilisateur type;


    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getMatricule(){
        return matricule;
    }
    public void setMatricule(String matricule){
        this.matricule = matricule;
    }
    public String getNom(){
        return nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public String getPrenom(){
        return prenom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getTelephone(){
        return telephone;
    }
    public void setTelephone(String telephone){
        this.telephone = telephone;
    }


    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public TypeUtilisateur getType(){
        return type;
    }
    public void setTypeUtilisateur(TypeUtilisateur type) {
        this.type = type;
    }
//    @OneToMany(mappedBy = "utilisateur")
//    private List<Emprunt> emprunts;

}

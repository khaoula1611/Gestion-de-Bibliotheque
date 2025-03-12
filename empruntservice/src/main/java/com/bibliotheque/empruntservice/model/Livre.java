package com.bibliotheque.empruntservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class Livre {

    private Long id;
    private String isbn;
    private String titre;
    private String auteur;
    private String edition;
    private Integer anneePublication;
    private String categorie;
    private Integer nombreExemplaires;
    private String emplacement;

//    @OneToMany(mappedBy = "livre")
//    private List<Emprunt> emprunts;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNombreExemplaires() {
        return nombreExemplaires;
    }
    public void setNombreExemplaires(Integer nombreExemplaires) {
        this.nombreExemplaires = nombreExemplaires;
    }
    public String getEmplacement() {
        return emplacement;
    }
    public void setEmplacement(String emplacement) { this.emplacement = emplacement; }
    public String getCategorie() { return categorie; }
    public void setCategorie(String categorie) { this.categorie = categorie; }
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }
    public String getAuteur() { return auteur; }
    public void setAuteur(String auteur) { this.auteur = auteur; }
    public String getEdition() { return edition; }
    public void setEdition(String edition) { this.edition = edition; }



}

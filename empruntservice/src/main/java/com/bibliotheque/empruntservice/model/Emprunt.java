package com.bibliotheque.empruntservice.model;

import com.bibliotheque.empruntservice.model.enums.StatutEmprunt;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emprunt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull
    private LocalDateTime dateEmprunt;
    private LocalDateTime dateRetour;

    @Enumerated(EnumType.STRING)
    private StatutEmprunt statut;

    @Column(name = "livre_id", nullable = false)
    private Long livreId;

    @Column(name = "utilisateur_id", nullable = false)
    private Long utilisateurId;

    @Transient
    private Utilisateur utilisateur;

    @Transient
    private Livre livre;

    @PrePersist
    private void prePersist() {
        // Définir automatiquement la date d'emprunt
        this.dateEmprunt = LocalDateTime.now();

        this.dateRetour = this.dateEmprunt.plusDays(14);

    }
    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public LocalDateTime getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(LocalDateTime dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public LocalDateTime getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(LocalDateTime dateRetourPrevue) {
        this.dateRetour = dateRetourPrevue;
    }



    public StatutEmprunt getStatut() {
        return statut;
    }

    public void setStatut(StatutEmprunt statut) {
        this.statut = statut;
    }

    public Long getLivreId() {
        return livreId;
    }
    public void setLivreId(Long livreId) {
        this.livreId = livreId;
    }
    public Long getUtilisateurId() { return utilisateurId; }
    public void setUtilisateurId(Long utilisateurId) { this.utilisateurId = utilisateurId; }
public Utilisateur getUtilisateur() { return utilisateur; }
    public void setUtilisateur(Utilisateur utilisateur) { this.utilisateur = utilisateur; }
    public Livre getLivre() { return livre; }
    public void setLivre(Livre livre) { this.livre = livre; }
//    @ManyToOne
//    @JoinColumn(name = "livre_id")
//    private Livre livre;
//
//    @ManyToOne
//    @JoinColumn(name = "utilisateur_id")
//    private Utilisateur utilisateur;
//
//    public Livre getLivre() {
//        return livre;
//    }
//
//    public void setLivre(Livre livre) {
//        this.livre = livre;
//    }
//
//    public Utilisateur getUtilisateur() {
//        return utilisateur;
//    }
//
//    public void setUtilisateur(Utilisateur utilisateur) {
//        this.utilisateur = utilisateur;
//    }
//
//    // Getters personnalisés pour les IDs des entités liées
//    public Long getLivreId() {
//        return livre != null ? livre.getId() : null;
//    }
//
//    public void setLivreId(Long livreId) {
//        if (this.livre == null) {
//            this.livre = new Livre();
//        }
//        this.livre.setId(livreId);
//    }
//
//    public Long getUtilisateurId() {
//        return utilisateur != null ? utilisateur.getId() : null;
//    }
//
//    public void setUtilisateurId(Long utilisateurId) {
//        if (this.utilisateur == null) {
//            this.utilisateur = new Utilisateur();
//        }
//        this.utilisateur.setId(utilisateurId);
//    }
}

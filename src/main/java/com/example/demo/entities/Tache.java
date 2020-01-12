package com.example.demo.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
public class Tache implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private Date delai;
    private String Statut;



    @ManyToOne
    private Phase phase;

    @ManyToOne
    private Personnel collaborateur;

    public Tache() {
    }

    public Tache(String nom, Date delai, Phase phase, Personnel collaborateur) {
        this.nom = nom;
        this.delai = delai;
        this.phase = phase;
        this.collaborateur = collaborateur;
    }

    public Tache(String nom, Date delai, Phase phase) {
        this.nom = nom;
        this.delai = delai;
        this.phase = phase;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDelai() {
        return delai;
    }

    public void setDelai(Date delai) {
        this.delai = delai;
    }

    public String getStatut() {
        return Statut;
    }

    public void setStatut(String statut) {
        Statut = statut;
    }

    public Phase getPhase() {
        return phase;
    }

    public void setPhase(Phase phase) {
        this.phase = phase;
    }

    public Personnel getCollaborateur() {
        return collaborateur;
    }

    public void setCollaborateur(Personnel collaborateur) {
        this.collaborateur = collaborateur;
    }
}

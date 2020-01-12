package com.example.demo.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
public class Phase implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private Date delai;
    private String Statut;

    @ManyToOne
    private Projet projet;



    public Phase() {
    }

    public Phase(String nom, Date delai, String statut, Projet projet) {
        this.nom = nom;
        this.delai = delai;
        Statut = statut;
        this.projet = projet;
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

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }


}

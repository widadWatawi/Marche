package com.example.demo.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
public class Projet  implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private Date date;
    private Integer duree;
    private String statut;

    @ManyToOne
    private Personnel chef;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "projet")
    private List<Phase> phases;



    public Projet() {
    }

    public Projet(String nom, Integer duree, String statut) {
        this.nom = nom;
        this.duree = duree;
        this.statut = statut;
    }

    public Projet(String nom, Date date, Integer duree, String statut) {
        this.nom = nom;
        this.date = date;
        this.duree = duree;
        this.statut = statut;
    }

    public Projet(String nom, Date date, Integer duree, String statut, Personnel chef) {
        this.nom = nom;
        this.date = date;
        this.duree = duree;
        this.statut = statut;
        this.chef = chef;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Personnel getChef() {
        return chef;
    }

    public void setChef(Personnel chef) {
        this.chef = chef;
    }



}

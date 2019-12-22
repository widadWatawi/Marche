package com.example.demo.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Service implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String nom;

    @OneToMany(mappedBy="service")
    private Collection<Personnel> personnels ;

    @OneToOne
    private Personnel chef;

    public Service() {
    }

    public Service(String nom) {
        this.nom = nom;
    }

    public Service(String nom, Personnel chef) {
        this.nom = nom;
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

    public Collection<Personnel> getPersonnels() {
        return personnels;
    }

    public void setPersonnels(Collection<Personnel> personnels) {
        this.personnels = personnels;
    }
}

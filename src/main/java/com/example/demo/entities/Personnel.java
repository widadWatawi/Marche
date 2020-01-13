package com.example.demo.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
public class Personnel implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String login;
    private String password;
    private String nom;
    private String prenom;
    private String sexe;
    private String cin;
    private String adresse;
    private String email;
    private String tel;
    private String situation;
    private Date date;
    private Integer age;
    private Integer salaire;

    @ManyToOne
    private Fonction fonction;

    @ManyToOne
    private Service service;



    public Personnel() {
    }

    public Personnel(String login, String password, String nom, String prenom, String sexe, String cin, String adresse, String email, String tel, String situation, Date date, Integer age, Integer salaire) {
        this.login = login;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.cin = cin;
        this.adresse = adresse;
        this.email = email;
        this.tel = tel;
        this.situation = situation;
        this.date = date;
        this.age = age;
        this.salaire = salaire;
    }

    public Personnel(String login, String password, String nom, String prenom, String sexe, String cin, String adresse, String email, String tel, String situation, Date date, Integer age, Integer salaire, Fonction fonction, Service service) {
        this.login = login;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.cin = cin;
        this.adresse = adresse;
        this.email = email;
        this.tel = tel;
        this.situation = situation;
        this.date = date;
        this.age = age;
        this.salaire = salaire;
        this.fonction = fonction;
        this.service = service;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSalaire() {
        return salaire;
    }

    public void setSalaire(Integer salaire) {
        this.salaire = salaire;
    }

    public Fonction getFonction() {
        return fonction;
    }

    public void setFonction(Fonction fonction) {
        this.fonction = fonction;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }


}

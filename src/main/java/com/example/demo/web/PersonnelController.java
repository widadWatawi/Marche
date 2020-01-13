package com.example.demo.web;


import com.example.demo.Repository.PersonnelRepository;
import com.example.demo.Repository.ProjetRepository;
import com.example.demo.Repository.TacheRepository;
import com.example.demo.entities.Personnel;
import com.example.demo.entities.Projet;
import com.example.demo.entities.Tache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personnel")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class PersonnelController {

    @Autowired
    private PersonnelRepository personnelRepository;

    @Autowired
    private ProjetRepository projetRepository;

    @Autowired
    private TacheRepository tacheRepository;

    @GetMapping("/personnels")
    public List<Personnel> getAllPersonnels() {
        return personnelRepository.findAll();
    }

    @GetMapping("/chefs")
    public List<Personnel>getChefs(){
        return personnelRepository.getFonction((long)1);

    }

    @GetMapping("/employees")
    public List<Personnel>getEmployees(){
        return personnelRepository.getFonction((long)2);

    }

    @GetMapping("/affecterProjet/{id_projet}/{id}")
    public List<Personnel> AffecterChef(@PathVariable Long id,@PathVariable Long id_projet ){
        Projet projet = projetRepository.getById(id_projet);
        Personnel personnel = personnelRepository.getById(id);
        projet.setChef(personnel);
        projetRepository.save(projet);
        return personnelRepository.getFonction((long)1);
    }

    @GetMapping("/affecterTache/{id_tache}/{id}")
    public List<Personnel> AffecterEmplyees(@PathVariable Long id,@PathVariable Long id_tache ){
        Tache tache = tacheRepository.getById(id_tache);
        Personnel personnel = personnelRepository.getById(id);
        tache.setCollaborateur(personnel);
        tacheRepository.save(tache);
        return personnelRepository.getFonction((long)2);
    }


    @GetMapping("/{login}/{pwd}")
    public Boolean LoginPersonnels(@PathVariable String login, @PathVariable String pwd)
    {
        Personnel u = personnelRepository.findByLogin(login);
        if (u.getPassword().equals(pwd)) { return true;}
        else {return false;}
    }

    @PostMapping("/login")
    public String register(@RequestBody Personnel personnel ){
        Personnel user= personnelRepository.findByLogin(personnel.getLogin());
        if(personnel.getPassword().equals(user.getPassword())){
            return "Success";
        }
        return "saved successfullly";
    }



}

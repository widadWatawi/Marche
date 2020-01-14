package com.example.demo.web;


import com.example.demo.Repository.PersonnelRepository;
import com.example.demo.Repository.PhaseRepository;
import com.example.demo.Repository.ProjetRepository;
import com.example.demo.Repository.TacheRepository;
import com.example.demo.entities.Personnel;
import com.example.demo.entities.Phase;
import com.example.demo.entities.Projet;
import com.example.demo.entities.Tache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class ProjetController {

    @Autowired
    private ProjetRepository projetRepository;

    @Autowired
    private PersonnelRepository personnelRepository;

    @Autowired
    private TacheRepository tacheRepository;

    @Autowired
    private PhaseRepository phaseRepository;


    @PostMapping("/register")
    public String register(@RequestBody Projet projet){
        projetRepository.save(projet);
        return "saved successfullly";
    }

    @PutMapping("/projets/update")
    public String updateProject(@RequestBody Projet projet){
        projetRepository.save(projet);
        return "edited";
    }

    @GetMapping("/projets")
    public List<Projet> getProjects(){

        return projetRepository.findAll();
    }

    @GetMapping("/projets/{id}")
    public Optional<Projet> findById(@PathVariable Long id){
        return projetRepository.findById(id);

    }

    @GetMapping("/chef/projets/{login}")
    public List<Projet> getByChef(@PathVariable String login){
        Personnel personnel = personnelRepository.findByLogin(login);
        return projetRepository.getByChef(personnel.getId());

    }

    @GetMapping("/employee/projets/{login}")
    public List<Projet> getByChefEmployee(@PathVariable String login){
        Personnel personnel = personnelRepository.findByLogin(login);
        Long id = personnel.getId();
        List<Tache> taches= tacheRepository.getByEmployee(id);
        List<Projet> projets= new ArrayList<>() ;
        for(int i=0;i<taches.size();i++){
           Phase phase = phaseRepository.getById(taches.get(i).getPhase().getId());
           Projet projet = projetRepository.getById(phase.getProjet().getId());
           projets.add(projet);
        }
        return projets;

    }



    @GetMapping("/projets/search/{name}")
    public List<Projet> findByName(@PathVariable String name){
        return projetRepository.getByNom(name);

    }


    @GetMapping("/projets/{id}/phase")
    public List<Phase> getPhase(@PathVariable Long id){
        return projetRepository.getPhase(id);

    }

    @GetMapping("/cancel/{id}")
    public List<Projet> deleteProjet(@PathVariable Long id){
        projetRepository.deleteById(id);
        return projetRepository.findAll();
    }


    @GetMapping("/valider/{id}")
    public List<Projet> ValiderProjet(@PathVariable Long id){
        Projet projet = projetRepository.getById(id);
        projet.setStatut("Valide");
        projetRepository.save(projet);
        return projetRepository.findAll();
    }



}

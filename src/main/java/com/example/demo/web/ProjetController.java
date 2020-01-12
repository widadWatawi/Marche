package com.example.demo.web;


import com.example.demo.Repository.ProjetRepository;
import com.example.demo.entities.Phase;
import com.example.demo.entities.Projet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class ProjetController {

    @Autowired
    private ProjetRepository projetRepository;


    @PostMapping("/register")
    public String register(@RequestBody Projet projet){
        projetRepository.save(projet);
        return "saved successfullly";
    }

    @PutMapping("/projets/update")
    public Projet updateProject(@RequestBody Projet projet){
        return projetRepository.save(projet);
    }

    @GetMapping("/projets")
    public List<Projet> getProjects(){

        return projetRepository.findAll();
    }

    @GetMapping("/projets/{id}")
    public Optional<Projet> findById(@PathVariable Long id){
        return projetRepository.findById(id);

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

}

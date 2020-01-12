package com.example.demo.web;


import com.example.demo.Repository.PhaseRepository;
import com.example.demo.Repository.ProjetRepository;
import com.example.demo.entities.Phase;
import com.example.demo.entities.Projet;
import com.example.demo.entities.Tache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class PhaseController {

    @Autowired
    private PhaseRepository phaseRepository;

    @Autowired
    private ProjetRepository projetRepository;


    @PostMapping("/phase/new")
    public String addPhase(@RequestBody Phase phase, @RequestParam Long project_id){
        Projet projet = projetRepository.getById(project_id);
        phase.setProjet(projet);
        phaseRepository.save(phase);
        return "saved successfullly";
    }

    @PutMapping("/phase/update")
    public Phase updatePhase(@RequestBody Phase phase){

        return phaseRepository.save(phase);
    }

    @GetMapping("phase/cancel/{id}")
    public List<Phase> deletePhase(@PathVariable Long id, @RequestParam Long project_id){
        phaseRepository.deleteById(id);
        return projetRepository.getPhase(project_id);
    }

    @GetMapping("/phases/search/{name}")
    public List<Phase> findByName(@PathVariable String name){
        return phaseRepository.getByNom(name);

    }

    @GetMapping("/phases/{id}/tache")
    public List<Tache>getTache(@PathVariable Long id){
        return phaseRepository.getTache(id);

    }


    @GetMapping("/phase/valider/{id}")
    public List<Phase> ValiderPhase(@PathVariable Long id, @RequestParam Long project_id){
        Phase phase = phaseRepository.getById(id);
        phase.setStatut("Valide");
        phaseRepository.save(phase);
        return projetRepository.getPhase(project_id);
    }



}

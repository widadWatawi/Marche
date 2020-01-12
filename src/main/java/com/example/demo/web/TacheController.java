package com.example.demo.web;


import com.example.demo.Repository.PhaseRepository;
import com.example.demo.Repository.ProjetRepository;
import com.example.demo.Repository.TacheRepository;
import com.example.demo.entities.Phase;
import com.example.demo.entities.Tache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class TacheController {

    @Autowired
    private TacheRepository tacheRepository;

    @Autowired
    private PhaseRepository phaseRepository;


    @PostMapping("/tache/new")
    public String addTache(@RequestBody Tache tache, @RequestParam Long phase_id){
        Phase phase = phaseRepository.getById(phase_id);
        tache.setPhase(phase);
        tacheRepository.save(tache);
        return "saved successfullly";
    }

    @PutMapping("/tache/update")
    public Tache updateTache(@RequestBody Tache tache){

        return tacheRepository.save(tache);
    }

    @GetMapping("tache/cancel/{id}")
    public List<Tache> deleteTache(@PathVariable Long id, @RequestParam Long phase_id){
        tacheRepository.deleteById(id);
        return phaseRepository.getTache(phase_id);
    }

    @GetMapping("/taches/search/{name}")
    public List<Tache> findByName(@PathVariable String name){
        return tacheRepository.getByNom(name);

    }
}

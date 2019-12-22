package com.example.demo.Services;

import com.example.demo.Repository.ProjetRepository;
import com.example.demo.entities.Projet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjetService {

    @Autowired
    private ProjetRepository projetRepository;

    public Projet saveorUpdateProjet(Projet projet){
        if(projet.getStatut()==null || projet.getStatut()==""){
            projet.setStatut("TODO");
        }
        return projetRepository.save(projet);
    }

    public Iterable<Projet> findAll(){
        return projetRepository.findAll();
    }

    public Projet findById(Long id){
        return projetRepository.getById(id);
    }

    public void delete(Long id){
        Projet projet = findById(id);
        projetRepository.delete(projet);
    }

}

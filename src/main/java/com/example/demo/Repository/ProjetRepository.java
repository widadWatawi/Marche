package com.example.demo.Repository;

import com.example.demo.entities.Personnel;
import com.example.demo.entities.Projet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjetRepository extends JpaRepository<Projet, Long> {

    Projet getById(Long id);

    List<Projet> getByNom(String name);

}

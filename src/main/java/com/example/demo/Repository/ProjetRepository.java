package com.example.demo.Repository;

import com.example.demo.entities.Personnel;
import com.example.demo.entities.Phase;
import com.example.demo.entities.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjetRepository extends JpaRepository<Projet, Long> {

    Projet getById(Long id);

    List<Projet> getByNom(String name);

    @Query("select p from Projet p where p.chef.id = :id")
    List<Projet> getByChef(@Param("id") Long id);


    @Query("select p from Phase p where p.projet.id = :id")
    List<Phase> getPhase(@Param("id") Long id);


}

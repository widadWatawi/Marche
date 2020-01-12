package com.example.demo.Repository;

import com.example.demo.entities.Phase;
import com.example.demo.entities.Projet;
import com.example.demo.entities.Tache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PhaseRepository extends JpaRepository<Phase, Long> {

    Phase getById(Long id);

    List<Phase> getByNom(String name);


    @Query("select t from Tache t where t.phase.id = :id")
    List<Tache> getTache(@Param("id") Long id);


}

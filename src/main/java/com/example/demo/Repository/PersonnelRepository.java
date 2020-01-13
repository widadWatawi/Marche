package com.example.demo.Repository;

import com.example.demo.entities.Personnel;
import com.example.demo.entities.Projet;
import com.example.demo.entities.Tache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonnelRepository extends JpaRepository<Personnel, Long> {

    Personnel getById(Long id);


    @Query("select p from Personnel p where p.fonction.id = :id")
    List<Personnel> getFonction(@Param("id") Long id);

}

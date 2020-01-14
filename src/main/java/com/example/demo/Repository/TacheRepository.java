package com.example.demo.Repository;

import com.example.demo.entities.Projet;
import com.example.demo.entities.Tache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TacheRepository extends JpaRepository<Tache, Long> {

   Tache getById(Long id);

    List<Tache> getByNom(String name);

    @Query("select t from Tache t where t.collaborateur.id = :id")
    List<Tache> getByEmployee(@Param("id") Long id);


}

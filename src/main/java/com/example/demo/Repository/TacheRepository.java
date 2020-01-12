package com.example.demo.Repository;

import com.example.demo.entities.Tache;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TacheRepository extends JpaRepository<Tache, Long> {

   Tache getById(Long id);

    List<Tache> getByNom(String name);


}

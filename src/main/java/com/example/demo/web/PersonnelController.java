package com.example.demo.web;


import com.example.demo.Repository.PersonnelRepository;
import com.example.demo.entities.Personnel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping(value="/Personnel")
public class PersonnelController {

    @Autowired
    private PersonnelRepository personnelRepository;

    @GetMapping("/personnels")
    public List<Personnel> getAllPersonnels() {
        return personnelRepository.findAll();
    }



}

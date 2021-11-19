package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;

@Service

public class PersonService {
    @Autowired
    PersonRepository personRepository;
    
    @Cacheable("person")
    public List<Person> getAll() {
        return personRepository.findAll();
    }
    
    public Optional <Person> getPerson(@PathVariable Long id) {
        return personRepository.findById(id);
    }

}

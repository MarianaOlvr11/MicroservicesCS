package com.mari.services;

import com.mari.exceptions.ResourceNotFoundException;
import com.mari.model.Person;
import com.mari.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;


@Service // para se tornar injetavel
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class. getName());

    @Autowired
    PersonRepository repository;



    public Person findById(Long id){

        logger.info("Finding one person!"); // imprime no terminal

        return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));

    }

    public List<Person> findAll(){

        logger.info("Finding all people!"); // imprime no terminal

        return  repository.findAll();
    }


    public Person create(Person person){

        logger.info("Create one person"); // imprime no terminal
        return repository.save(person);
    }

    public Person update(Person person){

        logger.info("Update one person");// imprime no terminal

        Person entity = repository.findById(person.getId()).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));

        entity.setFirstname(person.getFirstname());
        entity.setLastName(person.getLastName());
        entity.setAdress(person.getAdress());
        entity.setGender(person.getGender());

        return repository.save(person);
    }

    public void delete(Long id){

        logger.info("Deleting one person"); // imprime no terminal

        Person entity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));

        repository.delete(entity);

    }




}

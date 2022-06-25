package com.pokemonapp.service;

import com.pokemonapp.DTO.TrainerDTO;
import com.pokemonapp.model.Trainer;
import com.pokemonapp.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TrainerService {

    @Autowired
    TrainerRepository trainerRepository;

    public List<Trainer> findAll(){ return trainerRepository.findAll();}

    public void deleteTrainer(long id){trainerRepository.deleteById(id);}

    public Trainer findById(long id){
        Trainer trainer = null;
        if (trainerRepository.findById(id).isPresent()) {
            trainerRepository.findById(id).get();
            trainer = trainerRepository.findById(id).get();
        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Not exist");
        }
        return trainer;
    }
    public Trainer addTrainerByName(TrainerDTO trainer) {
        if(!trainerRepository.findByUsername(trainer.getUsername()).isPresent()){
            if (trainer.getPicture() == null) {
                Trainer trainer1 = new Trainer(trainer.getUsername(), trainer.getBirth(), trainer.getHobby());
                return trainerRepository.save(trainer1);
            } else {
                Trainer trainer2 = new Trainer(trainer.getUsername(), trainer.getBirth(), trainer.getPicture(), trainer.getHobby());
                return trainerRepository.save(trainer2);
            }
        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "The Trainer already exists");
        }
    }
    public Trainer modifyAttributes(long id, Optional <String> username, Optional<String> picture, Optional <Date> birth, Optional<String> hobby){
        Trainer trainer;
        if(trainerRepository.findById(id).isPresent()){
            trainer = trainerRepository.findById(id).get();

            if (username.isPresent()){
                if(!username.isEmpty()){
                    trainer.setUsername(username.get());
                }
            }
            if(picture.isPresent()){
                if (!picture.isEmpty()){
                    trainer.setPicture(picture.get());
                }
            }
            if(birth.isPresent()){
                if (!birth.isEmpty()){
                    trainer.setBirth(birth.get());
                }
            }
            if(hobby.isPresent()){
                if (!hobby.isEmpty()){
                    trainer.setHobby(hobby.get());
                }
            }
        } else{
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,
                    "Third Party doesn't exist");
        }
        trainerRepository.save(trainer);
        return trainer;
    }

}
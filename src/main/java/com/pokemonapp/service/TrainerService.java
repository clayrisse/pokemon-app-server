package com.pokemonapp.service;

import com.pokemonapp.dto.PokeDTO;
import com.pokemonapp.dto.TrainerDTO;
import com.pokemonapp.model.Pokemon;
import com.pokemonapp.model.Trainer;
import com.pokemonapp.repository.PokemonRepository;
import com.pokemonapp.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TrainerService {

    @Autowired TrainerRepository trainerRepository;
    @Autowired PokemonService pokemonService;

    public List<Trainer> findAll(){ return trainerRepository.findAll();}

    public void deleteTrainer(long id){trainerRepository.deleteById(id);}

    public Trainer findById(long id){
        if (trainerRepository.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Not exist");
        }
        return trainerRepository.findById(id).get();
    }

     public Trainer findByUsername(String username){
        Optional opTrainer = trainerRepository.findByUsername(username);
        if (opTrainer.isPresent()) return (Trainer)opTrainer.get();
        throw new ResponseStatusException(HttpStatus.CONFLICT, "Username not found");
    }

    public Trainer addTrainer(TrainerDTO trainerDTO) {
        if(!trainerRepository.findByUsername(trainerDTO.getUsername()).isEmpty()){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "The Trainer already exists");
        }
        Trainer trainer = new Trainer(trainerDTO.getUsername(), trainerDTO.getBirth(), trainerDTO.getPicture(), trainerDTO.getHobby());
        if (trainerDTO.getPicture() != null) trainer.setPicture(trainerDTO.getPicture());
        return trainerRepository.save(trainer);
    }

    public Trainer modifyAttributes(long id, Optional <String> username, Optional<String> picture, Optional <Date> birth, Optional<String> hobby){
        if(trainerRepository.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Third Party doesn't exist");
        }
        Trainer trainer = trainerRepository.findById(id).get();
        if (username.isPresent())   trainer.setUsername(username.get());
        if (picture.isPresent())    trainer.setPicture(picture.get());
        if (birth.isPresent())      trainer.setBirth(birth.get());
        if (hobby.isPresent())      trainer.setHobby(hobby.get());
        return trainerRepository.save(trainer);
    }

    public Trainer addPokeToTrainer(String username, PokeDTO pokeDTO) {
        Pokemon poke = pokemonService.getPokemon(pokemonService.createPokemon(pokeDTO).getName());
        Trainer trainer = findByUsername(username);
        if (trainer.getPokeList().contains(poke)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Pokemon already added");
        }
        trainer.addPokemon(poke);
        return trainerRepository.save(trainer);
    }

    public Trainer removePokeFromTrainer(String username, String pokename) {
        Pokemon poke = pokemonService.getPokemon(pokename);
        Trainer trainer = findByUsername(username);
        trainer.removePokemon(poke.getId());
        return trainerRepository.save(trainer);
    }

    public List<Pokemon> getPokemonList(String username) {
        Trainer trainer = findByUsername(username);
        return trainer.getPokeList();
    }
}
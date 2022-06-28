package com.pokemonapp.controller;

import com.pokemonapp.dto.TrainerDTO;
import com.pokemonapp.dto.PokeDTO;
import com.pokemonapp.model.Pokemon;
import com.pokemonapp.model.Trainer;
import com.pokemonapp.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/trainer/")
public class TrainerController {

    @Autowired  TrainerService trainerService;


    @GetMapping("/id/{id}") @CrossOrigin()
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Trainer findEmployee(@PathVariable long id) {
        return trainerService.findById(id);
    }

    @GetMapping("/name/{username}") @CrossOrigin()
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Trainer getTrainerByUsername(@PathVariable String username) {
        System.err.println("entre a by name");
        return trainerService.findByUsername(username);
    }

    @GetMapping("/all") @CrossOrigin()
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Trainer> findAll() {
        return trainerService.findAll();
    }

    @DeleteMapping("/delete/{id}") @CrossOrigin()
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable long id) {
        trainerService.deleteTrainer(id);
    }

    @DeleteMapping("/delete_by_username/{username}")
    @CrossOrigin()
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteByUsername(@PathVariable String username) {
        trainerService.deleteTrainerByUsername(username);
    }

    @PostMapping("/add") @CrossOrigin()
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Trainer addTrainer(@RequestBody @Valid TrainerDTO trainer){
        System.out.println(trainer.getBirth().getYear());
        return trainerService.addTrainer(trainer);
    }

    @PutMapping("/update/{id}") @CrossOrigin()
    @ResponseStatus(HttpStatus.OK)
    public Trainer modifyAttributes(@PathVariable long id,
                                    //porque esto no va to-do junto como RequestBody y usas el mismo DTO?
                                    @RequestParam Optional<Date> birth,
                                    @RequestParam Optional<String> username,
                                    @RequestParam Optional<String> picture,
                                    @RequestParam Optional<String> hobby ) {
        return trainerService.modifyAttributes(id, username, picture, birth, hobby);
    }

    @PostMapping("{username}/poke/add")
    @CrossOrigin()
    @ResponseStatus(HttpStatus.CREATED)
    public Trainer addPokeToTrainer(@PathVariable String username,
                                    @RequestBody @Valid PokeDTO pokeDTO) {
        return trainerService.addPokeToTrainer(username, pokeDTO);
    }

    @PostMapping("{username}/poke/addobj") @CrossOrigin()
    @ResponseStatus(HttpStatus.CREATED)
    public Trainer addPokeObjToTrainer(@PathVariable String username,
                                    @RequestBody @Valid Pokemon pokemon) {
        System.err.println("entre---------- con poke");
        return trainerService.addPokeObjToTrainer(username, pokemon);
    }

    @DeleteMapping("{username}/poke/remove/{pokename}") @CrossOrigin()
    @ResponseStatus(HttpStatus.CREATED)
    public Trainer removePokeFromTrainer(@PathVariable String username,
                                        @PathVariable String pokename) {
        return trainerService.removePokeFromTrainer(username, pokename);
    }

    @GetMapping("{username}/poke/list") @CrossOrigin()
    @ResponseStatus(HttpStatus.CREATED)
    public List<Pokemon> getPokemonList(@PathVariable String username) {
        return trainerService.getPokemonList(username);
    }

}
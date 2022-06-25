package com.pokemonapp.controller;

import com.pokemonapp.DTO.TrainerDTO;
import com.pokemonapp.model.Trainer;
import com.pokemonapp.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class TrainerController {
    @Autowired
    TrainerService trainerService;

    @GetMapping("/find_by_id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Trainer findEmployee(@PathVariable long id) {
        return trainerService.findById(id);
    }

    @GetMapping("/findAll")
    @CrossOrigin()
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Trainer> findAll() {
        return trainerService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    @CrossOrigin()
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable long id){ trainerService.deleteTrainer(id);}

    @PostMapping("/add_trainer")
    @CrossOrigin()
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Trainer addTrainer(@RequestBody @Valid TrainerDTO trainer){
        return trainerService.addTrainerByName(trainer);
    }

    @PutMapping("/modify_attributes/{id}")
    @CrossOrigin()
    @ResponseStatus(HttpStatus.OK)
    public Trainer modifyAttributes(@PathVariable long id, @RequestParam Optional<String> username,
                                    @RequestParam Optional<Date> birth, @RequestParam Optional<String> picture, @RequestParam Optional<String> hobby ) {
        return trainerService.modifyAttributes(id, username, picture, birth, hobby);
    }

}
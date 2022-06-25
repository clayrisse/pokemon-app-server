package com.pokemonapp.controller;

import com.pokemonapp.dto.PokeDTO;
import com.pokemonapp.model.Pokemon;
import com.pokemonapp.model.Stats;
import com.pokemonapp.repository.PokemonRepository;
import com.pokemonapp.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/pokemon/")
public class PokemonController {

    @Autowired
    PokemonService pokemonService;

    @Autowired  PokemonRepository pokemonRepository;


    @GetMapping("all")
    @ResponseStatus(HttpStatus.OK)
    public List<Pokemon> getAllPokemon(){
       return pokemonService.getAllPokemon();
    }

    @GetMapping("{name}")
    @ResponseStatus(HttpStatus.OK)
    public Pokemon getPokemon(@PathVariable String name){
        return pokemonService.getPokemon(name);
    }

    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public Pokemon createPokemon(@RequestBody PokeDTO pokeDTO){
        return pokemonService.createPokemon(pokeDTO);
    }

}

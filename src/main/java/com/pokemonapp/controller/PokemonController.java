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

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/pokemon/")
public class PokemonController {

    @Autowired  PokemonService pokemonService;

    @GetMapping("all") @CrossOrigin()
    @ResponseStatus(HttpStatus.OK)
    public List<Pokemon> getAllPokemon() {
        return pokemonService.getAllPokemon();
    }

    @GetMapping("{name}") @CrossOrigin()
    @ResponseStatus(HttpStatus.OK)
    public Pokemon getPokemon(@PathVariable String name) {
        return pokemonService.getPokemon(name);
    }

    @PostMapping("create") @CrossOrigin()
    @ResponseStatus(HttpStatus.CREATED)
    public Pokemon createPokemon(@RequestBody @Valid PokeDTO pokeDTO) {
        return pokemonService.createPokemon(pokeDTO);
    }

}

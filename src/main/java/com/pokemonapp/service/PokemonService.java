package com.pokemonapp.service;


import com.pokemonapp.dto.PokeDTO;
import com.pokemonapp.model.Pokemon;
import com.pokemonapp.model.Stats;
import com.pokemonapp.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PokemonService {


    @Autowired PokemonRepository pokemonRepository;

    public Pokemon createPokemon(PokeDTO pokeDTO){
        if (pokemonRepository.findByName(pokeDTO.getName()).isPresent()) {
            throw new ResponseStatusException( HttpStatus.BAD_REQUEST, "Pokemon already added");
        }
        System.err.println("Estoy añadiento un nuevo poke");
        return pokemonRepository.save(new Pokemon(pokeDTO.getImage(), pokeDTO.getName(), pokeDTO.getHeight(), pokeDTO.getWeight(), pokeDTO.getExperience(), pokeDTO.getItems(),
                new Stats(pokeDTO.getHp(), pokeDTO.getAttack(), pokeDTO.getSpAttack(),  pokeDTO.getSpDefence(), pokeDTO.getDefence(), pokeDTO.getSpeed())));
    }

    public List<Pokemon> getAllPokemon() {
        return pokemonRepository.findAll();
    }

    public Pokemon getPokemon(String name){
        return pokemonRepository.findByName(name).get();

    }
}

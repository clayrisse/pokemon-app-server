package com.pokemonapp;

import com.pokemonapp.model.Pokemon;
import com.pokemonapp.model.Stats;
import com.pokemonapp.model.Trainer;
import com.pokemonapp.repository.PokemonRepository;
import com.pokemonapp.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class PokemonAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PokemonAppApplication.class, args);
	}
	@Autowired
	PokemonRepository pokemonRepository;
	@Autowired
	TrainerRepository trainerRepository;

	@Override
	public void run(String... args) throws Exception {


	}
}

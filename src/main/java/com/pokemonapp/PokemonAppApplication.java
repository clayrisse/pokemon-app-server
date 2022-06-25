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
		pokemonRepository.saveAll(List.of(
				new Pokemon("https://cdn2.actitudfem.com/media/files/styles/large/public/images/2014/07/memegrande.jpg"
						,"n1", 1, 1, 1, 1, new Stats(1,1,1,1,1,1)),
				new Pokemon("https://cdn2.actitudfem.com/media/files/styles/large/public/images/2014/07/memegrande.jpg"
						,"n2", 1, 1, 1, 1, new Stats(1,1,1,1,1,1)),
				new Pokemon("https://cdn2.actitudfem.com/media/files/styles/large/public/images/2014/07/memegrande.jpg"
						,"n3", 1, 1, 1, 1, new Stats(1,1,1,1,1,1)),
				new Pokemon("https://cdn2.actitudfem.com/media/files/styles/large/public/images/2014/07/memegrande.jpg"
						,"n4", 1, 1, 1, 1, new Stats(1,1,1,1,1,1))
		));
		Trainer trainer1 = new Trainer("Rocio",new Date(12-11-2002), "nada");
		trainerRepository.save(trainer1);

		trainerRepository.saveAll(List.of(new Trainer("maria", new Date(10-8-1998), "nada"),
				new Trainer("motoko", new Date(10-5-2001), "picture1", "nada"),
				new Trainer("claudia", new Date(21-1-1987), "nada")));
	}
}

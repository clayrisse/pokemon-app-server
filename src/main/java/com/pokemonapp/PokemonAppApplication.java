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

//---------------------------------------------------------------Clau

//		pokemonRepository.saveAll(List.of(
//				new Pokemon("https://cdn2.actitudfem.com/media/files/styles/large/public/images/2014/07/memegrande.jpg"
//						,"motoko", 1, 1, 1, 1, new Stats(1,1,1,1,1,1)),
//				new Pokemon("https://cdn2.actitudfem.com/media/files/styles/large/public/images/2014/07/memegrande.jpg"
//						,"rocio", 1, 1, 1, 1, new Stats(1,1,1,1,1,1)),//
//				new Pokemon("https://cdn2.actitudfem.com/media/files/styles/large/public/images/2014/07/memegrande.jpg"
//						,"n4", 1, 1, 1, 1, new Stats(1,1,1,1,1,1))
//		));

		/*
		Trainer t1 = new Trainer("test", new Date(10-8-1998), "nada");
		Trainer t2 = new Trainer("test2", new Date(10-8-1998), "nada");
		Pokemon p1 = new Pokemon("https://cdn2.actitudfem.com/media/files/styles/large/public/images/2014/07/memegrande.jpg","poketest1", 1, 1, 1, 1, new Stats(1,1,1,1,1,1));
		Pokemon p2 = new Pokemon("https://cdn2.actitudfem.com/media/files/styles/large/public/images/2014/07/memegrande.jpg","poketest2", 1, 1, 1, 1, new Stats(1,1,1,1,1,1));
		Pokemon p3 = new Pokemon("https://cdn2.actitudfem.com/media/files/styles/large/public/images/2014/07/memegrande.jpg","poketest3", 1, 1, 1, 1, new Stats(1,1,1,1,1,1));

		trainerRepository.save(t1);
		pokemonRepository.save(p1);
		pokemonRepository.save(p2);
		pokemonRepository.save(p3);
		t1.addPokemon(p1);
		t1.addPokemon(p2);
		t1.addPokemon(p3);
		trainerRepository.save(t1);

		trainerRepository.save(t2);
		t2.addPokemon(p1);
		t2.addPokemon(p2);
		t2.addPokemon(p3);
		trainerRepository.save(t2);
//		trainerRepository.delete(t2);
		trainerRepository.deleteById(t2.getId());
		t2.removePokemon(3);
		trainerRepository.save(t2);

		 */


//---------------------------------------------------------------------Rocio

//		Trainer trainer1 = new Trainer("Rocio",new Date(12-11-2002), "nada");
//		trainerRepository.save(trainer1);
//
//		trainerRepository.saveAll(List.of(new Trainer("maria", new Date(10-8-1998), "nada"),
//				new Trainer("motoko", new Date(10-5-2001), "picture1", "nada"),
//				new Trainer("claudia", new Date(21-1-1987), "nada")));


	}
}

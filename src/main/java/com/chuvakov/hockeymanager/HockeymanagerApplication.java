package com.chuvakov.hockeymanager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.chuvakov.hockeymanager.domain.Player;
import com.chuvakov.hockeymanager.domain.PlayerRepository;

@SpringBootApplication
public class HockeymanagerApplication {

	private static final Logger log = LoggerFactory.getLogger(HockeymanagerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(HockeymanagerApplication.class, args);
	}
	/*
	 	Forwards
		Defensemen
		Goalies
	 */
	

	@Bean
	public CommandLineRunner studentDemo(PlayerRepository prepository) {
		return (args) -> {
		
			prepository.save(new Player("John Smith", 12, "Forwards", 10, 15));
			prepository.save(new Player("Mikko Virtanen", 9, "Forwards", 8, 12));
			prepository.save(new Player("Ivan Petrov", 88, "Forwards", 12, 8));
			prepository.save(new Player("Andrejs Ozols", 27, "Forwards", 5, 10));
			prepository.save(new Player("Erik Lundqvist", 19, "Forwards", 7, 14));
			prepository.save(new Player("Alexei Kuznetsov", 15, "Defensemen", 3, 20));
			prepository.save(new Player("Sara Andersson", 4, "Defensemen", 2, 18));
			prepository.save(new Player("Pavel Sokolov", 2, "Defensemen", 4, 12));
			prepository.save(new Player("Mikael Lindgren", 7, "Defensemen", 1, 15));
			prepository.save(new Player("Juris Bērziņš", 22, "Defensemen", 2, 10));
			prepository.save(new Player("Markus Sjöberg", 30, "Goalies", 0, 0));
			prepository.save(new Player("Anton Lehtinen", 31, "Goalies", 0, 0));
			prepository.save(new Player("Dmitri Ivanov", 35, "Goalies", 0, 0));
			prepository.save(new Player("Michael Johnson", 11, "Forwards", 9, 14));
			prepository.save(new Player("Elena Martinez", 14, "Forwards", 7, 11));
			prepository.save(new Player("Lucas Silva", 92, "Forwards", 11, 7));
			prepository.save(new Player("Sophie Müller", 23, "Forwards", 4, 9));
			prepository.save(new Player("William Baker", 17, "Forwards", 8, 16));
			prepository.save(new Player("Nina Kovalenko", 12, "Defensemen", 2, 19));
			prepository.save(new Player("Rafael Gonzalez", 5, "Defensemen", 3, 17));
			prepository.save(new Player("Isabella Schmidt", 3, "Defensemen", 5, 14));
			prepository.save(new Player("Daniel Kim", 8, "Defensemen", 2, 13));
			prepository.save(new Player("Maria Rodriguez", 29, "Defensemen", 1, 11));
			prepository.save(new Player("Samuel Wilson", 33, "Goalies", 0, 0));
			prepository.save(new Player("Olivia Anderson", 34, "Goalies", 0, 0));
			prepository.save(new Player("Gabriel Martinez", 36, "Goalies", 0, 0));

			
			log.info("fetch all players");
			for (Player player : prepository.findAll()) {
				log.info(player.toString());
			}
		};
	}
}

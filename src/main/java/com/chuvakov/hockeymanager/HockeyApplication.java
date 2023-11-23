package com.chuvakov.hockeymanager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.chuvakov.hockeymanager.domain.AppUser;
import com.chuvakov.hockeymanager.domain.AppUserRepository;
import com.chuvakov.hockeymanager.domain.Player;
import com.chuvakov.hockeymanager.domain.PlayerRepository;
//import com.chuvakov.hockeymanager.domain.Position;
import com.chuvakov.hockeymanager.domain.PositionRepository;

@SpringBootApplication
public class HockeyApplication {
	
	private static final Logger log = LoggerFactory.getLogger(HockeyApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(HockeyApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner studentDemo(PlayerRepository repository, PositionRepository posrepository, AppUserRepository urepository) {
		return (args) -> {

			/*
			log.info("Save some players);
			repository.save(new Player("Denis Chuvakov", 1, 10, 20, 30, posrepository.findByName("Forwards").get(0)));
			repository.save(new Player("Alexei Ivanov", 2, 15, 25, 40, posrepository.findByName("Defensemen").get(0)));
			repository.save(new Player("John Smith", 3, 8, 12, 20, posrepository.findByName("Forwards").get(0)));
			repository.save(new Player("William Johnson", 4, 5, 15, 20, posrepository.findByName("Goalies").get(0)));
			repository.save(new Player("Aapo Virtanen", 5, 12, 18, 30, posrepository.findByName("Forwards").get(0)));
			repository.save(new Player("Erik Andersson", 6, 20, 30, 50, posrepository.findByName("Defensemen").get(0)));
			repository.save(new Player("Arturs Berzins", 7, 2, 5, 7, posrepository.findByName("Goalies").get(0)));
			repository.save(new Player("Nikolai Petrov", 8, 7, 10, 17, posrepository.findByName("Forwards").get(0)));
			repository.save(new Player("Matthew Brown", 9, 15, 22, 37, posrepository.findByName("Defensemen").get(0)));
			repository.save(new Player("Juho Salonen", 10, 6, 8, 14, posrepository.findByName("Forwards").get(0)));
			repository.save(new Player("Victor Lundqvist", 11, 18, 28, 46, posrepository.findByName("Defensemen").get(0)));
			repository.save(new Player("Igor Smirnov", 12, 4, 6, 10, posrepository.findByName("Goalies").get(0)));
			repository.save(new Player("Christopher White", 13, 9, 15, 24, posrepository.findByName("Forwards").get(0)));
			repository.save(new Player("Sergei Popov", 14, 12, 20, 32, posrepository.findByName("Defensemen").get(0)));
			repository.save(new Player("Benjamin Thompson", 15, 3, 8, 11, posrepository.findByName("Goalies").get(0)));
			repository.save(new Player("Mikko Nieminen", 16, 14, 24, 38, posrepository.findByName("Forwards").get(0)));
			repository.save(new Player("Gustav Svensson", 17, 5, 10, 15, posrepository.findByName("Defensemen").get(0)));
			repository.save(new Player("Roberts Ozols", 18, 20, 30, 50, posrepository.findByName("Forwards").get(0)));
			repository.save(new Player("Kaspars Eglitis", 19, 7, 12, 19, posrepository.findByName("Defensemen").get(0)));
			repository.save(new Player("Edgars Dzirkalis", 20, 1, 3, 4, posrepository.findByName("Goalies").get(0)));
			
			log.info("Save positions: "Forwards", "Defensemen", "Goalies" );
			posrepository.save(new Position("Forwards"));
			posrepository.save(new Position("Defensemen"));
			posrepository.save(new Position("Goalies"));		
			
			log.info("Create users: admin/admin user/user");
			AppUser user1 = new AppUser("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			AppUser user2 = new AppUser("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			AppUser user3 = new AppUser("denis", "$2a$12$nhMRwdPAFf2NdB3XMUSmWuDPzXkyIko5g8YWU//vRvIOpBua.efnO", "ADMIN");
			
			urepository.save(user1);
			urepository.save(user2);
			urepository.save(user3);
		*/
			
			log.info("fetch all players");
			for (Player player : repository.findAll()) {
				log.info(player.toString());
			}
			
			log.info("fetch all users");
			for (AppUser user : urepository.findAll()) {
				log.info(user.toString());
			}

		};
	}

}

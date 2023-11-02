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

	@Bean
	public CommandLineRunner studentDemo(PlayerRepository prepository) {
		return (args) -> {
			prepository.save(new Player("Den Chuv", 67, "def", 2, 1, 3));
		};
	}
}

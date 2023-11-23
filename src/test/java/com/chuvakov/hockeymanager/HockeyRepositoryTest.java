package com.chuvakov.hockeymanager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

import com.chuvakov.hockeymanager.domain.Player;
import com.chuvakov.hockeymanager.domain.PlayerRepository;
import com.chuvakov.hockeymanager.domain.PositionRepository;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class HockeyRepositoryTest {

	@Autowired
	private PlayerRepository repository;
	
	@Autowired
	private PositionRepository posrepository;

	@Test
	public void findPlayerByNumber() {
		List<Player> players = repository.findByNumber(67);
		assertThat(players).hasSize(1);
		assertThat(players.get(0).getNumber()).isEqualTo(67);
	}

	@Test
	public void savePlayer() {
		Player player = new Player("Test Player", 99, 10, 5, 15, posrepository.findByName("Forwards").get(0));
		repository.save(player);

		Optional<Player> savedPlayer = repository.findById(player.getId());
		assertThat(savedPlayer).isPresent();
		assertThat(savedPlayer.get().getName()).isEqualTo("Test Player");
		assertThat(savedPlayer.get().getNumber()).isEqualTo(99);
	}

	@Test
	public void deletePlayer() {
		Player player = new Player("Test Player", 99, 10, 5, 15, null);
		repository.save(player);

		long playerId = player.getId();
		repository.deleteById(playerId);

		Optional<Player> deletedPlayer = repository.findById(playerId);
		assertThat(deletedPlayer).isNotPresent();
	}

	@Test
	public void findTopPlayerByGoals() {
		List<Player> topPlayers = repository.findTopPlayerByGoals(PageRequest.of(0, 1));
		assertThat(topPlayers).isNotEmpty();
		assertThat(topPlayers.get(0).getGoals()).isGreaterThanOrEqualTo(0);
	}

	@Test
	public void findTopPlayerByAssists() {
		List<Player> topPlayers = repository.findTopPlayerByAssists(PageRequest.of(0, 1));
		assertThat(topPlayers).isNotEmpty();
		assertThat(topPlayers.get(0).getAssists()).isGreaterThanOrEqualTo(0);
	}

	@Test
	public void findTopPlayerByPoints() {
		List<Player> topPlayers = repository.findTopPlayerByPoints(PageRequest.of(0, 1));
		assertThat(topPlayers).isNotEmpty();
		assertThat(topPlayers.get(0).getPoints()).isGreaterThanOrEqualTo(0);
	}
}

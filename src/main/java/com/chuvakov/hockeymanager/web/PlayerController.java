package com.chuvakov.hockeymanager.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chuvakov.hockeymanager.domain.Player;
import com.chuvakov.hockeymanager.domain.PlayerRepository;
import com.chuvakov.hockeymanager.domain.PositionRepository;

@Controller
public class PlayerController {

	@Autowired
	private PlayerRepository repository;

	@Autowired
	private PositionRepository posrepository;

	// Go to the homepage
	@RequestMapping(value = { "/", "/home" })
	public String home(Model model) {
		return "home";
	}

	// Get all players or search players by name
	@RequestMapping(value = "/playerlist")
	public String playerlist(Model model, @RequestParam(required = false) String search) {
		List<Player> players;

		if (search != null && !search.isEmpty()) {
			players = repository.findByName(search);
		} else {
			players = (List<Player>) repository.findAll();
		}

		model.addAttribute("players", players);
		return "playerlist";
	}

	// RESTful service to get all players
	@RequestMapping(value = "/players", method = RequestMethod.GET)
	public @ResponseBody List<Player> playerListRest() {
		return (List<Player>) repository.findAll();
	}

	// RESTful service to get player by id
	@RequestMapping(value = "/player/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Player> findPlayerRest(@PathVariable("id") Long playerId) {
		return repository.findById(playerId);
	}

	// Add new player
	@RequestMapping(value = "/add")
	public String addPlayer(Model model) {
		model.addAttribute("player", new Player());
		model.addAttribute("position", posrepository.findAll());
		return "addplayer";
	}

	// Save new player
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Player player) {
		player.setPoints(player.getGoals() + player.getAssists());
		repository.save(player);
		return "redirect:playerlist";
	}

	// Delete player
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deletePlayer(@PathVariable("id") Long playerId, Model model) {
		repository.deleteById(playerId);
		return "redirect:../playerlist";
	}

	// Edit player
	@RequestMapping(value = "/edit/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String editPlayer(@PathVariable("id") Long playerId, Model model) {
		model.addAttribute("player", repository.findById(playerId));
		model.addAttribute("position", posrepository.findAll());
		return "editplayer";
	}

	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/topplayers")
	public String topPlayers(Model model) {
		// Fetch the player with the most goals
		List<Player> topPlayersByGoals = repository.findTopPlayerByGoals(PageRequest.of(0, 1));
		if (!topPlayersByGoals.isEmpty()) {
			model.addAttribute("topPlayerByGoals", topPlayersByGoals.get(0));
		}

		// Fetch the player with the most assists
		List<Player> topPlayersByAssists = repository.findTopPlayerByAssists(PageRequest.of(0, 1));
		if (!topPlayersByAssists.isEmpty()) {
			model.addAttribute("topPlayerByAssists", topPlayersByAssists.get(0));
		}

		// Fetch the player with the most points
		List<Player> topPlayersByPoints = repository.findTopPlayerByPoints(PageRequest.of(0, 1));
		if (!topPlayersByPoints.isEmpty()) {
			model.addAttribute("topPlayerByPoints", topPlayersByPoints.get(0));
		}

		return "topplayers";
	}
<<<<<<< HEAD
}
=======
}
>>>>>>> c02829118405b3826814b24c1073f2e7eee3be49

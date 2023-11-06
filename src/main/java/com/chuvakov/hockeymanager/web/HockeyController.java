package com.chuvakov.hockeymanager.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.chuvakov.hockeymanager.domain.Player;
import com.chuvakov.hockeymanager.domain.PlayerRepository;

@Controller
public class HockeyController {

	@Autowired
	private PlayerRepository prepository;

	@RequestMapping(value = { "/", "/home" })
	public String home() {
		return "home";
	}
	
	@RequestMapping("/events")
	public String events() {
		return "events";
	}

	// Get all players
	@RequestMapping("/players")
	public String players(Model model) {
		// Fetch all players from the repository
		List<Player> players = (List<Player>) prepository.findAll();
		// Add the players to the model
		model.addAttribute("player", players);
		return "players";
	}

	// Add new player
	@RequestMapping(value = "/add")
	public String addPlayer(Model model) {
		model.addAttribute("player", new Player());
		return "addplayer";
	}

	// Save new Player
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Player player) {
		// update points:
		player.setPoints(player.getGoals() + player.getAssists());
		prepository.save(player);
		return "redirect:players";
	}

	// Delete player by id
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deletePlayer(@PathVariable("id") Long playerId, Model model) {
		prepository.deleteById(playerId);
		return "redirect:../players";
	}

	// Edit player
	@RequestMapping(value = "/edit/{id}")
	public String editPlayer(@PathVariable("id") Long playerId, Model model) {
		model.addAttribute("player", prepository.findById(playerId));
		return "editplayer";
	}

}

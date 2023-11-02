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
	
	@RequestMapping("/players")
    public String players(Model model) {
        List<Player> players = (List<Player>) prepository.findAll(); // Fetch all players from the repository
        model.addAttribute("player", players); // Add the players to the model
        return "players";
    }

}

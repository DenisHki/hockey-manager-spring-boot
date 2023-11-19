package com.chuvakov.hockeymanager.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Player {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	private String name;
	private int number;
	private int goals;
	private int assists;
	private int points;
	
	@ManyToOne
	@JoinColumn(name = "positionid")
	    private Position position ;
	
	public Player() {}
	
	public Player(String name, int number, int goals, int assists, int points, Position position) {
		super();
		this.name = name;
		this.number = number;
		this.goals = goals;
		this.assists = assists;
		this.points = points;
		this.position=position;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getGoals() {
		return goals;
	}

	public void setGoals(int goals) {
		this.goals = goals;
	}

	public int getAssists() {
		return assists;
	}

	public void setAssists(int assists) {
		this.assists = assists;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", number=" + number + ", goals=" + goals + ", assists="
				+ assists + ", points=" + points + ", position=" + position + "]";
	}

	

}

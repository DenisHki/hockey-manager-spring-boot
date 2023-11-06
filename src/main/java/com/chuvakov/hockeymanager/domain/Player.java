package com.chuvakov.hockeymanager.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String pName;
	private int pNum;
	private String position;
	private int goals;
	private int assists;
	private int points;

	public Player(String pName, int pNum, String position, int goals, int assists) {
		super();
		this.pName = pName;
		this.pNum = pNum;
		this.position = position;
		this.goals = goals;
		this.assists = assists;
		this.points = calculatePoints(goals, assists);
	}

	public Player(String pName, int pNum, String position, int goals, int assists, int points) {
		super();
		this.pName = pName;
		this.pNum = pNum;
		this.position = position;
		this.goals = goals;
		this.assists = assists;
		this.points = points;
	}

	public Player() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getpNum() {
		return pNum;
	}

	public void setpNum(int pNum) {
		this.pNum = pNum;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
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

	// Calculate points
	private int calculatePoints(int goals, int assists) {
		return points = goals + assists;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", pName=" + pName + ", pNum=" + pNum + ", position=" + position + ", goals="
				+ goals + ", assists=" + assists + ", points=" + points + "]";
	}

}

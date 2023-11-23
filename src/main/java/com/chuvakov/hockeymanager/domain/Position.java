package com.chuvakov.hockeymanager.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;


@Entity
public class Position {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long positionid; 
	    private String name;
	    
	    @JsonIgnore
	    @OneToMany(cascade = CascadeType.ALL, mappedBy = "position")
	    private List<Player> players;

	    public Position() {}

		public Position(String name) {
			super();
			this.name = name;
		}

		public Long getPositionid() {
			return positionid;
		}

		public void setPositionId(Long positionid) {
			this.positionid = positionid;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<Player> getPlayers() {
			return players;
		}

		public void setPlayers(List<Player> players) {
			this.players = players;
		}
		
		@Override
		public String toString() {
			return "Position [positionid=" + positionid + ", name=" + name + "]";
		}

}
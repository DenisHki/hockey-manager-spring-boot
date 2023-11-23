package com.chuvakov.hockeymanager.domain;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Long> {
	List<Player> findByName(String name);

	@Query("SELECT p FROM Player p ORDER BY p.goals DESC")
	List<Player> findTopPlayerByGoals(Pageable pageable);

	@Query("SELECT p FROM Player p ORDER BY p.assists DESC")
	List<Player> findTopPlayerByAssists(Pageable pageable);

	@Query("SELECT p FROM Player p ORDER BY p.points DESC")
	List<Player> findTopPlayerByPoints(Pageable pageable);
<<<<<<< HEAD

	List<Player> findByNumber(int number);
}
=======
}
>>>>>>> c02829118405b3826814b24c1073f2e7eee3be49

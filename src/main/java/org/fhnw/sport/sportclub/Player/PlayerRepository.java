package org.fhnw.sport.sportclub.Player;


import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
    Player getPlayerByPlayerID(Integer playerID);
}

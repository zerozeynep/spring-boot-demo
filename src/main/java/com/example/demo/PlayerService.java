package com.example.demo;

import org.springframework.stereotype.Service;
import com.example.demo.model.Player;
import com.example.demo.model.Player.Position;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.exceptions.PlayerAlreadyExistsError;
import com.example.demo.exceptions.PlayerDoesNotExistException;
import com.example.demo.exceptions.PositionIsFullError;
import com.example.demo.exceptions.TeamIsFullError;

@Service
public class PlayerService {

  private final PlayerRepository playerRepository;

  public PlayerService(PlayerRepository playerRepository) {
    this.playerRepository = playerRepository;
  }
  
  public Player addPlayer(@Valid String name, @Valid String surname, Position position) {
    Long playerCount = playerRepository.count();
    List<Player> playerList = playerRepository.findAll();
    Boolean isPositionFull = false;

    for (Player playerElem : playerList) {
      if(playerElem.getPosition() == position){
        isPositionFull = true;
      }
    }
    
    if (playerCount == 5) {
      throw new TeamIsFullError("Cannot register new players, the team is full.");
    }
    else if(isPositionFull){
      throw new PositionIsFullError("This position is full, please try another position.");
    } 
    else if(playerList.stream().anyMatch(p -> (p.getName() == name) & (p.getSurname() == surname))){
      throw new PlayerAlreadyExistsError("This player already exists.");
    }
    else {
      Player player = new Player();
      player.setName(name);
      player.setSurname(surname);
      player.setPosition(position);
      playerRepository.save(player);
      return player;
    }
  }

  public boolean deletePlayer(Integer id) {
    List<Player> playerList = playerRepository.findAll();

    if (!(playerList.stream().anyMatch(p -> p.getId() == id))) {
      throw new PlayerDoesNotExistException("A player does not exists with id:" +id+"");
    }
    else
    {
      playerRepository.deleteById(id);
      return true;
    }
  }

  public List<Player> findAllPlayers() {
    return playerRepository.findAll();
  }


}
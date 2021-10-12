package com.example.demo.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import graphql.kickstart.tools.GraphQLMutationResolver;

import com.example.demo.model.Player;
import com.example.demo.model.Player.Position;

import java.util.List;

import com.example.demo.PlayerService;


@Component
@Validated
public class Mutation implements GraphQLMutationResolver {
  
  @Autowired
  PlayerService playerService;
  
    public Player addPlayer(String name, String surname, Position position) {
      return playerService.addPlayer(name, surname, position);
    }
  
    public Boolean deletePlayer(Integer id) {
    return playerService.deletePlayer(id);
    }

    public List<Player> findAllPlayers(){
      return playerService.findAllPlayers();
    }

}
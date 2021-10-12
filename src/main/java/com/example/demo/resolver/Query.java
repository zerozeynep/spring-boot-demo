package com.example.demo.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.kickstart.tools.GraphQLQueryResolver;

import com.example.demo.model.Player;

import java.util.List;

import com.example.demo.PlayerService;

@Component
public class Query implements GraphQLQueryResolver {

  @Autowired
  PlayerService playerService;

  public List<Player> findAllPlayers() {
    return playerService.findAllPlayers();
  }
  
  }

package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.model.Player;

@Controller
@RequestMapping()
public class MainController {

  @Autowired
  private PlayerRepository playerRepository;

  @GetMapping(path="/all")
  public @ResponseBody Iterable<Player> findAllPlayers() {
    return playerRepository.findAll();
  }
}
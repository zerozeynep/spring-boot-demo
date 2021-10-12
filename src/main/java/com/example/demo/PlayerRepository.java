package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Player;


public interface PlayerRepository extends JpaRepository<Player, Integer> {

}


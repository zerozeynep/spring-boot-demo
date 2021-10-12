package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.example.demo.model.Player;
import com.example.demo.model.Player.Position;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BasketballRegistrationApplicationTests {


	@Autowired
	PlayerService playerService;

	@MockBean
	PlayerRepository playerRepository;


	@Test
	public void findAllPlayersTest() {
		Player player1 = new Player();
		player1.setId(111);
		player1.setName("Name");
		player1.setSurname("Surname");
		player1.setPosition(Position.C);

		Player player2 = new Player();
		player1.setId(222);
		player1.setName("Name2");
		player1.setSurname("Surname2");
		player1.setPosition(Position.PF);

		when(playerRepository.findAll()).thenReturn(Stream.of(player1,player2).collect(Collectors.toList()));
		assertEquals(2, playerService.findAllPlayers().size());
	}

	@Test
	public void addPlayerTest() {
		Player player = new Player();
		player.setId(111);
		player.setName("Name");
		player.setSurname("Surname");
		player.setPosition(Position.C);
		when(playerRepository.save(player)).thenReturn(player);
		assertNotNull(playerService.findAllPlayers());
	}

}

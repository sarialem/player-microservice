package com.intuit.playermicroservice;

import com.intuit.playermicroservice.model.dtos.PlayerDto;
import com.intuit.playermicroservice.model.entity.Player;
import com.intuit.playermicroservice.exception.PlayerNotFoundException;
import com.intuit.playermicroservice.repository.PlayerRepository;
import com.intuit.playermicroservice.service.PlayerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PlayerServiceTests {

	private static String EXISTING_PLAYERID = "existing";
	private static String NONEXISTING_PLAYERID = "non-existing";
	private static String PLAYER1ID = "player1";
	private static String PLAYER2ID = "player2";

	@Mock
	PlayerRepository playerRepository;

	@InjectMocks
	PlayerService playerService;

	@BeforeEach
	void prepareMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void getPlayerById_WhenPlayerExists_ReturnPlayerDto() {

		when(playerRepository.findById(EXISTING_PLAYERID)).thenReturn(Optional.of(new Player(EXISTING_PLAYERID)));

		PlayerDto player = playerService.getPlayerById(EXISTING_PLAYERID);

		assertNotNull(player);
		assertEquals(player.getId(), EXISTING_PLAYERID);
	}

	@Test
	void getPlayerById_WhenPlayerNotExists_ThrowsException() {

		when(playerRepository.findById(NONEXISTING_PLAYERID)).thenReturn(Optional.empty());

		assertThrows(PlayerNotFoundException.class, () -> playerService.getPlayerById(NONEXISTING_PLAYERID));
	}

	@Test
	void getPlayerById_InputIsEmpty_ThrowsException() {
		assertThrows(IllegalArgumentException.class, () -> playerService.getPlayerById(""));
	}

	@Test
	void getPlayerById_InputIsNull_ThrowsException() {
		assertThrows(IllegalArgumentException.class, () -> playerService.getPlayerById(null));
	}


	@Test
	void getAllPlayers_ValidInput_ReturnPage() {
		Player player1 = new Player(PLAYER1ID);
		Player player2 = new Player(PLAYER2ID);
		PlayerDto player1Dto = new PlayerDto(player1);
		PlayerDto player2Dto = new PlayerDto(player2);
		PageImpl<Player> pageResult = new PageImpl<>(List.of(player1, player2));
		when(playerRepository.findAll(any(Pageable.class))).thenReturn(pageResult);

		Page<PlayerDto> result = playerService.getAllPlayers(Pageable.ofSize(2));

		assertThat(result.getContent(), is(List.of(player1Dto, player2Dto)));
		assertEquals(result.getSize(),2);
	}

	@Test
	void getAllPlayers_NullInput_ThrowException() {
		assertThrows(IllegalArgumentException.class, () -> playerService.getAllPlayers(null));
	}

}

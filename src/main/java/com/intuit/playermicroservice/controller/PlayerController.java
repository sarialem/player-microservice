package com.intuit.playermicroservice.controller;

import com.intuit.playermicroservice.model.dtos.PlayerDto;
import com.intuit.playermicroservice.service.PlayerService;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController()
@RequestMapping(value="/api/v1/players",  produces ="application/json")
public class PlayerController {

    PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping()
    public Page<PlayerDto> getAllPlayers(@ParameterObject Pageable pageable) {
        return playerService.getAllPlayers(pageable);
    }

    @GetMapping("/{id}")
    public PlayerDto getPlayerById(@PathVariable("id") String playerId) {
        return playerService.getPlayerById(playerId);
    }
}

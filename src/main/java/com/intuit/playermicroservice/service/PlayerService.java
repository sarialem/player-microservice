package com.intuit.playermicroservice.service;

import com.intuit.playermicroservice.model.dtos.PlayerDto;
import com.intuit.playermicroservice.model.entity.Player;
import com.intuit.playermicroservice.exception.PlayerNotFoundException;
import com.intuit.playermicroservice.repository.PlayerRepository;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerService {

    PlayerRepository playerRepository;
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Page<PlayerDto> getAllPlayers(@NotNull Pageable pageable) {
        if(pageable == null){
            throw new IllegalArgumentException("pageable argument should not be null");
        }
        Page<Player> result = playerRepository.findAll(pageable);
        return result.map(PlayerDto::new);
    }

    public PlayerDto getPlayerById(@NotEmpty String id) {

        if(id == null || id.isEmpty()){
            throw new IllegalArgumentException("id argument should not be empty");
        }

        Optional<Player> result = playerRepository.findById(id);

        if(result.isEmpty()) {
            throw new PlayerNotFoundException(id);
        }
        return new PlayerDto(result.get());
    }

}

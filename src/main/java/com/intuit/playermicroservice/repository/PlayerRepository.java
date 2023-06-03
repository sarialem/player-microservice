package com.intuit.playermicroservice.repository;

import com.intuit.playermicroservice.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player,String> {
}

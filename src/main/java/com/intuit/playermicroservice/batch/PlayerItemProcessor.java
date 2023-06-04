package com.intuit.playermicroservice.batch;

import com.intuit.playermicroservice.model.entity.Player;
import org.springframework.batch.item.ItemProcessor;

public class PlayerItemProcessor implements ItemProcessor<Player, Player> {
    @Override
    public Player process(final Player player) throws Exception {
        return player;
    }
}

package com.example.FirstJapCurd.service;

import com.example.FirstJapCurd.model.Player;
import com.example.FirstJapCurd.repositories.PlayerRepository;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

PlayerRepository playerRepository;

public PlayerService(PlayerRepository playerRepository){
    this.playerRepository = playerRepository;
}

public Player createPlayer(Player player){
    return playerRepository.save(player);
}

public Player getPlayerById(long id){
    return playerRepository.getById(id);
}


}

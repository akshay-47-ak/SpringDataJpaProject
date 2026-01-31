package com.example.FirstJapCurd.service;

import com.example.FirstJapCurd.exceptions.ResourceNotFoundException;
import com.example.FirstJapCurd.model.Player;
import com.example.FirstJapCurd.repositories.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
    return playerRepository.findById(id)
            .orElseThrow(()->
                    new ResourceNotFoundException("Player Not Found With Player Id :"+id));
}

public Player updatePlayer(Player player){
   Player existingPlayer = playerRepository.findById(player.getId()).orElseThrow(
           ()-> new ResourceNotFoundException("Player Not Found with Id :" + player.getId())
           );
   existingPlayer.setName(player.getName());
   existingPlayer.setLevel(player.getLevel());
   return playerRepository.save(existingPlayer);
}

public List<Player>getAllPlayers(){
    List<Player> playerList = playerRepository.findAll();
    if( playerList.isEmpty())
        throw  new ResourceNotFoundException("No Data Found!");

    return playerList;
}


}

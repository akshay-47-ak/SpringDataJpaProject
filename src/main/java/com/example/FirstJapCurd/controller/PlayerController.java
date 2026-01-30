package com.example.FirstJapCurd.controller;


import com.example.FirstJapCurd.model.Player;
import com.example.FirstJapCurd.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/players")
public class PlayerController {

    PlayerService playerService;

    public PlayerController(PlayerService playerService){
        this.playerService = playerService;
    }

    @PostMapping
    public ResponseEntity<Player> createPlayer(@RequestBody Player player){
        Player p1 = playerService.createPlayer(player);
        return new ResponseEntity<>(p1, HttpStatus.CREATED);
    }

}

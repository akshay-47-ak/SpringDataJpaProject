package com.example.FirstJapCurd.controller;


import com.example.FirstJapCurd.model.Player;
import com.example.FirstJapCurd.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable Long id){
         Player p1 = playerService.getPlayerById(id);
         return new ResponseEntity<>(p1,HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Player> updatePlayer(@RequestBody Player player){
        Player p1 = playerService.updatePlayer(player);
        return new ResponseEntity<>(p1,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers(){
        List<Player> list = playerService.getAllPlayers();

        return new ResponseEntity<>(list,HttpStatus.OK);
    }

}

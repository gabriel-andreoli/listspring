package com.projetolist.listgames.controllers;

import com.projetolist.listgames.entities.GameList;
import com.projetolist.listgames.entities.dto.GameListDTO;
import com.projetolist.listgames.services.GameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/gamelists")
public class GameListController {
  @Autowired
  private GameListService gameListService;

  @GetMapping
  public List<GameListDTO> findAll(){
    List<GameListDTO> list = gameListService.findAll();
    return list;
  }
}

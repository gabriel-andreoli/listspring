package com.projetolist.listgames.services;

import com.projetolist.listgames.entities.Game;
import com.projetolist.listgames.entities.dto.GameMinDTO;
import com.projetolist.listgames.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {
  @Autowired
  private GameRepository gameRepository;

  public List<GameMinDTO> findAll(){
    return gameRepository.findAll().stream().map(GameMinDTO::new).toList();
  }
}

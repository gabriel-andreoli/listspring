package com.projetolist.listgames.services;

import com.projetolist.listgames.entities.GameList;
import com.projetolist.listgames.entities.dto.GameListDTO;
import com.projetolist.listgames.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

  @Autowired
  private GameListRepository gameListRepository;

  @Transactional(readOnly = true)
  public List<GameListDTO> findAll(){
    List<GameList> result = gameListRepository.findAll();
    return result.stream().map(GameListDTO::new).toList();
  }
}

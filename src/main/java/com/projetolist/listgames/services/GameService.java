package com.projetolist.listgames.services;

import com.projetolist.listgames.entities.Game;
import com.projetolist.listgames.entities.dto.GameDTO;
import com.projetolist.listgames.entities.dto.GameMinDTO;
import com.projetolist.listgames.projetctions.GameMinProjection;
import com.projetolist.listgames.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {
  @Autowired
  private GameRepository gameRepository;

  @Transactional(readOnly = true)
  public List<GameMinDTO> findAll(){
    return gameRepository.findAll().stream().map(GameMinDTO::new).toList();
  }

  @Transactional(readOnly = true)
  public GameDTO findById(Long id){
    Game result = gameRepository.findById(id).get();
    return new GameDTO(result);
  }

  @Transactional(readOnly = true)
  public List<GameMinDTO> findByList(Long gameListId){
    List<GameMinProjection> result = gameRepository.searchByList(gameListId);
    return result.stream().map(GameMinDTO::new).toList();
  }

}

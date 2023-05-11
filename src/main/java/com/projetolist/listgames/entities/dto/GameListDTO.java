package com.projetolist.listgames.entities.dto;

import com.projetolist.listgames.entities.GameList;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

public class GameListDTO {
  private Long id;
  private String name;

  public GameListDTO(){}
  public GameListDTO(GameList entity){
    BeanUtils.copyProperties(entity, this);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GameListDTO that = (GameListDTO) o;
    return id.equals(that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}

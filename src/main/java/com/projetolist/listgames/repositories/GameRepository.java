package com.projetolist.listgames.repositories;

import com.projetolist.listgames.entities.Game;
import com.projetolist.listgames.projetctions.GameMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {

  @Query(nativeQuery = true, value = """
		SELECT games.id, games.title, games.game_year AS `year`, games.img_url AS imgUrl,
		games.short_description AS shortDescription, game_belonging_list.position
		FROM games
		INNER JOIN game_belonging_list ON games.id = game_belonging_list.game_id
		WHERE game_belonging_list.game_list_id = :gameListId
		ORDER BY game_belonging_list.position
			""")
	List<GameMinProjection> searchByList(Long gameListId);

}

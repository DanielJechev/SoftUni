package app.repositories;

import app.domain.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface GameRepository extends JpaRepository<Game, Long> {
    Game findByTitle(String title);

    @Modifying
    @Transactional
    @Query(value = "update Game g set g.title = :title where g.id = :id")
    void updateGameTitle(@Param(value = "id") long id,@Param(value = "title")String title);

    @Modifying
    @Transactional
    @Query(value = "update Game g set g.price = :price where g.id = :id")
    void updateGamePrice(@Param(value = "id") long id,@Param(value = "price")BigDecimal price);

    @Modifying
    @Transactional
    @Query(value = "update Game g set g.trailer = :trailer where g.id = :id")
    void updateGameTrailer(@Param(value = "id") long id,@Param(value = "trailer")String trailer);

    @Modifying
    @Transactional
    @Query(value = "update Game g set g.url = :url where g.id = :id")
    void updateGameUrl(@Param(value = "id") long id,@Param(value = "url")String url);

    @Modifying
    @Transactional
    @Query(value = "update Game g set g.size = :size where g.id = :id")
    void updateGameSize(@Param(value = "id") long id,@Param(value = "size")Double size);

    @Modifying
    @Transactional
    @Query(value = "update Game g set g.description = :description where g.id = :id")
    void updateGameDescription(@Param(value = "id") long id,@Param(value = "description")String description);

    @Modifying
    @Transactional
    @Query(value = "update Game g set g.releaseDate = :releaseDate where g.id = :id")
    void updateGameReleaseDate(@Param(value = "id") long id,@Param(value = "releaseDate") LocalDate releaseDate);
}

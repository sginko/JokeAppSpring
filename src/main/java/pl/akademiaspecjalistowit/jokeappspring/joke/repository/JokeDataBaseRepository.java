package pl.akademiaspecjalistowit.jokeappspring.joke.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.akademiaspecjalistowit.jokeappspring.joke.entity.JokeEntity;

import java.util.List;

public interface JokeDataBaseRepository extends JpaRepository<JokeEntity, Long> {
    List<JokeEntity> findAllByCategory(String category);
}

package pl.akademiaspecjalistowit.jokeappspring.joke.repository;

import java.util.List;
import pl.akademiaspecjalistowit.jokeappspring.joke.model.Joke;

public interface JokeRepository {

    List<Joke> getAllJokes();

    List<Joke> getAllByCategory(String category);
}

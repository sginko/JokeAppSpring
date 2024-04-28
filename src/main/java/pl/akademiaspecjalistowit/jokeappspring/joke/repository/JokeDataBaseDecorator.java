package pl.akademiaspecjalistowit.jokeappspring.joke.repository;

import pl.akademiaspecjalistowit.jokeappspring.joke.model.Joke;

import java.util.List;

public class JokeDataBaseDecorator implements JokeRepository{
    private final JokeDataBaseRepository jokeDataBaseRepository;

    public JokeDataBaseDecorator(JokeDataBaseRepository jokeDataBaseRepository) {
        this.jokeDataBaseRepository = jokeDataBaseRepository;
    }


    @Override
    public List<Joke> getAllJokes() {
        return List.of();
    }

    @Override
    public List<Joke> getAllByCategory(String category) {
        return List.of();
    }
}

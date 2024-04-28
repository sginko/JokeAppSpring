package pl.akademiaspecjalistowit.jokeappspring.joke.repository;

import org.springframework.stereotype.Repository;
import pl.akademiaspecjalistowit.jokeappspring.joke.entity.JokeEntity;
import pl.akademiaspecjalistowit.jokeappspring.joke.mapper.JokeEntityMapper;
import pl.akademiaspecjalistowit.jokeappspring.joke.model.Joke;

import java.util.List;
import java.util.Optional;

@Repository
public class JokeDataBaseDecorator implements JokeRepository{
    private final JokeDataBaseRepository jokeDataBaseRepository;
    private final JokeEntityMapper jokeEntityMapper;

    public JokeDataBaseDecorator(JokeDataBaseRepository jokeDataBaseRepository, JokeEntityMapper jokeEntityMapper) {
        this.jokeDataBaseRepository = jokeDataBaseRepository;
        this.jokeEntityMapper = jokeEntityMapper;
    }

    public void saveJoke(Joke joke){
        jokeDataBaseRepository.save(jokeEntityMapper.toJokeEntity(joke));
    }

    @Override
    public List<Joke> findAll() {
        List<Joke> list = jokeDataBaseRepository.findAll()
                .stream()
                .map(jokeEntity -> jokeEntityMapper.toJoke(jokeEntity))
                .toList();
        return list;
    }

    @Override
    public List<Joke> findAllByCategory(String category) {
        return List.of();
    }
}

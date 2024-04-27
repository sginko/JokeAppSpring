package pl.akademiaspecjalistowit.jokeappspring.joke.dto;

import org.springframework.stereotype.Service;
import pl.akademiaspecjalistowit.jokeappspring.joke.entity.JokeEntity;
import pl.akademiaspecjalistowit.jokeappspring.joke.model.Joke;

@Service
public class JokeEntityMapper {

    public Joke jokeFromJokeEntity(JokeEntity jokeEntity){
        return new Joke(jokeEntity.getContent(), jokeEntity.getCategory());
    }

    public JokeEntity jokeEntityFromJoke(Joke joke){
        return new JokeEntity(joke.getId(), joke.getContent(), joke.getCategory());
    }
}

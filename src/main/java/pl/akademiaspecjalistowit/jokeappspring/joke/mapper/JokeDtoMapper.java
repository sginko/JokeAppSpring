package pl.akademiaspecjalistowit.jokeappspring.joke.mapper;

import pl.akademiaspecjalistowit.jokeappspring.joke.dto.JokeDto;
import pl.akademiaspecjalistowit.jokeappspring.joke.entity.JokeEntity;
import pl.akademiaspecjalistowit.jokeappspring.joke.model.Joke;

public interface JokeDtoMapper {

    static Joke toJoke(JokeDto jokeDto) {
        return new Joke(jokeDto.getSetup() + "\n" + jokeDto.getDelivery(),
                jokeDto.getCategory());
    }
}

package pl.akademiaspecjalistowit.jokeappspring.joke.service;

import pl.akademiaspecjalistowit.jokeappspring.joke.model.Joke;

public interface JokeService {

    Joke getJoke();

    Joke getJoke(String category);

    Joke addJoke(Joke joke);
}

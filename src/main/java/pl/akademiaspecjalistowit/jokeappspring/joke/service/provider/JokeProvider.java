package pl.akademiaspecjalistowit.jokeappspring.joke.service.provider;

import pl.akademiaspecjalistowit.jokeappspring.joke.model.Joke;

public interface JokeProvider {

//    void save(Joke joke);

    Joke getJoke();

    Joke getJokeByCategory(String category);
}

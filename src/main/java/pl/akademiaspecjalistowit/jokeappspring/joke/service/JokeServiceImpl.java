package pl.akademiaspecjalistowit.jokeappspring.joke.service;

import java.util.List;

import org.springframework.stereotype.Service;
import pl.akademiaspecjalistowit.jokeappspring.joke.entity.JokeEntity;
import pl.akademiaspecjalistowit.jokeappspring.joke.model.Joke;
import pl.akademiaspecjalistowit.jokeappspring.joke.repository.JokeDataBaseRepository;
import pl.akademiaspecjalistowit.jokeappspring.joke.service.provider.JokeProvider;

@Service
public class JokeServiceImpl implements JokeService {

    private final List<JokeProvider> jokeProviders;
    private final JokeDataBaseRepository jokeDataBaseRepository;
    private static long counter = 0;

    public JokeServiceImpl(List<JokeProvider> jokeProviders, JokeDataBaseRepository jokeDataBaseRepository) {
        if (jokeProviders == null || jokeProviders.isEmpty()) {
            throw new RuntimeException("Required at least one JokeProvider for the application to run");
        }
        this.jokeProviders = jokeProviders;
        this.jokeDataBaseRepository = jokeDataBaseRepository;
    }

    @Override
    public Joke getJoke() {
        return getJokeProvider().getJoke();
    }

    @Override
    public Joke getJoke(String category) {
        return getJokeProvider().getJokeByCategory(category);
    }

    @Override
    public void addJoke(JokeEntity jokeEntity) {
        jokeDataBaseRepository.save(jokeEntity);
    }

    private JokeProvider getJokeProvider() {
        return jokeProviders.get((int) counter++ % jokeProviders.size());
    }
}

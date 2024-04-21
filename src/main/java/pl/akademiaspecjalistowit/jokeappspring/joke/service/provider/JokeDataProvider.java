package pl.akademiaspecjalistowit.jokeappspring.joke.service.provider;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;
import pl.akademiaspecjalistowit.jokeappspring.joke.model.Joke;
import pl.akademiaspecjalistowit.jokeappspring.joke.repository.JokeRepository;

@Service
public class JokeDataProvider implements JokeProvider {

    private final List<JokeRepository> jokeRepositories;
    private final Random random;
    private static long counter = 0;


    public JokeDataProvider(List<JokeRepository> jokeRepositories, Random random) {
        this.jokeRepositories = jokeRepositories;
        this.random = random;
    }

    @Override
    public Joke getJoke() {
        List<Joke> anyJokes = getJokeRepository().getAllJokes();
        return anyJokes.get(random.nextInt(anyJokes.size()));
    }

    @Override
    public Joke getJokeByCategory(String category) {
        List<Joke> jokesByCategory = getJokeRepository().getAllByCategory(category);
        if (jokesByCategory.isEmpty()) {
            throw new JokeDataProviderException("No joke for this category is available");
        }
        return jokesByCategory.get(random.nextInt(jokesByCategory.size()));
    }

    private JokeRepository getJokeRepository() {
        return jokeRepositories.get((int) counter++ % jokeRepositories.size());
    }
}
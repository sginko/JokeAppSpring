package pl.akademiaspecjalistowit.jokeappspring.joke.service.provider;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;
import pl.akademiaspecjalistowit.jokeappspring.joke.mapper.JokeEntityMapper;
import pl.akademiaspecjalistowit.jokeappspring.joke.model.Joke;
import pl.akademiaspecjalistowit.jokeappspring.joke.repository.JokeDataBaseDecorator;
import pl.akademiaspecjalistowit.jokeappspring.joke.repository.JokeRepository;

@Service
public class JokeDataProvider implements JokeProvider {

    private final List<JokeRepository> repositories;
    //    private final List<JokeDataBaseRepository> jokeDataBaseRepositories;
    private final JokeEntityMapper jokeEntityMapper;
    private final Random random;
    private static long counter = 0;


//    public JokeDataProvider(List<JokeRepository> jokeRepositories, Random random) {
//        this.jokeRepositories = jokeRepositories;
//        this.random = random;
//    }

    public JokeDataProvider(List<JokeRepository> jokeRepository, JokeEntityMapper jokeEntityMapper, Random random) {
        this.repositories = jokeRepository;
        this.jokeEntityMapper = jokeEntityMapper;
        this.random = random;
    }

//    @Override
    public void save(Joke joke) {
        for (JokeRepository repository : repositories) {
            if(repository instanceof JokeDataBaseDecorator){
                ((JokeDataBaseDecorator) repository).saveJoke(joke);
            }
        }

    }

    @Override
    public Joke getJoke() {
        List<Joke> anyJokes = getJokeRepository().findAll();
        return anyJokes.get(random.nextInt(anyJokes.size()));
    }

    @Override
    public Joke getJokeByCategory(String category) {
        List<Joke> jokesByCategory = getJokeRepository().findAllByCategory(category);
        if (jokesByCategory.isEmpty()) {
            throw new JokeDataProviderException("No joke for this category is available");
        }
        return jokesByCategory.get(random.nextInt(jokesByCategory.size()));
    }

//    private JokeDataBaseRepository getJokeRepository() {
//        return jokeDataBaseRepositories.get((int) counter++ % jokeDataBaseRepositories.size());
//    }

    private JokeRepository getJokeRepository() {
        return repositories.get((int) counter++ % repositories.size());
    }
}
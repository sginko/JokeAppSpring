package pl.akademiaspecjalistowit.jokeappspring.joke.service.provider;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;
import pl.akademiaspecjalistowit.jokeappspring.joke.mapper.JokeEntityMapper;
import pl.akademiaspecjalistowit.jokeappspring.joke.entity.JokeEntity;
import pl.akademiaspecjalistowit.jokeappspring.joke.model.Joke;
import pl.akademiaspecjalistowit.jokeappspring.joke.repository.JokeDataBaseRepository;

@Service
public class JokeDataProvider implements JokeProvider {

    //    private final List<JokeRepository> jokeRepositories;
    private final List<JokeDataBaseRepository> jokeDataBaseRepositories;
    private final JokeEntityMapper jokeEntityMapper;
    private final Random random;
    private static long counter = 0;


//    public JokeDataProvider(List<JokeRepository> jokeRepositories, Random random) {
//        this.jokeRepositories = jokeRepositories;
//        this.random = random;
//    }

    public JokeDataProvider(List<JokeDataBaseRepository> jokeEntityRepositories, JokeEntityMapper jokeEntityMapper, Random random) {
        this.jokeDataBaseRepositories = jokeEntityRepositories;
        this.jokeEntityMapper = jokeEntityMapper;
        this.random = random;
    }

    @Override
    public Joke getJoke() {
        List<JokeEntity> anyJokes = getJokeRepository().findAll();
        JokeEntity jokeEntity = anyJokes.get(random.nextInt(anyJokes.size()));
        return jokeEntityMapper.toJoke(jokeEntity);
    }

    @Override
    public Joke getJokeByCategory(String category) {
        List<JokeEntity> jokesByCategory = getJokeRepository().findAllByCategory(category);
        if (jokesByCategory.isEmpty()) {
            throw new JokeDataProviderException("No joke for this category is available");
        }
        JokeEntity jokeEntity = jokesByCategory.get(random.nextInt(jokesByCategory.size()));
        return jokeEntityMapper.toJoke(jokeEntity);
    }

    private JokeDataBaseRepository getJokeRepository() {
        return jokeDataBaseRepositories.get((int) counter++ % jokeDataBaseRepositories.size());
    }

//    private JokeRepository getJokeRepository() {
//        return jokeRepositories.get((int) counter++ % jokeRepositories.size());
//    }
}
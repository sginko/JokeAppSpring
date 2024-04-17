package pl.akademiaspecjalistowit.jokeappspring;

import java.net.http.HttpClient;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JokeAppSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(JokeAppSpringApplication.class, args);
    }

    //TODO init with spring
//    private static JokeService initiateApplicationContext() {
//        List<JokeRepository> jokeRepositories = List.of(
//            new InMemoryJokeRepository(),
//            new FileJokeRepository("src/main/resources/jokes.txt"));
//
//        List<JokeProvider> jokeProviders =
//            List.of(new JokeApiProvider(HttpClient.newHttpClient()), new JokeDataProvider(jokeRepositories));
//
//        JokeService jokeService = new JokeServiceImpl(jokeProviders);
//        return jokeService;
//    }

}

package pl.akademiaspecjalistowit.jokeappspring.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import pl.akademiaspecjalistowit.jokeappspring.joke.mapper.JokeEntityMapper;
import pl.akademiaspecjalistowit.jokeappspring.joke.repository.*;
import pl.akademiaspecjalistowit.jokeappspring.joke.service.JokeService;
import pl.akademiaspecjalistowit.jokeappspring.joke.service.JokeServiceImpl;
import pl.akademiaspecjalistowit.jokeappspring.joke.service.provider.JokeApiProvider;
import pl.akademiaspecjalistowit.jokeappspring.joke.service.provider.JokeDataProvider;
import pl.akademiaspecjalistowit.jokeappspring.joke.service.provider.JokeProvider;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.List;
import java.util.Random;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public HttpClient httpClient() {
        return HttpClient.newHttpClient();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public Random random() {
        return new Random();
    }

//    @Bean
//    public JokeDataProvider jokeDataProvider(Random random,
//                                             JokeDataBaseRepository jokeDataBaseRepository,
//                                             ObjectMapper objectMapper,
//                                             JokeEntityMapper jokeEntityMapper,
//                                             @Value("${fileJokeRepository.pathToJokeFile}") String path) {
//        List<JokeRepository> jokeRepositories = List.of(new InMemoryJokeRepository(),
//                new JokeDataBaseDecorator(jokeDataBaseRepository, jokeEntityMapper),
//                new FileJokeRepository(path, objectMapper));
//        return new JokeDataProvider(jokeRepositories, jokeEntityMapper, random);
//    }


//    @Bean
//    public JokeService jokeService(HttpClient httpClient,
//                                   ObjectMapper objectMapper,
//                                   JokeDataProvider jokeDataProvider) {
//        return new JokeServiceImpl(List.of(new JokeApiProvider(httpClient, objectMapper),
//                jokeDataProvider));
//    }

//    @Bean
//    public HttpRequest requestJoke() {
//        HttpRequest build = HttpRequest.newBuilder()
//                .GET()
//                .uri(URI.create("https://v2.jokeapi.dev/joke/Any"))
//                .build();
//        return build;
//    }
}

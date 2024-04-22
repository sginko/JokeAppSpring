package pl.akademiaspecjalistowit.jokeappspring.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
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

    @Bean
    public HttpRequest requestJoke() {
        HttpRequest build = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://v2.jokeapi.dev/joke/Any"))
                .build();
        return build;
    }
}

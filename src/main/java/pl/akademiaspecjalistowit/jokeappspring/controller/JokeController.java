package pl.akademiaspecjalistowit.jokeappspring.controller;

import org.springframework.web.bind.annotation.*;
import pl.akademiaspecjalistowit.jokeappspring.joke.model.Joke;
import pl.akademiaspecjalistowit.jokeappspring.joke.service.JokeService;
import pl.akademiaspecjalistowit.jokeappspring.joke.service.JokeServiceImpl;

@RestController
@RequestMapping("/api/jokes")
public class JokeController {
    private final JokeService jokeService;

    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @GetMapping()
    public Joke getJoke() {
        return jokeService.getJoke();
    }

    @GetMapping("/category")
    public Joke getJokeByCategory(@RequestParam(name = "category", required = false) String category) {
        return jokeService.getJoke(category);
    }

//    @PostMapping
//    public void saveJoke(@RequestBody Joke joke) {
//    //jokeService.save(joke);
//        System.out.println("new joke");
//    }
}

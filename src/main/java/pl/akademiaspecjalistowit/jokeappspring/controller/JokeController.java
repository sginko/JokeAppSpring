package pl.akademiaspecjalistowit.jokeappspring.controller;

import org.springframework.web.bind.annotation.*;
import pl.akademiaspecjalistowit.jokeappspring.joke.entity.JokeEntity;
import pl.akademiaspecjalistowit.jokeappspring.joke.mapper.JokeEntityMapper;
import pl.akademiaspecjalistowit.jokeappspring.joke.model.Joke;
import pl.akademiaspecjalistowit.jokeappspring.joke.service.JokeService;

@RestController
@RequestMapping("/api/v1/jokes")
public class JokeController {
    private final JokeService jokeService;
    private final JokeEntityMapper jokeEntityMapper;

    public JokeController(JokeService jokeService, JokeEntityMapper jokeEntityMapper) {
        this.jokeService = jokeService;
        this.jokeEntityMapper = jokeEntityMapper;
    }

    @GetMapping()
    public Joke getJoke() {
        return jokeService.getJoke();
    }

    @GetMapping("/category")
    public Joke getJokeByCategory(@RequestParam(name = "category", required = false) String category) {
        return jokeService.getJoke(category);
    }

    @GetMapping("/category/{category}")
    public Joke findJokeByCategory(@PathVariable String category) {
        return jokeService.getJoke(category);
    }

    @PostMapping("/add_joke")
    public void addJoke(@RequestBody Joke joke) {
         jokeService.addJoke(jokeEntityMapper.toJokeEntity(joke));
    }
}

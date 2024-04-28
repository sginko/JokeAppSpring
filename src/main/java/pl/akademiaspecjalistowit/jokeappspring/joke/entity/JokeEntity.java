package pl.akademiaspecjalistowit.jokeappspring.joke.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter

@Entity
@Table(name = "Joke")
public class JokeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private UUID idTechnical;
    private String content;
    private String category;

    public JokeEntity(UUID idTechnical, String content, String category) {
        this.idTechnical = idTechnical;
        this.content = content;
        this.category = category;
    }
}

package pl.akademiaspecjalistowit.jokeappspring.joke.dto;

public class JokeDto {

    private String setup;
    private String delivery;
    private String category;

    private JokeDto() {
    }

    public String getSetup() {
        return setup;
    }

    public String getDelivery() {
        return delivery;
    }

    public String getCategory() {
        return category;
    }
}
package pl.akademiaspecjalistowit.jokeappspring.joke;

import java.util.InputMismatchException;
import java.util.Scanner;
import pl.akademiaspecjalistowit.jokeappspring.joke.service.JokeService;

public class JokeView {

    private final Scanner scanner;
    private final JokeService jokeService;

    public JokeView(JokeService jokeService) {
        this.scanner = new Scanner(System.in);
        this.jokeService = jokeService;
    }

    public void run() {
        int choiceFromTheUserMenu = -1;

        do {
            showUserMenu();
            try {
                choiceFromTheUserMenu = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException ex) {
                scanner.nextLine();
            }
            switch (choiceFromTheUserMenu) {
                case 1:
                    wantARandomJokeFromAnyCategory(jokeService);
                    break;
                case 0:
                    exitingTheApplication();
                    break;
                default:
                    System.out.println("Incorrect value entered!");
                    System.out.println();
            }
        } while (choiceFromTheUserMenu != 0);
        scanner.close();
    }

    private void showUserMenu() {
        System.out.println("Select further options:\n" +
            "If you want to draw a joke from any category - enter 1:\n" +
            "If you want to randomly select a joke from a specific category - enter 2:\n" +
            "Logout - enter 0:");
    }

    private void wantARandomJokeFromAnyCategory(JokeService jokeService) {
        System.out.println("I'm displaying a joke for a random category...");
        System.out.println(jokeService.getJoke());
        System.out.println();
    }

    private void exitingTheApplication() {
        System.out.println("Thank you! I hope you had fun!");
    }
}

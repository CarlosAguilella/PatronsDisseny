import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


class GuessGame {
    interface ObservadorDeEvento {
        void onWin(int tries);
    }
    List<ObservadorDeEvento> observadoresDeEvento = new ArrayList<>();

    void suscribirAEvento(ObservadorDeEvento observadorDeEvento) {
        observadoresDeEvento.add(observadorDeEvento);
    }

    void start(){
        int guess = ThreadLocalRandom.current().nextInt(10);
        Scanner scanner = new Scanner(System.in);
        int tries = 1;
        while(true) {
            int num = scanner.nextInt();
            if (num == guess) break;
            tries++;
        }
        for (ObservadorDeEvento observadorDeEvento: observadoresDeEvento) {
            observadorDeEvento.onWin(tries);
        }
    }
}


class Confetti implements GuessGame.ObservadorDeEvento {
    public void onWin(int tries) {
        System.out.println("\uD83C\uDF89".repeat(tries));
    }
}


class ScoreSaver implements GuessGame.ObservadorDeEvento{
    public void onWin(int tries) {
        try { Files.writeString(Path.of("score.txt"), "intentos:" + tries); } catch (IOException ignored) {}
    }
}

class Puntuacion implements GuessGame.ObservadorDeEvento{
    public void onWin(int tries) {
        System.out.println("El numero de intentos ha sido de: "+tries);
    }
}

public class Main {
    public static void main(String[] args) {


        Confetti confetti = new Confetti();
        ScoreSaver scoreSaver = new ScoreSaver();
        Puntuacion puntuacion = new Puntuacion();


        GuessGame guessGame = new GuessGame();

        guessGame.suscribirAEvento(confetti);
        guessGame.suscribirAEvento(scoreSaver);
        guessGame.suscribirAEvento(puntuacion);



        guessGame.start();
    }
}

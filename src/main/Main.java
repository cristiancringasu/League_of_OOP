package main;

import engine.Round;
import engine.Score;

public final class Main {

    private Main() {

    }


    public static void main(final String[] args) {
        GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
        GameInput gameInput = gameInputLoader.load();

        /**
         * homework logic
         */

        int rounds = gameInput.getRounds();
        while (rounds > 0) {
            Round.getInstance().play(gameInput);
            //Debuger.getInstance().printPlayers(gameInput);
            rounds--;
        }
        //Debuger.getInstance().printPlayers(gameInput);
        //Score.getInstance().printScore(gameInput);
        Score.getInstance().printFScore(gameInput, args[1]);
    }
}

package main;

import assets.observerAssets_.GreatMagician;
import engine.Round;
import engine.Score;
import fileio.implementations.FileWriter;

public final class Main {

    private Main() {

    }


    public static void main(final String[] args) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(args[1]);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        GreatMagician.getInstance().setFw(fw);
        GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
        GameInput gameInput = gameInputLoader.load();

        /**
         * homework logic
         */
        //4 7
        int rounds = gameInput.getRounds();
        while (rounds > 0) {
            /*
            int r = Round.getInstance().getRoundCounter();
            System.out.println("_____________ Round " + r +" _____________");
            System.out.println("Before:");
            Debuger.getInstance().printPlayers(gameInput);

             */
            Round.getInstance().play(gameInput, fw);
            /*
            System.out.println("\nAfter:");
            Debuger.getInstance().printPlayers(gameInput);
            System.out.println("-----------END ROUND--------");
            //Debuger.getInstance().printPlayers(gameInput);

             */
            rounds--;
        }
        //Debuger.getInstance().printPlayers(gameInput);
        //Score.getInstance().printScore(gameInput);
        Score.getInstance().printFScore(gameInput, fw);
    }
}

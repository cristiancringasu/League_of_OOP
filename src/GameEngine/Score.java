package GameEngine;

import fileio.implementations.FileWriter;
import gameAssets.playerAssets.Player;
import gameAssets.playerAssets.PlayerType;
import helpers.IntegerTulep;
import main.GameInput;

public class Score {
    private static Score instance = null;

    private Score(){
    }

    public static Score getInstance() {
        if(instance == null)
            instance = new Score();
        return instance;
    }

    public Character getPrintableType(Player player) {
        PlayerType type = player.getType();
        switch (type) {
            case Rogue:
                return 'R';
            case Wizard:
                return 'W';
            case Knight:
                return 'K';
            case Pyromancer:
                return 'P';
            default:
                break;
        }
        return '\0';
    }

    public void printScore(GameInput gameInput) {
        for (int index =  0; index < gameInput.getPlayersNo(); index ++) {
            Player currentPlayer = gameInput.getPlayers().get(index);
            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append(getPrintableType(currentPlayer));
            stringBuilder.append(' ');
            if(currentPlayer.getHP() <= 0) {
                stringBuilder.append("dead");
            } else {
                stringBuilder.append(currentPlayer.getLevel());
                stringBuilder.append(' ');
                stringBuilder.append(currentPlayer.getXP());
                stringBuilder.append(' ');
                stringBuilder.append(currentPlayer.getHP());
                stringBuilder.append(' ');

                IntegerTulep position = currentPlayer.getPosition();
                stringBuilder.append(position.getFirst());
                stringBuilder.append(' ');
                stringBuilder.append(position.getSecond());
                //stringBuilder.append('\n');
            }
            System.out.println(stringBuilder);
        }
    }

    public void printFScore(GameInput gameInput, final String outputPath) {
        try {
            FileWriter fw = new FileWriter(outputPath);
            //fw.writeWord("ceva");
            for (int index = 0; index < gameInput.getPlayersNo(); index++) {
                Player currentPlayer = gameInput.getPlayers().get(index);
                StringBuilder stringBuilder = new StringBuilder();

                stringBuilder.append(getPrintableType(currentPlayer));
                stringBuilder.append(' ');
                if (currentPlayer.getHP() <= 0) {
                    stringBuilder.append("dead");
                } else {
                    stringBuilder.append(currentPlayer.getLevel());
                    stringBuilder.append(' ');
                    stringBuilder.append(currentPlayer.getXP());
                    stringBuilder.append(' ');
                    stringBuilder.append(currentPlayer.getHP());
                    stringBuilder.append(' ');

                    IntegerTulep position = currentPlayer.getPosition();
                    stringBuilder.append(position.getFirst());
                    stringBuilder.append(' ');
                    stringBuilder.append(position.getSecond());
                }
                stringBuilder.append('\n');
                //if(index != gameInput.getPlayersNo() - 1)
                    //stringBuilder.append('\n');
                fw.writeWord(stringBuilder.toString());
            }
            fw.writeWord("\n");
            fw.close();
        }   catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}

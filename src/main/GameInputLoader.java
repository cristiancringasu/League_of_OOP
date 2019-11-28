package main;

import fileio.FileSystem;
import gameAssets.mapAssets.GameMap;
import gameAssets.playerAssets.Player;
import gameAssets.playerAssets.PlayerFactory;
import helpers.IntegerTulep;

import java.util.ArrayList;
import java.util.List;

public final class GameInputLoader {
    private final String mInputPath;
    private final String mOutputPath;

    GameInputLoader(final String inputPath, final String outputPath) {
        mInputPath = inputPath;
        mOutputPath = outputPath;
    }

    public GameInput load() {
        IntegerTulep size;
        List<String> movesOrder = new ArrayList<>();
        List<Player> playerOrder = new ArrayList<>();

        int rounds = 0;
        int noPlayers = 0;

        try {
            FileSystem fs = new FileSystem(mInputPath, mOutputPath);

            size = new IntegerTulep(fs.nextInt(), fs.nextInt());
            GameMap.initInstance(size);

            for (int i = 0; i < size.getFirst(); i++)
                for (int j = 0; j < size.getSecond(); j++)
                    GameMap.getInstance().setMapCellCharacter(new IntegerTulep(i,j),
                            fs.nextWord().charAt(0));


            noPlayers = fs.nextInt();
            for (int i = 0; i < noPlayers; ++i) {
                Player rookie = PlayerFactory.getInstance().newPlayer(fs.nextWord().charAt(0),
                        new IntegerTulep(fs.nextInt(), fs.nextInt()));
                playerOrder.add(rookie);
            }

            rounds = fs.nextInt();
            for (int i = 0; i < rounds; ++i) {
                movesOrder.add(fs.nextWord());
            }

            fs.close();

        } catch (Exception e1) {
            e1.printStackTrace();
        }

        return new GameInput(GameMap.getInstance(), rounds, movesOrder, playerOrder, noPlayers);
    }
}
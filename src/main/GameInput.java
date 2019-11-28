package main;

import gameAssets.mapAssets.GameMap;
import gameAssets.playerAssets.Player;

import java.util.List;

public class GameInput {
    // DO NOT MODIFY
    private final GameMap mGameMap;
    private final List<String> mMovesOrder;
    private final List<Player> mPlayersOrder;
    private int mRounds;
    private int mPlayersNo;

    public GameInput() {
        mGameMap = null;
        mMovesOrder = null;
        mPlayersOrder = null;
        mRounds = -1;
        mPlayersNo = -1;
    }

    public GameInput(final GameMap gameMap, final int rounds, final List<String> moves,
                     final List<Player> players, final int playersNo) {
        mGameMap = gameMap;
        mMovesOrder = moves;
        mPlayersOrder = players;
        mRounds = rounds;
        mPlayersNo = playersNo;
    }

    public GameMap getGameMap() {
        return mGameMap;
    }

    public final List<String> getMoves() {
        return mMovesOrder;
    }

    public final List<Player> getPlayers() {
        return mPlayersOrder;
    }

    public final int getRounds() {
        return mRounds;
    }

    public int getPlayersNo() {
        return mPlayersNo;
    }

    public final boolean isValidInput() {
        boolean membersInstantiated = mMovesOrder != null && mPlayersOrder != null;
        boolean membersNotEmpty = mMovesOrder.size() > 0 && mPlayersOrder.size() > 0 && mRounds > 0;

        return membersInstantiated && membersNotEmpty;
    }
}

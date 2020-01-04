package main;

import assets.angelsAssets_.Angel;
import assets.mapAssets_.GameMap;
import assets.playerAssets_.Player;

import java.util.ArrayList;
import java.util.List;

public final class GameInput {
    // DO NOT MODIFY
    private final GameMap mGameMap;
    private final List<String> mMovesOrder;
    private final List<Player> mPlayersOrder;
    private final ArrayList<List<Angel>> mAngelsInRoundOrder; //round -> list<angels>
    private int mRounds;
    private int mPlayersNo;

    public GameInput() {
        mGameMap = null;
        mMovesOrder = null;
        mPlayersOrder = null;
        mAngelsInRoundOrder = null;
        mRounds = -1;
        mPlayersNo = -1;
    }

    public GameInput(final GameMap gameMap, final int rounds, final List<String> moves,
                     final List<Player> players, final int playersNo,
                     final ArrayList<List<Angel>> angels) {
        mGameMap = gameMap;
        mMovesOrder = moves;
        mPlayersOrder = players;
        mAngelsInRoundOrder = angels;
        mRounds = rounds;
        mPlayersNo = playersNo;
    }

    public GameMap getGameMap() {
        return mGameMap;
    }

    public List<String> getMoves() {
        return mMovesOrder;
    }

    public List<Player> getPlayers() {
        return mPlayersOrder;
    }

    public ArrayList<List<Angel>> getAngels() {
        return mAngelsInRoundOrder;
    }

    public int getRounds() {
        return mRounds;
    }

    public int getPlayersNo() {
        return mPlayersNo;
    }

    public boolean isValidInput() {
        boolean membersInstantiated = mMovesOrder != null && mPlayersOrder != null;
        boolean membersNotEmpty = mMovesOrder.size() > 0 && mPlayersOrder.size() > 0
                && mAngelsInRoundOrder.size() > 0 && mRounds > 0;

        return membersInstantiated && membersNotEmpty;
    }
}

package engine;

import assets.abilityAssets_.PerpetualEffects;
import assets.abilityAssets_.SEffectType;
import assets.angelsAssets_.Angel;
import assets.playerAssets_.Player;
import assets.playerAssets_.PlayerType;
import assets.strategiesAssets_.DoNothingStrategy;
import fileio.implementations.FileWriter;
import helpers.IntegerTulep;
import main.GameInput;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class Round {
    private static Round instance = null;
    private int roundCounter = 0;
    private HashMap<Player, PerpetualEffects> overtimeEffects;

    private Round() {
        overtimeEffects = new HashMap<>();
    }

    public static Round getInstance() {
        if (instance == null) {
            instance = new Round();
        }
        return instance;
    }

    public int getRoundCounter() {
        return roundCounter;
    }

    public void makeMove(final Player player, final Character m) {
        if (overtimeEffects.containsKey(player)) {
            if (overtimeEffects.get(player).getEffectType() == SEffectType.Paralysis) {
                return;
            }
        }

        IntegerTulep oldPos;
        IntegerTulep newPos;

        switch (m) {
            case 'U':
                oldPos = player.getPosition();
                newPos = new IntegerTulep(oldPos.getFirst() - 1, oldPos.getSecond());
                player.setPosition(newPos);
                return;
            case 'D':
                oldPos = player.getPosition();
                newPos = new IntegerTulep(oldPos.getFirst() + 1, oldPos.getSecond());
                player.setPosition(newPos);
                return;
            case 'L':
                oldPos = player.getPosition();
                newPos = new IntegerTulep(oldPos.getFirst(), oldPos.getSecond() - 1);
                player.setPosition(newPos);
                return;
            case 'R':
                oldPos = player.getPosition();
                newPos = new IntegerTulep(oldPos.getFirst(), oldPos.getSecond() + 1);
                player.setPosition(newPos);
                return;
            case '_':
                return;

            default:
                break;
        }
    }

    public List<Player> findPlayersAtPos(final List<Player> players, final IntegerTulep position) {
        List<Player> foundPlayers = new LinkedList<>();
        for (int index =  0; index < players.size(); index++) {
            Player currentPlayer = players.get(index);
            IntegerTulep playerPosition = currentPlayer.getPosition();
            if (playerPosition.equals(position)) {
                foundPlayers.add(currentPlayer);
            }
        }
        return foundPlayers;
    }

    public void play(final GameInput gameInput, final FileWriter fw) {
        try {
            int indexedRound = roundCounter + 1;
            fw.writeWord("~~ Round " + indexedRound + " ~~\n");
            for (int index = 0; index < gameInput.getPlayersNo(); index++) {
                Player currentPlayer = gameInput.getPlayers().get(index);
                Character move = gameInput.getMoves().get(roundCounter).charAt(index);
                makeMove(currentPlayer, move);
            }
            /*
            List<Player> sEffects = new ArrayList<>(overtimeEffects.keySet());
            for (int i = 0; i < sEffects.size(); i++) {
                Player affectedPlayer = sEffects.get(i);
                PerpetualEffects effect = overtimeEffects.get(affectedPlayer);
                effect.applyEffects();
            }
            */
            for (int index = 0; index < gameInput.getPlayersNo(); index++) {
                Player currentPlayer = gameInput.getPlayers().get(index);
                if (overtimeEffects.containsKey(currentPlayer)) {
                    PerpetualEffects effect = overtimeEffects.get(currentPlayer);
                    if (overtimeEffects.get(currentPlayer)
                            .getEffectType() != SEffectType.Paralysis) {
                        effect.applyEffects();
                        currentPlayer.selectStrategy();
                    } else {
                        effect.applyEffects();
                        currentPlayer.setStrategy(new DoNothingStrategy());
                        //Dead players choose automatically DoNothingStrategy.
                    }
                } else {
                    currentPlayer.selectStrategy();
                }
                currentPlayer.playStrategy();
            }

            for (int indexI = 0; indexI < gameInput.getPlayersNo(); indexI++) {
                for (int indexJ = indexI + 1; indexJ < gameInput.getPlayersNo(); indexJ++) {
                    if (indexI == indexJ) {
                        continue;
                    }

                    Player playerI = gameInput.getPlayers().get(indexI);
                    Player playerJ = gameInput.getPlayers().get(indexJ);

                    int playerIHP = playerI.getHp();
                    int playerJHP = playerJ.getHp();

                    boolean fightAcceptance = playerIHP > 0 && playerJHP > 0;

                    if (playerI.getPosition().equals(playerJ.getPosition()) && fightAcceptance) {
                        if (playerI.getType() == PlayerType.Wizard) {
                            playerJ.fight(playerI, gameInput.getGameMap(), overtimeEffects);
                            playerI.fight(playerJ, gameInput.getGameMap(), overtimeEffects);
                        } else {
                            playerI.fight(playerJ, gameInput.getGameMap(), overtimeEffects);
                            playerJ.fight(playerI, gameInput.getGameMap(), overtimeEffects);
                        }
                        if (playerJ.getHp() <= 0) {
                            playerI.haveKilledOpponent(playerJ);
                        }

                        if (playerI.getHp() <= 0) {
                            playerJ.haveKilledOpponent(playerI);
                        }
                    }
                }
            }

            for (int index = 0; index < gameInput.getAngels().get(roundCounter).size(); index++) {
                Angel currentAngel = gameInput.getAngels().get(roundCounter).get(index);
                currentAngel.setSpawned();
                IntegerTulep angelPosition = currentAngel.getPosition();
                List<Player> foundPlayers = findPlayersAtPos(gameInput.getPlayers(), angelPosition);
                if (foundPlayers.size() > 0) {
                    for (int fplayersIndex = 0; fplayersIndex < foundPlayers.size();
                         fplayersIndex++) {
                        Player receiver = foundPlayers.get(fplayersIndex);
                        receiver.acceptAngelMain(currentAngel);
                    }
                }
            }
            fw.writeWord("\n");
            roundCounter++;
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}

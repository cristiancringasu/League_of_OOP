package GameEngine;

import gameAssets.abilityAssets.PerpetualEffects;
import gameAssets.abilityAssets.SEffectType;
import gameAssets.playerAssets.Player;
import gameAssets.playerAssets.PlayerType;
import helpers.IntegerTulep;
import main.GameInput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Round {
    private static Round instance = null;
    private int roundCounter = 0;
    private HashMap<Player, PerpetualEffects> overtimeEffects;

    private Round(){
        overtimeEffects = new HashMap<>();
    }

    public static Round getInstance() {
        if(instance == null)
            instance = new Round();
        return instance;
    }

    public void makeMove(Player player, Character m) {
        if(overtimeEffects.containsKey(player))
            if(overtimeEffects.get(player).getEffectType() == SEffectType.Paralysis)
                return;

        switch (m) {
            case 'U': {
                IntegerTulep oldPos = player.getPosition();
                IntegerTulep newPos = new IntegerTulep(oldPos.getFirst() - 1, oldPos.getSecond());
                player.setPosition(newPos);
                return;
            }
            case 'D': {
                IntegerTulep oldPos = player.getPosition();
                IntegerTulep newPos = new IntegerTulep(oldPos.getFirst() + 1, oldPos.getSecond());
                player.setPosition(newPos);
                return;
            }
            case 'L': {
                IntegerTulep oldPos = player.getPosition();
                IntegerTulep newPos = new IntegerTulep(oldPos.getFirst(), oldPos.getSecond() - 1);
                player.setPosition(newPos);
                return;
            }
            case 'R': {
                IntegerTulep oldPos = player.getPosition();
                IntegerTulep newPos = new IntegerTulep(oldPos.getFirst(), oldPos.getSecond() + 1);
                player.setPosition(newPos);
                return;
            }
            case '_':
                return;

            default:
                break;
        }
    }

    public void play(GameInput gameInput) {
        for (int index =  0; index < gameInput.getPlayersNo(); index ++) {
            Player currentPlayer = gameInput.getPlayers().get(index);
            Character move = gameInput.getMoves().get(roundCounter).charAt(index);
            makeMove(currentPlayer,move);
        }

        List<Player> sEffects = new ArrayList<>(overtimeEffects.keySet());
        for (int i = 0; i < sEffects.size(); i++) {
            Player affectedPlayer = sEffects.get(i);
            if(affectedPlayer.getHP() == 348) {
                int j = 9;
            }
            PerpetualEffects effect = overtimeEffects.get(affectedPlayer);
            effect.applyEffects();
        }

        for (int indexI =  0; indexI < gameInput.getPlayersNo(); indexI++) {
            for (int indexJ = indexI + 1; indexJ < gameInput.getPlayersNo(); indexJ++) {
                if (indexI == indexJ)
                    continue;

                Player playerI = gameInput.getPlayers().get(indexI);
                Player playerJ = gameInput.getPlayers().get(indexJ);

                int playerIHP = playerI.getHP();
                int playerJHP = playerJ.getHP();

                int fightAcceptance = playerIHP * playerJHP;

                if (playerI.getPosition().equals(playerJ.getPosition()) && fightAcceptance > 0) {
                    if (playerI.getType() == PlayerType.Wizard) {
                        playerJ.fight(playerI, gameInput.getGameMap(), overtimeEffects);
                        playerI.fight(playerJ, gameInput.getGameMap(), overtimeEffects);
                    } else {
                        playerI.fight(playerJ, gameInput.getGameMap(), overtimeEffects);
                        playerJ.fight(playerI, gameInput.getGameMap(), overtimeEffects);
                    }
                    if(playerJ.getHP() <= 0 && playerI.getHP() >= 0)
                        playerI.haveKilledOpponent(playerJ);

                    if(playerI.getHP() <= 0 && playerJ.getHP() >= 0)
                        playerJ.haveKilledOpponent(playerI);
                }
            }
        }

        roundCounter ++;
    }
}

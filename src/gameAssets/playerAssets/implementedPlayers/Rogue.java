package gameAssets.playerAssets.implementedPlayers;

import gameAssets.abilityAssets.AbilityApplier;
import gameAssets.abilityAssets.PerpetualEffects;
import gameAssets.mapAssets.GameMap;
import gameAssets.playerAssets.Player;
import gameAssets.playerAssets.PlayerType;
import helpers.IntegerTulep;

import java.util.HashMap;

public final class Rogue extends Player{
    public Rogue(IntegerTulep position) {
        super(PlayerType.Rogue, 600, 600, 40, position);
    }

    private int stabsCounter = 3;
    public void fight(Player opponent, GameMap gameMap,
                      HashMap<Player, PerpetualEffects> overtimeEffects) {
        AbilityApplier.getInstance().apply(this,opponent,
                gameMap,getPosition(),overtimeEffects,stabsCounter);
        stabsCounter ++;
        stabsCounter %= 3;
    }
}

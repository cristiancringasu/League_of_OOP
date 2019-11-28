package gameAssets.playerAssets.implementedPlayers;

import gameAssets.abilityAssets.AbilityApplier;
import gameAssets.abilityAssets.PerpetualEffects;
import gameAssets.mapAssets.GameMap;
import gameAssets.playerAssets.Player;
import gameAssets.playerAssets.PlayerType;
import helpers.IntegerTulep;

import java.util.HashMap;

public final class Pyromancer extends Player{
    public Pyromancer(IntegerTulep position) {
        super(PlayerType.Pyromancer, 500, 500, 50, position);
    }

    public void fight(Player opponent, GameMap gameMap,
                  HashMap<Player, PerpetualEffects> overtimeEffects) {
        AbilityApplier.getInstance().apply(this,opponent,
                gameMap,getPosition(),overtimeEffects);
    }
}

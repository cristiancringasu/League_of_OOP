package gameAssets.playerAssets.implementedPlayers;

import gameAssets.abilityAssets.AbilityApplier;
import gameAssets.abilityAssets.PerpetualEffects;
import gameAssets.mapAssets.GameMap;
import gameAssets.playerAssets.Player;
import gameAssets.playerAssets.PlayerType;
import helpers.IntegerTulep;

import java.util.HashMap;

public final class Wizard extends Player{
    public Wizard(IntegerTulep position) {
        super(PlayerType.Wizard, 400, 400, 30, position);
    }

    private int receivedDamage = -1;
    public int getReceivedDamage() {
        return receivedDamage;
    }
    public void prepareDamage(int damage) {
        receivedDamage = damage;
    }
    public void incrementDamage(int damage) {
        receivedDamage += damage;
    }

    public void fight(Player opponent, GameMap gameMap,
                  HashMap<Player, PerpetualEffects> overtimeEffects) {
        AbilityApplier.getInstance().apply(this,opponent,
                gameMap,getPosition(),overtimeEffects, receivedDamage);
    }
}

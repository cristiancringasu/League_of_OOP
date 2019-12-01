package assets.playerAssets_.implementedPlayers;

import assets.abilityAssets_.AbilityApplier;
import assets.abilityAssets_.PerpetualEffects;
import assets.mapAssets_.GameMap;
import assets.playerAssets_.Player;
import assets.playerAssets_.PlayerType;
import helpers.IntegerTulep;

import java.util.HashMap;

import static helpers.Constants.WIZARD_HP;
import static helpers.Constants.WIZARD_INITIAL_HP;
import static helpers.Constants.WIZARD_LEVELING_HP;
import static helpers.Constants.NULL_INTEGER;

public final class Wizard extends Player {
    public Wizard(final IntegerTulep position) {
        super(PlayerType.Wizard, WIZARD_HP, WIZARD_INITIAL_HP,
                WIZARD_LEVELING_HP, position);
    }

    private int receivedDamage = NULL_INTEGER;
    public int getReceivedDamage() {
        return receivedDamage;
    }
    public void prepareDamage(final int damage) {
        receivedDamage = damage;
    }
    public void incrementDamage(final int damage) {
        receivedDamage += damage;
    }

    public void fight(final Player opponent, final GameMap gameMap,
                      final HashMap<Player, PerpetualEffects> overtimeEffects) {
        AbilityApplier.getInstance().apply(this, opponent,
                gameMap, getPosition(), overtimeEffects, receivedDamage);
    }
}

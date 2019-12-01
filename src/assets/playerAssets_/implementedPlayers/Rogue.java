package assets.playerAssets_.implementedPlayers;

import assets.abilityAssets_.AbilityApplier;
import assets.abilityAssets_.PerpetualEffects;
import assets.mapAssets_.GameMap;
import assets.playerAssets_.Player;
import assets.playerAssets_.PlayerType;
import helpers.IntegerTulep;

import java.util.HashMap;

import static helpers.Constants.ROGUE_HP;
import static helpers.Constants.ROGUE_INITIAL_HP;
import static helpers.Constants.ROGUE_LEVELING_HP;
import static helpers.Constants.STAB_MAGIC;

public final class Rogue extends Player {

    public Rogue(final IntegerTulep position) {
        super(PlayerType.Rogue, ROGUE_HP, ROGUE_INITIAL_HP, ROGUE_LEVELING_HP, position);
    }

    private int stabsCounter = STAB_MAGIC;
    public void fight(final Player opponent, final GameMap gameMap,
                      final HashMap<Player, PerpetualEffects> overtimeEffects) {
        AbilityApplier.getInstance().apply(this, opponent,
                gameMap, getPosition(), overtimeEffects, stabsCounter);
        stabsCounter++;
        stabsCounter %= STAB_MAGIC;
    }
}

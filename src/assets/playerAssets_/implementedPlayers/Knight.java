package assets.playerAssets_.implementedPlayers;

import assets.abilityAssets_.AbilityApplier;
import assets.abilityAssets_.PerpetualEffects;
import assets.mapAssets_.GameMap;
import assets.playerAssets_.Player;
import assets.playerAssets_.PlayerType;
import helpers.IntegerTulep;

import java.util.HashMap;

import static helpers.Constants.KNIGHT_HP;
import static helpers.Constants.KNIGHT_INITIAL_HP;
import static helpers.Constants.KNIGHT_LEVELING_HP;

public final class Knight extends Player {
    public Knight(final IntegerTulep position) {
        super(PlayerType.Knight, KNIGHT_HP, KNIGHT_INITIAL_HP, KNIGHT_LEVELING_HP, position);
    }

    public void fight(final Player opponent, final GameMap gameMap,
                      final HashMap<Player, PerpetualEffects> overtimeEffects) {
        AbilityApplier.getInstance().apply(this, opponent,
                gameMap, getPosition(), overtimeEffects);
    }
}

package gameAssets.abilityAssets;

import gameAssets.mapAssets.GameMap;
import gameAssets.playerAssets.Player;
import helpers.IntegerTulep;
import java.util.HashMap;

public interface Ability {
    void applyAbility (Player transmitter, Player receiver,
                       GameMap gameMap, IntegerTulep position,
                       HashMap<Player, PerpetualEffects> overtimeEffects);
}

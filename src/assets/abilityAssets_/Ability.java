package assets.abilityAssets_;

import assets.mapAssets_.GameMap;
import assets.playerAssets_.Player;
import helpers.IntegerTulep;
import java.util.HashMap;

public interface Ability {
    void applyAbility(Player transmitter, Player receiver,
                      GameMap gameMap, IntegerTulep position,
                      HashMap<Player, PerpetualEffects> overtimeEffects);
}

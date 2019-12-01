package assets.abilityAssets_;

import assets.mapAssets_.GameMap;
import assets.playerAssets_.Player;
import helpers.IntegerTulep;

public interface SecondaryEffects {
    void applySecondaryEffects(Player transmitter, int initialLevel, Player receiver,
                               GameMap gameMap, IntegerTulep initialPosition);
}

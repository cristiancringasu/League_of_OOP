package gameAssets.abilityAssets;

import gameAssets.mapAssets.GameMap;
import gameAssets.playerAssets.Player;
import helpers.IntegerTulep;

public interface SecondaryEffects {
    void applySecondaryEffects(Player transmitter, int initialLevel, Player receiver,
                               GameMap gameMap, IntegerTulep initialPosition);
}

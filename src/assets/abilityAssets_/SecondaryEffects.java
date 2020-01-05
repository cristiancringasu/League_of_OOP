package assets.abilityAssets_;

import assets.mapAssets_.GameMap;
import assets.playerAssets_.Player;
import helpers.IntegerTulep;

public interface SecondaryEffects {
    void applySecondaryEffects(Player receiver, int initialDamage);
}

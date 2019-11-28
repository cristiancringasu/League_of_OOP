package gameAssets.abilityAssets.implementedAbilities.knightAbilities;

import gameAssets.abilityAssets.Ability;
import gameAssets.abilityAssets.Modifiers;
import gameAssets.abilityAssets.PerpetualEffects;
import gameAssets.mapAssets.GameMap;
import gameAssets.playerAssets.Player;
import helpers.IntegerTulep;

import java.util.HashMap;

public final class Execute implements Ability {
    private static Execute instance = null;
    private final int levelModifier = 30;
    private final int initialDamage = 200;
    private final float initialLimitHp = 1.2f;
    private final float levelMHp = 0.01f;
    private final float maxHp = 1.4f;

    private Execute() {}

    public void applyAbility(Player transmitter, Player receiver,
                             GameMap gameMap, IntegerTulep position,
                             HashMap<Player, PerpetualEffects> overtimeEffects) {

        long levelDamage = initialDamage + levelModifier * transmitter.getLevel();
        long damage = Math.round(levelDamage
                        * Modifiers.getInstance().getModifiers(transmitter,receiver,gameMap,0));

        float limitHpPercentage = Math.min(initialLimitHp + transmitter.getLevel() * levelMHp, maxHp);

        if(receiver.getMaxHP() * limitHpPercentage < receiver.getHP())
            receiver.receiveDamage(receiver.getHP());
        else
            receiver.receiveDamage(Math.toIntExact(damage));

    }

    public static Execute getInstance() {
        if(instance == null)
            instance = new Execute();
        return instance;
    }
}

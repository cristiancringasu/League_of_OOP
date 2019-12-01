package assets.abilityAssets_.implementedAbilities.wizardAbilities;

import assets.abilityAssets_.Ability;
import assets.abilityAssets_.Modifiers;
import assets.abilityAssets_.PerpetualEffects;
import assets.mapAssets_.GameMap;
import assets.playerAssets_.Player;
import helpers.IntegerTulep;

import java.util.HashMap;

public final class Drain implements Ability {
    private static Drain instance = null;
    private final float levelModifier = 0.05f;
    private final float initialDamage = 0.2f;
    private final float limitHp = 0.3f;

    private Drain() {

    }

    public void applyAbility(final Player transmitter, final Player receiver,
                             final GameMap gameMap, final IntegerTulep position,
                             final HashMap<Player, PerpetualEffects> overtimeEffects) {

        float baseHP = Math.min(limitHp * receiver.getMaxHP(), receiver.getHp());
        float percentageDamage = initialDamage + transmitter.getLevel() * levelModifier;
        long damage = Math.round(percentageDamage * baseHP
                * Modifiers.getInstance().getModifiers(transmitter, receiver, gameMap, 0));

        receiver.receiveDamage(Math.toIntExact(damage));
    }

    public static Drain getInstance() {
        if (instance == null) {
            instance = new Drain();
        }
        return instance;
    }
}

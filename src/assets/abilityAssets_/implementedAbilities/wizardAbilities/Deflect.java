package assets.abilityAssets_.implementedAbilities.wizardAbilities;

import assets.abilityAssets_.Ability;
import assets.abilityAssets_.Modifiers;
import assets.abilityAssets_.PerpetualEffects;
import assets.mapAssets_.GameMap;
import assets.playerAssets_.Player;
import helpers.IntegerTulep;

import java.util.HashMap;

import static helpers.Constants.NULL_INTEGER;

public final class Deflect implements Ability {
    private static Deflect instance = null;
    private final float levelModifier = 0.02f;
    private final float initialDeflected = 0.35f;
    private final float limitDefelcted = 0.7f;
    private int receivedDamage = -1;

    private Deflect() {

    }

    public void setReceivedDamage(final int receivedDamage) {
        this.receivedDamage = receivedDamage;
    }

    public void applyAbility(final Player transmitter, final Player receiver,
                             final GameMap gameMap, final IntegerTulep position,
                             final HashMap<Player, PerpetualEffects> overtimeEffects) {

        if (receivedDamage == NULL_INTEGER) {
            return;
        }

        float currentDeflected = initialDeflected + transmitter.getLevel() * levelModifier;
        float maxDeflected = Math.min(limitDefelcted, currentDeflected);

        long damage = Math.round(maxDeflected * receivedDamage
                * Modifiers.getInstance().getModifiers(transmitter, receiver, gameMap, 1));

        receiver.receiveDamage(Math.toIntExact(damage));
    }

    public static Deflect getInstance() {
        if (instance == null) {
            instance = new Deflect();
        }
        return instance;
    }
}

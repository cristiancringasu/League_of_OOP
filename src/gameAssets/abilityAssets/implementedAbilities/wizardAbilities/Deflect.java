package gameAssets.abilityAssets.implementedAbilities.wizardAbilities;

import gameAssets.abilityAssets.Ability;
import gameAssets.abilityAssets.Modifiers;
import gameAssets.abilityAssets.PerpetualEffects;
import gameAssets.mapAssets.GameMap;
import gameAssets.playerAssets.Player;
import helpers.IntegerTulep;

import java.util.HashMap;

public final class Deflect implements Ability {
    private static Deflect instance = null;
    private final float levelModifier = 0.02f;
    private final float initialDeflected = 0.35f;
    private final float limitDefelcted = 0.7f;
    private int receivedDamage = -1;

    private Deflect() {}

    public void setReceivedDamage(int receivedDamage) {
        this.receivedDamage = receivedDamage;
    }

    public void applyAbility(Player transmitter, Player receiver,
                             GameMap gameMap, IntegerTulep position,
                             HashMap<Player, PerpetualEffects> overtimeEffects) {

        if(receivedDamage == -1)
            return;

        float currentDeflected = initialDeflected + transmitter.getLevel() * levelModifier;
        float maxDeflected = Math.min(limitDefelcted, currentDeflected);

        long damage = Math.round(maxDeflected * receivedDamage
                * Modifiers.getInstance().getModifiers(transmitter,receiver,gameMap,1));

        receiver.receiveDamage(Math.toIntExact(damage));
    }

    public static Deflect getInstance() {
        if(instance == null)
            instance = new Deflect();
        return instance;
    }
}

package gameAssets.abilityAssets.implementedAbilities.wizardAbilities;

import gameAssets.abilityAssets.Ability;
import gameAssets.abilityAssets.Modifiers;
import gameAssets.abilityAssets.PerpetualEffects;
import gameAssets.mapAssets.GameMap;
import gameAssets.playerAssets.Player;
import helpers.IntegerTulep;

import java.util.HashMap;

public final class Drain implements Ability {
    private static Drain instance = null;
    private final float levelModifier = 0.05f;
    private final float initialDamage = 0.2f;
    private final float limitHp = 0.3f;

    private Drain() {}

    public void applyAbility(Player transmitter, Player receiver,
                             GameMap gameMap, IntegerTulep position,
                             HashMap<Player, PerpetualEffects> overtimeEffects) {

        float baseHP = Math.min(limitHp * receiver.getMaxHP(), receiver.getHP());
        float percentageDamage = initialDamage + transmitter.getLevel() * levelModifier;
        long damage = Math.round(percentageDamage * baseHP
                * Modifiers.getInstance().getModifiers(transmitter,receiver,gameMap,0));

        receiver.receiveDamage(Math.toIntExact(damage));
    }

    public static Drain getInstance() {
        if(instance == null)
            instance = new Drain();
        return instance;
    }
}

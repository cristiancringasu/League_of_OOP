package gameAssets.abilityAssets.implementedAbilities.knightAbilities;

import gameAssets.abilityAssets.Ability;
import gameAssets.abilityAssets.Modifiers;
import gameAssets.abilityAssets.PerpetualEffects;
import gameAssets.abilityAssets.SEffectType;
import gameAssets.abilityAssets.SecondaryEffects;
import gameAssets.mapAssets.GameMap;
import gameAssets.playerAssets.Player;
import helpers.IntegerTulep;

import java.util.HashMap;

public final class Slam implements Ability, SecondaryEffects {
    private static Slam instance = null;
    private final int levelModifier = 40;
    private final int initialDamage = 100;
    private final int roundsToEndure = 1;

    private Slam() {}

    public void applyAbility(Player transmitter, Player receiver,
                             GameMap gameMap, IntegerTulep position,
                             HashMap<Player, PerpetualEffects> overtimeEffects) {

        long levelDamage = initialDamage + levelModifier * transmitter.getLevel();
        long damage = Math.round(levelDamage
                * Modifiers.getInstance().getModifiers(transmitter,receiver,gameMap,1));

        receiver.receiveDamage(Math.toIntExact(damage));

        overtimeEffects.put(receiver,
                new PerpetualEffects(transmitter,transmitter.getLevel(),receiver,
                gameMap,position,this,roundsToEndure, SEffectType.Paralysis));
    }

    public void applySecondaryEffects(Player transmitter, int initialLevel, Player receiver,
                                      GameMap gameMap, IntegerTulep initialPosition) {
        //Dummy
        return;
    }

    public static Slam getInstance() {
        if(instance == null)
            instance = new Slam();
        return instance;
    }
}

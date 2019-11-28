package gameAssets.abilityAssets.implementedAbilities.rogueAbilities;

import gameAssets.abilityAssets.Ability;
import gameAssets.abilityAssets.Modifiers;
import gameAssets.abilityAssets.PerpetualEffects;
import gameAssets.abilityAssets.SEffectType;
import gameAssets.abilityAssets.SecondaryEffects;
import gameAssets.mapAssets.LandType;
import gameAssets.mapAssets.GameMap;
import gameAssets.playerAssets.Player;
import helpers.IntegerTulep;

import java.util.HashMap;

public final class Paralysis implements Ability, SecondaryEffects {
    private static Paralysis instance = null;
    private final int levelModifier = 10;
    private final int initialDamage = 40;
    private final int subroundDamage = 40;
    private final int subroundLModifier = 10;
    private final int roundsToEndure = 3;
    private final int bonusLandOvertime = 3;
    private Paralysis() {}

    public void applyAbility(Player transmitter, Player receiver,
                             GameMap gameMap, IntegerTulep position,
                             HashMap<Player, PerpetualEffects> overtimeEffects) {

        long levelDamage = initialDamage + levelModifier * transmitter.getLevel();
        long damage = Math.round(levelDamage
                * Modifiers.getInstance().getModifiers(transmitter,receiver,gameMap,1));

        receiver.receiveDamage(Math.toIntExact(damage));

        overtimeEffects.put(receiver,
                new PerpetualEffects(transmitter,transmitter.getLevel(),receiver,
                gameMap,position,this,
                        roundsToEndure +
                         (gameMap.getMapCell(position) == LandType.Land ? bonusLandOvertime : 0)
                         , SEffectType.Paralysis));
    }

    public void applySecondaryEffects(Player transmitter, int initialLevel, Player receiver,
                                      GameMap gameMap, IntegerTulep initialPosition) {

        long levelDamage = subroundDamage + subroundLModifier * initialLevel;
        long damage = Math.round(levelDamage
                * Modifiers.getInstance().
                getModifiersW_POS(transmitter,receiver,gameMap,initialPosition,1));

        receiver.receiveDamage(Math.toIntExact(damage));
    }

    public static Paralysis getInstance() {
        if(instance == null)
            instance = new Paralysis();
        return instance;
    }
}

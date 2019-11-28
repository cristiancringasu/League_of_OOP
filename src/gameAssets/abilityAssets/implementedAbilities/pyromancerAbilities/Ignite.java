package gameAssets.abilityAssets.implementedAbilities.pyromancerAbilities;

import gameAssets.abilityAssets.Ability;
import gameAssets.abilityAssets.Modifiers;
import gameAssets.abilityAssets.SecondaryEffects;
import gameAssets.abilityAssets.PerpetualEffects;
import gameAssets.mapAssets.GameMap;
import gameAssets.playerAssets.Player;
import gameAssets.playerAssets.PlayerType;
import helpers.IntegerTulep;

import java.util.HashMap;

public final class Ignite implements Ability, SecondaryEffects {
    private static Ignite instance = null;
    private final int levelModifier = 20;
    private final int initialDamage = 150;
    private final int subroundDamage = 50;
    private final int subroundLModifier = 50;
    private final int roundsToEndure = 2;

    private Ignite() {}

    public void applyAbility(Player transmitter, Player receiver,
                             GameMap gameMap, IntegerTulep position,
                             HashMap<Player, PerpetualEffects> overtimeEffects) {

        long damage = Math.round(initialDamage * transmitter.getLevel()
                        * Modifiers.getInstance().getLandModifiers()
                        .get(PlayerType.Pyromancer).get(gameMap.getMapCell(position))
                        * Modifiers.getInstance().getRaceModifiers()
                        .get(PlayerType.Pyromancer).get(1).get(receiver.getType()));

        receiver.receiveDamage(Math.toIntExact(damage));

        overtimeEffects.put(receiver,
                new PerpetualEffects(transmitter,transmitter.getLevel(),receiver,
                gameMap,position,this,roundsToEndure));
    }

    public void applySecondaryEffects(Player transmitter, int initialLevel, Player receiver,
                                      GameMap gameMap, IntegerTulep initialPosition) {

        long levelDamage = subroundDamage + subroundLModifier * initialLevel;
        long damage = Math.round(levelDamage
                * Modifiers.getInstance().
                getModifiersW_POS(transmitter,receiver,gameMap,initialPosition,1));

        receiver.receiveDamage(Math.toIntExact(damage));
    }

    public static Ignite getInstance() {
        if(instance == null)
            instance = new Ignite();
        return instance;
    }
}

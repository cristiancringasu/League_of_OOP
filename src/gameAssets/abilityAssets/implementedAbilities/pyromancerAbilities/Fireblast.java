package gameAssets.abilityAssets.implementedAbilities.pyromancerAbilities;

import gameAssets.abilityAssets.Ability;
import gameAssets.abilityAssets.Modifiers;
import gameAssets.abilityAssets.PerpetualEffects;
import gameAssets.mapAssets.GameMap;
import gameAssets.playerAssets.Player;
import gameAssets.playerAssets.PlayerType;
import gameAssets.playerAssets.implementedPlayers.Wizard;
import helpers.IntegerTulep;

import java.util.HashMap;

public final class Fireblast implements Ability {
    private static Fireblast instance = null;
    private final int levelModifier = 50;
    private final int initialDamage = 350;

    private Fireblast() {}

    public void applyAbility(Player transmitter, Player receiver,
                             GameMap gameMap, IntegerTulep position,
                             HashMap<Player, PerpetualEffects> overtimeEffects) {

        long levelDamage = initialDamage + levelModifier * transmitter.getLevel();
        long damage = Math.round(levelDamage
                * Modifiers.getInstance().getModifiers(transmitter,receiver,gameMap,0));

        receiver.receiveDamage(Math.toIntExact(damage));



        if(receiver.getType() == PlayerType.Wizard) {
            long wizardDamage = Math.round(levelDamage *
                    Modifiers.getInstance().getLandModifiers().
                            get(transmitter.getType()).get(gameMap.getMapCell(position)));

            Wizard harry = (Wizard) receiver;
            if(harry.getReceivedDamage() == -1)
                harry.prepareDamage(Math.toIntExact(wizardDamage));
            else
                harry.incrementDamage(Math.toIntExact(wizardDamage));
        }

    }

    public static Fireblast getInstance() {
        if(instance == null)
            instance = new Fireblast();
        return instance;
    }
}

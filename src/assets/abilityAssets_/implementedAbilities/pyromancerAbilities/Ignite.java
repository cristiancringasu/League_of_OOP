package assets.abilityAssets_.implementedAbilities.pyromancerAbilities;

import assets.abilityAssets_.Ability;
import assets.abilityAssets_.Modifiers;
import assets.abilityAssets_.SEffectType;
import assets.abilityAssets_.SecondaryEffects;
import assets.abilityAssets_.PerpetualEffects;
import assets.mapAssets_.GameMap;
import assets.playerAssets_.Player;
import assets.playerAssets_.PlayerType;
import assets.playerAssets_.implementedPlayers.Wizard;
import helpers.IntegerTulep;

import java.util.HashMap;

public final class Ignite implements Ability, SecondaryEffects {
    private static Ignite instance = null;
    private final int levelModifier = 20;
    private final int initialDamage = 150;
    private final int subroundDamage = 50;
    private final int subroundLModifier = 50;
    private final int roundsToEndure = 2;

    private Ignite() {

    }

    public void applyAbility(final Player transmitter, final Player receiver,
                             final GameMap gameMap, final IntegerTulep position,
                             final HashMap<Player, PerpetualEffects> overtimeEffects) {

        long levelDamage = initialDamage + levelModifier * transmitter.getLevel();
        long damage = Math.round(levelDamage
                * Modifiers.getInstance().getModifiers(transmitter, receiver, gameMap, 1));

        receiver.receiveDamage(Math.toIntExact(damage));

        overtimeEffects.put(receiver,
                new PerpetualEffects(transmitter, receiver,
                gameMap, this, roundsToEndure, SEffectType.Damage));



        if (receiver.getType() == PlayerType.Wizard) {
            long wizardDamage = Math.round(levelDamage
                    * Modifiers.getInstance().getLandModifiers().
                    get(transmitter.getType()).get(gameMap.getMapCell(position)));

            Wizard harry = (Wizard) receiver;
            if (harry.getReceivedDamage() == -1) {
                harry.prepareDamage(Math.toIntExact(wizardDamage));
            } else {
                harry.incrementDamage(Math.toIntExact(wizardDamage));
            }
        }
    }

    public void applySecondaryEffects(final Player transmitter, final int initialLevel,
                                      final Player receiver,
                                      final GameMap gameMap, final IntegerTulep initialPosition) {

        long levelDamage = subroundDamage + subroundLModifier * initialLevel;
        long damage = Math.round(levelDamage
                * Modifiers.getInstance().
                getModifiersWPOS(transmitter, receiver, gameMap, initialPosition, 1));

        receiver.receiveDamage(Math.toIntExact(damage));
    }

    public static Ignite getInstance() {
        if (instance == null) {
            instance = new Ignite();
        }
        return instance;
    }
}

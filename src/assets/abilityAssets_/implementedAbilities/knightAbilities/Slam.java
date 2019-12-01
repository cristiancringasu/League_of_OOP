package assets.abilityAssets_.implementedAbilities.knightAbilities;

import assets.abilityAssets_.Ability;
import assets.abilityAssets_.Modifiers;
import assets.abilityAssets_.PerpetualEffects;
import assets.abilityAssets_.SEffectType;
import assets.abilityAssets_.SecondaryEffects;
import assets.mapAssets_.GameMap;
import assets.playerAssets_.Player;
import assets.playerAssets_.PlayerType;
import assets.playerAssets_.implementedPlayers.Wizard;
import helpers.IntegerTulep;

import java.util.HashMap;

public final class Slam implements Ability, SecondaryEffects {
    private static Slam instance = null;
    private final int levelModifier = 40;
    private final int initialDamage = 100;
    private final int roundsToEndure = 1;

    private Slam() {

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
                gameMap, this, roundsToEndure, SEffectType.Paralysis));



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
        //Dummy
        return;
    }

    public static Slam getInstance() {
        if (instance == null) {
            instance = new Slam();
        }
        return instance;
    }
}

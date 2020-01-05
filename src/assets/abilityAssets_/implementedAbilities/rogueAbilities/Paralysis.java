package assets.abilityAssets_.implementedAbilities.rogueAbilities;

import assets.abilityAssets_.Ability;
import assets.abilityAssets_.Modifiers;
import assets.abilityAssets_.PerpetualEffects;
import assets.abilityAssets_.SEffectType;
import assets.abilityAssets_.SecondaryEffects;
import assets.mapAssets_.LandType;
import assets.mapAssets_.GameMap;
import assets.playerAssets_.Player;
import assets.playerAssets_.PlayerType;
import assets.playerAssets_.implementedPlayers.Wizard;
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
    private Paralysis() {

    }

    public void applyAbility(final Player transmitter, final Player receiver,
                             final GameMap gameMap, final IntegerTulep position,
                             final HashMap<Player, PerpetualEffects> overtimeEffects) {

        long levelDamage = initialDamage + levelModifier * transmitter.getLevel();
        long damage = Math.round(levelDamage
                * Modifiers.getInstance().getModifiers(transmitter, receiver, gameMap, 1));

        receiver.receiveDamage(Math.toIntExact(damage));

        long subLevelDamage = subroundDamage + subroundLModifier * transmitter.getLevel();
        long subDamage = Math.round(subLevelDamage
                * Modifiers.getInstance().getModifiers(transmitter, receiver, gameMap, 1));

        overtimeEffects.put(receiver,
                new PerpetualEffects(receiver, Math.toIntExact(subDamage), this,
                 roundsToEndure
                         + (gameMap.getMapCell(position) == LandType.Woods ? bonusLandOvertime : 0),
                         SEffectType.Paralysis));



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

    public void applySecondaryEffects(final Player receiver, final int overtimeDamage) {
        receiver.receiveDamage(overtimeDamage);
    }

    public static Paralysis getInstance() {
        if (instance == null) {
            instance = new Paralysis();
        }
        return instance;
    }
}

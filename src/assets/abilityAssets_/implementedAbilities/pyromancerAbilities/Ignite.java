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
    private final int subroundLModifier = 30;
    private final int roundsToEndure = 2;

    private Ignite() {

    }

    public void applyAbility(final Player transmitter, final Player receiver,
                             final GameMap gameMap, final IntegerTulep position,
                             final HashMap<Player, PerpetualEffects> overtimeEffects) {

        long levelDamage = initialDamage + levelModifier * transmitter.getLevel();
        //Got lazy to implement it for the other abilities.. :(
        Float landMod = Modifiers.getInstance().getLandModifiers()
                .get(transmitter.getType()).get(gameMap.getMapCell(position));
        long damage = Math.round(Math.round(levelDamage
                * landMod)
                * Modifiers.getInstance().getRaceModWthSelfMod(transmitter, receiver, 1));

        receiver.receiveDamage(Math.toIntExact(damage));

        long subLevelDamage = subroundDamage + subroundLModifier * transmitter.getLevel();
        long subDamage = Math.round(Math.round(subLevelDamage
                * landMod)
                * Modifiers.getInstance().getRaceModWthSelfMod(transmitter, receiver, 1));

        overtimeEffects.put(receiver,
                new PerpetualEffects(receiver, Math.toIntExact(subDamage), this,
                        roundsToEndure, SEffectType.Damage));



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

    public static Ignite getInstance() {
        if (instance == null) {
            instance = new Ignite();
        }
        return instance;
    }
}

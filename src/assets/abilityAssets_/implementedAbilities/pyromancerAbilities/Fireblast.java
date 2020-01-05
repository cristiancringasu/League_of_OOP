package assets.abilityAssets_.implementedAbilities.pyromancerAbilities;

import assets.abilityAssets_.Ability;
import assets.abilityAssets_.Modifiers;
import assets.abilityAssets_.PerpetualEffects;
import assets.mapAssets_.GameMap;
import assets.playerAssets_.Player;
import assets.playerAssets_.PlayerType;
import assets.playerAssets_.implementedPlayers.Wizard;
import helpers.IntegerTulep;

import java.util.HashMap;

public final class Fireblast implements Ability {
    private static Fireblast instance = null;
    private final int levelModifier = 50;
    private final int initialDamage = 350;

    private Fireblast() {

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
                * Modifiers.getInstance().getRaceModWthSelfMod(transmitter, receiver, 0));

        receiver.receiveDamage(Math.toIntExact(damage));



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

    public static Fireblast getInstance() {
        if (instance == null) {
            instance = new Fireblast();
        }
        return instance;
    }
}

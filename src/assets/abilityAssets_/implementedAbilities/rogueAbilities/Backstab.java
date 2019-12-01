package assets.abilityAssets_.implementedAbilities.rogueAbilities;

import assets.abilityAssets_.Ability;
import assets.abilityAssets_.Modifiers;
import assets.abilityAssets_.PerpetualEffects;
import assets.mapAssets_.LandType;
import assets.mapAssets_.GameMap;
import assets.playerAssets_.Player;
import assets.playerAssets_.PlayerType;
import assets.playerAssets_.implementedPlayers.Wizard;
import helpers.IntegerTulep;

import java.util.HashMap;

import static helpers.Constants.STAB_MAGIC;

public final class Backstab implements Ability {
    private static Backstab instance = null;
    private final int levelModifier = 20;
    private final int initialDamage = 200;
    private int stabsCounter = -1;
    private final float criticalBonus = 0.5f;

    private Backstab() {

    }

    public void setStabsCounter(final int stabsCounter) {
        this.stabsCounter = stabsCounter;
    }

    public void applyAbility(final Player transmitter, final Player receiver,
                             final GameMap gameMap, final IntegerTulep position,
                             final HashMap<Player, PerpetualEffects> overtimeEffects) {

        float critical;
        if (gameMap.getMapCell(position) == LandType.Woods) {
            critical = (stabsCounter == STAB_MAGIC ? 1 : 0) * criticalBonus + 1.0f;
        } else {
            critical = 1.0f;
        }

        long levelDamage = initialDamage + levelModifier * transmitter.getLevel();
        long damage = Math.round(levelDamage * critical
                * Modifiers.getInstance().getModifiers(transmitter, receiver, gameMap, 0));

        receiver.receiveDamage(Math.toIntExact(damage));



        if (receiver.getType() == PlayerType.Wizard) {
            long wizardDamage = Math.round(levelDamage * critical
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

    public static Backstab getInstance() {
        if (instance == null) {
            instance = new Backstab();
        }
        return instance;
    }
}

package assets.abilityAssets_.implementedAbilities.knightAbilities;

import assets.abilityAssets_.Ability;
import assets.abilityAssets_.Modifiers;
import assets.abilityAssets_.PerpetualEffects;
import assets.mapAssets_.GameMap;
import assets.playerAssets_.Player;
import assets.playerAssets_.PlayerType;
import assets.playerAssets_.implementedPlayers.Wizard;
import helpers.IntegerTulep;

import java.util.HashMap;

public final class Execute implements Ability {
    private static Execute instance = null;
    private final int levelModifier = 30;
    private final int initialDamage = 200;
    private final float initialLimitHp = 1.2f;
    private final float levelMHp = 0.01f;
    private final float maxHp = 1.4f;

    private Execute() {

    }

    public void applyAbility(final Player transmitter, final Player receiver,
                             final GameMap gameMap, final IntegerTulep position,
                             final HashMap<Player, PerpetualEffects> overtimeEffects) {

        long levelDamage = initialDamage + levelModifier * transmitter.getLevel();
        long damage = Math.round(levelDamage
                        * Modifiers.getInstance().getModifiers(transmitter,
                receiver, gameMap, 0));

        float limitHpPercentage = Math.min(initialLimitHp + transmitter.getLevel() * levelMHp,
                maxHp);

        if (receiver.getMaxHP() * limitHpPercentage < receiver.getHp()) {
            receiver.receiveDamage(receiver.getHp());
        } else {
            receiver.receiveDamage(Math.toIntExact(damage));
        }




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

    public static Execute getInstance() {
        if (instance == null) {
            instance = new Execute();
        }
        return instance;
    }
}

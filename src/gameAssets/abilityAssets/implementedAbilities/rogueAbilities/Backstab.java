package gameAssets.abilityAssets.implementedAbilities.rogueAbilities;

import gameAssets.abilityAssets.Ability;
import gameAssets.abilityAssets.Modifiers;
import gameAssets.abilityAssets.PerpetualEffects;
import gameAssets.mapAssets.LandType;
import gameAssets.mapAssets.GameMap;
import gameAssets.playerAssets.Player;
import helpers.IntegerTulep;

import java.util.HashMap;

public final class Backstab implements Ability {
    private static Backstab instance = null;
    private final int levelModifier = 20;
    private final int initialDamage = 200;
    private int stabsCounter = -1;
    private final float criticalBonus = 0.5f;

    private Backstab() {}

    public void setStabsCounter(int stabsCounter) {
        this.stabsCounter = stabsCounter;
    }

    public void applyAbility(Player transmitter, Player receiver,
                             GameMap gameMap, IntegerTulep position,
                             HashMap<Player, PerpetualEffects> overtimeEffects) {

        float critical;
        if (gameMap.getMapCell(position) == LandType.Woods)
            critical = (stabsCounter == 3 ? 1 : 0) * criticalBonus + 1.0f;
        else
            critical = 1.0f;

        long levelDamage = initialDamage + levelModifier * transmitter.getLevel();
        long damage = Math.round(levelDamage
                * Modifiers.getInstance().getModifiers(transmitter,receiver,gameMap,0));

        receiver.receiveDamage(Math.toIntExact(damage));
    }

    public static Backstab getInstance() {
        if(instance == null)
            instance = new Backstab();
        return instance;
    }
}
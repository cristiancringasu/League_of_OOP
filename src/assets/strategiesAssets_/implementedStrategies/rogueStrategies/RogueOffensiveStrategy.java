package assets.strategiesAssets_.implementedStrategies.rogueStrategies;

import assets.playerAssets_.Player;
import assets.strategiesAssets_.PlayerStrategy;

import static helpers.Constants.FIRST_ABILITY;
import static helpers.Constants.SECOND_ABILITY;
import static helpers.Constants.ST_A_ROGUE_HP_PER;
import static helpers.Constants.ST_A_ROGUE_MODIFICATION;

public final class RogueOffensiveStrategy implements PlayerStrategy {
    @Override
    public void applyStrategy(final Player invoker) {
        int currentHP = invoker.getHp();
        invoker.receiveDamage(currentHP / ST_A_ROGUE_HP_PER);
        invoker.setSelfModifiers(FIRST_ABILITY, ST_A_ROGUE_MODIFICATION);
        invoker.setSelfModifiers(SECOND_ABILITY, ST_A_ROGUE_MODIFICATION);
    }
}

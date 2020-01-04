package assets.strategiesAssets_.implementedStrategies.rogueStrategies;

import assets.playerAssets_.Player;
import assets.strategiesAssets_.PlayerStrategy;

import static helpers.Constants.FIRST_ABILITY;
import static helpers.Constants.SECOND_ABILITY;
import static helpers.Constants.ST_D_PYROMANCER_HP_PER;
import static helpers.Constants.ST_D_PYROMANCER_MODIFICATION;
import static helpers.Constants.ST_D_ROGUE_HP_PER;
import static helpers.Constants.ST_D_ROGUE_MODIFICATION;

public class RogueDeffensiveStrategy implements PlayerStrategy {
    @Override
    public void applyStrategy(final Player invoker) {
        int currentHP = invoker.getHp();
        invoker.receiveHP(currentHP / ST_D_ROGUE_HP_PER);
        invoker.setSelfModifiers(FIRST_ABILITY, ST_D_ROGUE_MODIFICATION);
        invoker.setSelfModifiers(SECOND_ABILITY, ST_D_ROGUE_MODIFICATION);
    }
}

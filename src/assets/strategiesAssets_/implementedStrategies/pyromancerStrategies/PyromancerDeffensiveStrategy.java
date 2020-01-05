package assets.strategiesAssets_.implementedStrategies.pyromancerStrategies;

import assets.playerAssets_.Player;
import assets.strategiesAssets_.PlayerStrategy;

import static helpers.Constants.FIRST_ABILITY;
import static helpers.Constants.SECOND_ABILITY;
import static helpers.Constants.ST_D_PYROMANCER_HP_PER;
import static helpers.Constants.ST_D_PYROMANCER_MODIFICATION;

public final class PyromancerDeffensiveStrategy implements PlayerStrategy {
    @Override
    public void applyStrategy(final Player invoker) {
        int currentHP = invoker.getHp();
        invoker.receiveHP(currentHP / ST_D_PYROMANCER_HP_PER);
        invoker.setSelfModifiers(FIRST_ABILITY, ST_D_PYROMANCER_MODIFICATION);
        invoker.setSelfModifiers(SECOND_ABILITY, ST_D_PYROMANCER_MODIFICATION);
    }
}

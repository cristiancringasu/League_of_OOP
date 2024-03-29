package assets.strategiesAssets_.implementedStrategies.knightStrategies;

import assets.playerAssets_.Player;
import assets.strategiesAssets_.PlayerStrategy;

import static helpers.Constants.FIRST_ABILITY;
import static helpers.Constants.SECOND_ABILITY;
import static helpers.Constants.ST_D_KNIGHT_MODIFICATION;
import static helpers.Constants.ST_D_KNIGHT_HP_PER;

public final class KnightDeffensiveStrategy implements PlayerStrategy {
    @Override
    public void applyStrategy(final Player invoker) {
        int currentHP = invoker.getHp();
        invoker.receiveHP(currentHP / ST_D_KNIGHT_HP_PER);
        invoker.setSelfModifiers(FIRST_ABILITY, ST_D_KNIGHT_MODIFICATION);
        invoker.setSelfModifiers(SECOND_ABILITY, ST_D_KNIGHT_MODIFICATION);
    }
}

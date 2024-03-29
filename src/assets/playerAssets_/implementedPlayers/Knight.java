package assets.playerAssets_.implementedPlayers;

import assets.abilityAssets_.AbilityApplier;
import assets.abilityAssets_.PerpetualEffects;
import assets.angelsAssets_.Angel;
import assets.angelsAssets_.DispatchPlayerSelector;
import assets.mapAssets_.GameMap;
import assets.playerAssets_.Player;
import assets.playerAssets_.PlayerType;
import assets.strategiesAssets_.DoNothingStrategy;
import assets.strategiesAssets_.implementedStrategies.knightStrategies.KnightDeffensiveStrategy;
import assets.strategiesAssets_.implementedStrategies.knightStrategies.KnightOffensiveStrategy;
import helpers.IntegerTulep;

import java.util.HashMap;

import static helpers.Constants.KNIGHT_HP;
import static helpers.Constants.KNIGHT_INITIAL_HP;
import static helpers.Constants.KNIGHT_LEVELING_HP;
import static helpers.Constants.ST_HIGH_BOUND_KNIGHT_HP_PER;
import static helpers.Constants.ST_LOW_BOUND_KNIGHT_HP_PER;

public final class Knight extends Player {
    public Knight(final IntegerTulep position) {
        super(PlayerType.Knight, KNIGHT_HP, KNIGHT_INITIAL_HP, KNIGHT_LEVELING_HP, position);
    }

    public void fight(final Player opponent, final GameMap gameMap,
                      final HashMap<Player, PerpetualEffects> overtimeEffects) {
        AbilityApplier.getInstance().apply(this, opponent,
                gameMap, getPosition(), overtimeEffects);
    }

    @Override
    public void acceptAngel(final Angel angel)  {
        DispatchPlayerSelector.selectApply(this, angel);
        //Pseudo-DoubleDispatch
    }

    @Override
    public void selectStrategy() {
        int currentHP = getHp();
        int maxHP = getMaxHP();
        if (currentHP > maxHP / ST_LOW_BOUND_KNIGHT_HP_PER
                && currentHP < maxHP / ST_HIGH_BOUND_KNIGHT_HP_PER) {
            setStrategy(new KnightOffensiveStrategy());
            return;
        }
        if (currentHP < maxHP / ST_LOW_BOUND_KNIGHT_HP_PER && currentHP > 0) {
            setStrategy(new KnightDeffensiveStrategy());
            return;
        }
        setStrategy(new DoNothingStrategy());
    }

    @Override
    public String getName() {
        return "Knight " + getID();
    }
}

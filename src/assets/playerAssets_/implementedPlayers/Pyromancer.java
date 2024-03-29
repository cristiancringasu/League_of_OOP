package assets.playerAssets_.implementedPlayers;

import assets.abilityAssets_.AbilityApplier;
import assets.abilityAssets_.PerpetualEffects;
import assets.angelsAssets_.Angel;
import assets.angelsAssets_.DispatchPlayerSelector;
import assets.mapAssets_.GameMap;
import assets.playerAssets_.Player;
import assets.playerAssets_.PlayerType;
import assets.strategiesAssets_.DoNothingStrategy;
import assets.strategiesAssets_.implementedStrategies.pyromancerStrategies.PyromancerDeffensiveStrategy;
import assets.strategiesAssets_.implementedStrategies.pyromancerStrategies.PyromancerOffensiveStrategy;
import helpers.IntegerTulep;

import java.util.HashMap;

import static helpers.Constants.PYROMANCER_HP;
import static helpers.Constants.PYROMANCER_INITIAL_HP;
import static helpers.Constants.PYROMANCER_LEVELING_HP;
import static helpers.Constants.ST_HIGH_BOUND_PYROMANCER_HP_PER;
import static helpers.Constants.ST_LOW_BOUND_PYROMANCER_HP_PER;

public final class Pyromancer extends Player {
    public Pyromancer(final IntegerTulep position) {
        super(PlayerType.Pyromancer, PYROMANCER_HP,
                PYROMANCER_INITIAL_HP, PYROMANCER_LEVELING_HP, position);
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
        if (currentHP > maxHP / ST_LOW_BOUND_PYROMANCER_HP_PER
                && currentHP < maxHP / ST_HIGH_BOUND_PYROMANCER_HP_PER) {
            setStrategy(new PyromancerOffensiveStrategy());
            return;
        }
        if (currentHP < maxHP / ST_LOW_BOUND_PYROMANCER_HP_PER && currentHP > 0) {
            setStrategy(new PyromancerDeffensiveStrategy());
            return;
        }
        setStrategy(new DoNothingStrategy());
    }

    @Override
    public String getName() {
        return "Pyromancer " + getID();
    }
}

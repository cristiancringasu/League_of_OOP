package assets.playerAssets_.implementedPlayers;

import assets.abilityAssets_.AbilityApplier;
import assets.abilityAssets_.PerpetualEffects;
import assets.angelsAssets_.Angel;
import assets.angelsAssets_.DispatchPlayerSelector;
import assets.mapAssets_.GameMap;
import assets.playerAssets_.Player;
import assets.playerAssets_.PlayerType;
import assets.strategiesAssets_.implementedStrategies.pyromancerStrategies.PyromancerDeffensiveStrategy;
import assets.strategiesAssets_.implementedStrategies.pyromancerStrategies.PyromancerOffensiveStrategy;
import assets.strategiesAssets_.implementedStrategies.rogueStrategies.RogueDeffensiveStrategy;
import assets.strategiesAssets_.implementedStrategies.rogueStrategies.RogueOffensiveStrategy;
import helpers.IntegerTulep;

import java.util.HashMap;

import static helpers.Constants.ROGUE_HP;
import static helpers.Constants.ROGUE_INITIAL_HP;
import static helpers.Constants.ROGUE_LEVELING_HP;
import static helpers.Constants.STAB_MAGIC;

public final class Rogue extends Player {

    public Rogue(final IntegerTulep position) {
        super(PlayerType.Rogue, ROGUE_HP, ROGUE_INITIAL_HP, ROGUE_LEVELING_HP, position);
    }

    private int stabsCounter = STAB_MAGIC;
    public void fight(final Player opponent, final GameMap gameMap,
                      final HashMap<Player, PerpetualEffects> overtimeEffects) {
        AbilityApplier.getInstance().apply(this, opponent,
                gameMap, getPosition(), overtimeEffects, stabsCounter);
        stabsCounter++;
        stabsCounter %= STAB_MAGIC;
    }

    @Override
    public void acceptAngel(Angel angel)  {
        DispatchPlayerSelector.selectApply(this, angel);
        //Pseudo-DoubleDispatch
    }

    @Override
    public void selectStrategy() {
        int currentHP = getHp();
        int maxHP = getMaxHP();
        if (currentHP > maxHP/7 && currentHP < maxHP/5) {
            setStrategy(new RogueOffensiveStrategy());
        }
        if (currentHP < maxHP/7) {
            setStrategy(new RogueDeffensiveStrategy());
        }
    }
}

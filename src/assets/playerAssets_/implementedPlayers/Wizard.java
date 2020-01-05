package assets.playerAssets_.implementedPlayers;

import assets.abilityAssets_.AbilityApplier;
import assets.abilityAssets_.PerpetualEffects;
import assets.angelsAssets_.Angel;
import assets.angelsAssets_.DispatchPlayerSelector;
import assets.mapAssets_.GameMap;
import assets.playerAssets_.Player;
import assets.playerAssets_.PlayerType;
import assets.strategiesAssets_.DoNothingStrategy;
import assets.strategiesAssets_.implementedStrategies.rogueStrategies.RogueDeffensiveStrategy;
import assets.strategiesAssets_.implementedStrategies.rogueStrategies.RogueOffensiveStrategy;
import assets.strategiesAssets_.implementedStrategies.wizardStrategies.WizardDeffensiveStrategy;
import assets.strategiesAssets_.implementedStrategies.wizardStrategies.WizardOffensiveStrategy;
import helpers.IntegerTulep;

import java.util.HashMap;

import static helpers.Constants.WIZARD_HP;
import static helpers.Constants.WIZARD_INITIAL_HP;
import static helpers.Constants.WIZARD_LEVELING_HP;
import static helpers.Constants.NULL_INTEGER;

public final class Wizard extends Player {
    public Wizard(final IntegerTulep position) {
        super(PlayerType.Wizard, WIZARD_HP, WIZARD_INITIAL_HP,
                WIZARD_LEVELING_HP, position);
    }

    private int receivedDamage = NULL_INTEGER;
    public int getReceivedDamage() {
        return receivedDamage;
    }
    public void prepareDamage(final int damage) {
        receivedDamage = damage;
    }
    public void incrementDamage(final int damage) {
        receivedDamage += damage;
    }

    public void fight(final Player opponent, final GameMap gameMap,
                      final HashMap<Player, PerpetualEffects> overtimeEffects) {
        AbilityApplier.getInstance().apply(this, opponent,
                gameMap, getPosition(), overtimeEffects, receivedDamage);
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
        if (currentHP > maxHP/4 && currentHP < maxHP/2) {
            setStrategy(new WizardOffensiveStrategy());
            return;
        }
        if (currentHP < maxHP/4 && currentHP > 0) {
            setStrategy(new WizardDeffensiveStrategy());
            return;
        }
        setStrategy(new DoNothingStrategy());
    }

    @Override
    public String getName() {
        return "Wizard " + getID();
    }
}

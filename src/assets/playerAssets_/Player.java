package assets.playerAssets_;

import assets.abilityAssets_.PerpetualEffects;
import assets.angelsAssets_.Angel;
import assets.angelsAssets_.implementedAngels.Spawner;
import assets.mapAssets_.GameMap;
import assets.strategiesAssets_.DoNothingStrategy;
import assets.strategiesAssets_.PlayerStrategy;
import helpers.IntegerTulep;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Observable;

import static helpers.Constants.BASE_XP;
import static helpers.Constants.LEVEL_UP_XP;
import static helpers.Constants.MULTIPLIER_XP_KILL;
import static helpers.Constants.STEP_XP_KILL;
import static java.lang.Integer.max;

public abstract class Player extends Observable {
    private static int orderCreated = 0;
    private int id;
    private PlayerType type;
    private int level = 0;
    private int xp = 0;
    private int hp;
    private int initialHP;
    private int levelingHP;
    private IntegerTulep position;
    private ArrayList<Float> selfModifiers;
    private PlayerStrategy strategy;

    public Player(final PlayerType type, final int hp, final int initialHP, final int levelingHP,
                  final IntegerTulep position) {
        this.id = orderCreated;
        orderCreated++;
        this.type = type;
        this.hp = hp;
        this.initialHP = initialHP;
        this.levelingHP = levelingHP;
        this.position = position;
        this.selfModifiers = new ArrayList<>(Arrays.asList(0.0f, 0.0f));
        this.strategy = new DoNothingStrategy();
    }

    /**
     * Method that returns player's name with id.
     * @return name w/ id
     */
    public abstract String getName();

    /**
     * Method that returns player's id.
     * @return id
     */
    public int getID() {
        return id;
    }

    /**
     * Method that returns player's type.
     * @return type
     */
    public PlayerType getType() {
        return type;
    }

    /**
     * Method that sets player's type.
     * @param type set player type
     */
    public void setType(final PlayerType type) {
        this.type = type;
    }

    /**
     * Method that returns player's level.
     * @return level
     */
    public int getLevel() {
        return level;
    }

    /**
     * Method that set level.
     * @param level
     */
    public void setLevel(final int level) {
        this.level = level;
    }

    /**
     * Method that update level.
     */
    private void updateLevel() {
        int notIncrementedLevel = ((xp - BASE_XP) / LEVEL_UP_XP);
        if (notIncrementedLevel < 0 || xp < BASE_XP) { //Haven't reached 250XP -> lvl.1
            this.level = 0;
        } else {
            int oldLevel = this.level;
            this.level = notIncrementedLevel + 1;
            if (oldLevel != this.level) {
                recoverHP();
                setChanged();
                notifyObservers(oldLevel);
            }
        }
    }

    /**
     * Method that increment level.
     */
    public void forcedLevelUp() {
        xp = BASE_XP + LEVEL_UP_XP * level;
        level += 1;
        recoverHP();
        setChanged();
        notifyObservers(level - 1);
    }

    /**
     * Method that returns XP.
     * @return XP
     */
    public int getXp() {
        return xp;
    }

    /**
     * Method that sets XP.
     * @param xp = XP
     */
    public void setXp(final int xp) {
        this.xp = xp;
    }

    /**
     * Method that receive XP.
     * @param newXp = received XP
     */
    public void receiveXP(final int newXp) {
        this.xp += newXp;
        updateLevel();
    }

    /**
     * Method that returns HP.
     * @return HP
     */
    public int getHp() {
        return hp;
    }

    /**
     * Method that sets HP.
     * @param hp = HP
     */
    public void setHp(final int hp) {
        this.hp = hp;
    }

    /**
     * Method that gets MAX HP.
     * @return max hp, according to each player type and level
     */
    public int getMaxHP() {
        return initialHP + level * levelingHP;
    }

    /**
     * Method that sub hpDamage from HP.
     * @param hpDamage = damage
     */
    public void receiveDamage(final int hpDamage) {
        this.hp -= hpDamage;
    }

    /**
     * Method that recover hp from HP.
     * @param receivedHP = +hp
     */
    public void receiveHP(final int receivedHP) {
        this.hp += receivedHP;
        if (this.hp > getMaxHP()) {
            this.hp = getMaxHP();
        }
    }

    /**
     * Method that restore hp to max hp.
     */
    public void recoverHP() {
        this.hp = getMaxHP();
    }

    /**
     * Method that gets position.
     * @return position
     */
    public IntegerTulep getPosition() {
        return position;
    }

    /**
     * Method that sets position.
     * @param position = new position
     */
    public void setPosition(final IntegerTulep position) {
        this.position = position;
    }

    public abstract void fight(Player opponent, GameMap gameMap,
                               HashMap<Player, PerpetualEffects> overtimeEffects);

    /**
     * Method that receive XP from killed opponent.
     * @param opponent = the killed opponent by this player
     */
    public void receiveXPFromKilling(final Player opponent) {
        receiveXP(max(0, STEP_XP_KILL - (level - opponent.getLevel()) * MULTIPLIER_XP_KILL));
    }

    /**
     * Method that possibly receive XP from killed opponent and notify observers.
     * @param opponent = the killed opponent by this player
     */
    public void haveKilledOpponent(final Player opponent) {
        setChanged();
        notifyObservers(opponent);
        if (this.hp > 0) {
            receiveXPFromKilling(opponent);
        }
    }

    /**
     * Getter for modifiers.
     * @return modifiers
     */
    public ArrayList<Float> getSelfModifiers() {
        return selfModifiers;
    }

    /**
     * Getter for modifiers dor ability.
     * @return modifiers for ability
     */
    public Float getSelfModifiers(final int index) {
        return selfModifiers.get(index);
    }

    /**
     * Setter for modifiers.
     * used by angels and in players strategies
     */
    public void setSelfModifiers(final int index, final Float modification) {
        Float oldModifier = this.selfModifiers.get(index);
        Float newModifier = oldModifier + modification;
        this.selfModifiers.set(index, newModifier);
    }

    /**
     * Double dispatch: angel visits the player and notify Observers.
     */
    public void acceptAngelMain(final Angel angel) {
        if (this.getHp() > 0 ^ angel instanceof Spawner) {
            setChanged();
            notifyObservers(angel);
        }
        acceptAngel(angel);
    }

    /**
     * Double dispatch: angel visits the player.
     */
    public abstract void acceptAngel(Angel angel);

    /**
     * @return strategy
     */
    public PlayerStrategy getStrategy() {
        return strategy;
    }

    /**
     * @param strategy sets the new strategy
     */
    public void setStrategy(final PlayerStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Dinamically selects strategy.
     */
    public abstract void selectStrategy();

    /**
     * Applies selected strategy.
     */
    public void playStrategy() {
        this.strategy.applyStrategy(this);
    }
}

package gameAssets.playerAssets;

import gameAssets.abilityAssets.PerpetualEffects;
import gameAssets.mapAssets.GameMap;
import helpers.IntegerTulep;

import java.util.HashMap;

import static java.lang.Integer.max;

public abstract class Player {
    private PlayerType type;
    private int level = 0;
    private int XP = 0;
    private int HP;
    private int initialHP;
    private int levelingHP;
    private IntegerTulep position;

    public Player(PlayerType type, int HP, int initialHP, int levelingHP, IntegerTulep position) {
        this.type = type;
        this.HP = HP;
        this.initialHP = initialHP;
        this.levelingHP = levelingHP;
        this.position = position;
    }

    public PlayerType getType() {
        return type;
    }

    public void setType(PlayerType type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    private void updateLevel() {
        int not_incrementedLevel = ((XP - 250) / 50);
        if(not_incrementedLevel < 0) { //Haven't reached 250XP -> lvl.1
            this.level = 0;
        } else {
            int oldLevel = this.level;
            this.level = not_incrementedLevel + 1;
            if(oldLevel != this.level)
                recoverHP();
        }
    }

    public int getXP() {
        return XP;
    }

    public void setXP(int XP) {
        this.XP = XP;
    }

    private void receiveXP(int XP) {
        this.XP += XP;
        updateLevel();
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getMaxHP() {
        return initialHP + level * levelingHP;
    }

    public void receiveDamage(int HP) {
        this.HP -= HP;
    }

    public void recoverHP() {
        this.HP = getMaxHP();
    }

    public IntegerTulep getPosition() {
        return position;
    }

    public void setPosition(IntegerTulep position) {
        this.position = position;
    }

    public abstract void fight(Player opponent, GameMap gameMap,
                      HashMap<Player, PerpetualEffects> overtimeEffects);

    public void haveKilledOpponent(Player opponent) {
        receiveXP(max(0, 200 - (level - opponent.getLevel()) * 40));
    }

}

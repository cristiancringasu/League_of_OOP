package gameAssets.abilityAssets;

import gameAssets.mapAssets.GameMap;
import gameAssets.playerAssets.Player;
import helpers.IntegerTulep;

public class PerpetualEffects {
    private Player transmitter;
    private int initialLevel;
    private Player receiver;
    private GameMap gameMap;
    private IntegerTulep initialPosition;
    private SecondaryEffects perpetualEffect; //Per Round
    private int roundsToEndure;
    private int roundsEndured = 0;
    private SEffectType effectType = SEffectType.Damage; //Default

    public SEffectType getEffectType() {
        if(roundsEndured < roundsToEndure)
            return effectType;
        else
            return SEffectType.Nothing;
    }

    public PerpetualEffects(Player transmitter, int initialLevel, Player receiver,
                            GameMap gameMap, IntegerTulep initialPosition,
                            SecondaryEffects perpetualEffect, int roundsToEndure) {
        this.transmitter = transmitter;
        this.initialLevel = initialLevel;
        this.receiver = receiver;
        this.gameMap = gameMap;
        this.initialPosition = initialPosition;
        this.perpetualEffect = perpetualEffect;
        this.roundsToEndure = roundsToEndure;

    }


    public PerpetualEffects(Player transmitter, int initialLevel, Player receiver,
                            GameMap gameMap, IntegerTulep initialPosition,
                            SecondaryEffects perpetualEffect, int roundsToEndure,
                            SEffectType effectType) {
        this.transmitter = transmitter;
        this.initialLevel = initialLevel;
        this.receiver = receiver;
        this.gameMap = gameMap;
        this.initialPosition = initialPosition;
        this.perpetualEffect = perpetualEffect;
        this.roundsToEndure = roundsToEndure;
        this.effectType = effectType;
    }

    public SEffectType applyEffects() {
        if(roundsEndured < roundsToEndure) {
            perpetualEffect.applySecondaryEffects(transmitter, initialLevel,
                                            receiver, gameMap, initialPosition);
            roundsEndured++;
            return effectType;
            //If ability applied, returns effect applied.
        }

        return SEffectType.Nothing;
        //If not applied.
    }
}

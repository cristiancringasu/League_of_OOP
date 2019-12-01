package assets.abilityAssets_;

import assets.mapAssets_.GameMap;
import assets.playerAssets_.Player;
import helpers.IntegerTulep;

public final class PerpetualEffects {
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
        if (roundsEndured < roundsToEndure) {
            return effectType;
        } else {
            return SEffectType.Nothing;
        }
    }

    public PerpetualEffects(final Player transmitter, final int initialLevel, final Player receiver,
                            final GameMap gameMap, final IntegerTulep initialPosition,
                            final SecondaryEffects perpetualEffect, final int roundsToEndure) {
        this.transmitter = transmitter;
        this.initialLevel = initialLevel;
        this.receiver = receiver;
        this.gameMap = gameMap;
        this.initialPosition = initialPosition;
        this.perpetualEffect = perpetualEffect;
        this.roundsToEndure = roundsToEndure;

    }


    public PerpetualEffects(final Player transmitter, //final int initialLevel,
                            final Player receiver,
                            final GameMap gameMap, //final IntegerTulep initialPosition,
                            final SecondaryEffects perpetualEffect, final int roundsToEndure,
                            final SEffectType effectType) {
        this.transmitter = transmitter;
        //this.initialLevel = initialLevel;
        this.initialLevel = transmitter.getLevel();
        //Did this because of [ParameterNumber]
        //checkstyle error
        this.receiver = receiver;
        this.gameMap = gameMap;
        //this.initialPosition = initialPosition;
        this.initialPosition = transmitter.getPosition(); //Did this because of [ParameterNumber]
        //checkstyle error
        this.perpetualEffect = perpetualEffect;
        this.roundsToEndure = roundsToEndure;
        this.effectType = effectType;
    }

    public SEffectType applyEffects() {
        if (roundsEndured < roundsToEndure) {
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

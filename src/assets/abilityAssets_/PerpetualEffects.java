package assets.abilityAssets_;

import assets.mapAssets_.GameMap;
import assets.playerAssets_.Player;
import helpers.IntegerTulep;

public final class PerpetualEffects {
    private Player receiver;
    private int damage;
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

    public PerpetualEffects(final Player receiver, final int damage,
                            final SecondaryEffects perpetualEffect, final int roundsToEndure,
                            final SEffectType effectType) {
        this.receiver = receiver;
        this.perpetualEffect = perpetualEffect;
        this.roundsToEndure = roundsToEndure;
        this.effectType = effectType;
        this.damage = damage;
    }

    public SEffectType applyEffects() {
        if (roundsEndured < roundsToEndure) {
            perpetualEffect.applySecondaryEffects(receiver, damage);
            roundsEndured++;
            return effectType;
            //If ability applied, returns effect applied.
        }

        return SEffectType.Nothing;
        //If not applied.
    }
}

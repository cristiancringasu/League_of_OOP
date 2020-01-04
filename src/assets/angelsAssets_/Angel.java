package assets.angelsAssets_;

import assets.playerAssets_.Player;
import assets.playerAssets_.implementedPlayers.Knight;
import assets.playerAssets_.implementedPlayers.Pyromancer;
import assets.playerAssets_.implementedPlayers.Rogue;
import assets.playerAssets_.implementedPlayers.Wizard;
import helpers.IntegerTulep;

public abstract class Angel {
    private IntegerTulep position;
    private int triggerRound;

    public Angel(final IntegerTulep position, final int triggerRound) {
        this.position = position;
        this.triggerRound = triggerRound;
    }

    public IntegerTulep getPosition() {
        return position;
    }

    public int getTriggerRound() {
        return triggerRound;
    }

    public abstract void applyKnight(final Knight receiver);
    public abstract void applyPyromancer(final Pyromancer receiver);
    public abstract void applyWizard(final Wizard receiver);
    public abstract void applyRogue(final Rogue receiver);
}

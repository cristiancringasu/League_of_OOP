package assets.angelsAssets_;

import assets.playerAssets_.Player;
import assets.playerAssets_.implementedPlayers.Knight;
import assets.playerAssets_.implementedPlayers.Pyromancer;
import assets.playerAssets_.implementedPlayers.Rogue;
import assets.playerAssets_.implementedPlayers.Wizard;
import helpers.IntegerTulep;

import java.util.Observable;

public abstract class Angel extends Observable {
    private IntegerTulep position;
    private int triggerRound;
    private int spawned;

    public Angel(final IntegerTulep position, final int triggerRound) {
        this.position = position;
        this.triggerRound = triggerRound;
        spawned = 0;
    }

    public void setSpawned() {
        spawned = 1;
        setChanged();
        notifyObservers(1);
    }

    public void majorPlayerInterraction(Player affected) {
        setChanged();
        notifyObservers(affected);
    }

    public IntegerTulep getPosition() {
        return position;
    }

    public int getTriggerRound() {
        return triggerRound;
    }

    public abstract String getName();

    public abstract String getAction();

    public abstract void applyKnight(final Knight receiver);

    public abstract void applyPyromancer(final Pyromancer receiver);

    public abstract void applyWizard(final Wizard receiver);

    public abstract void applyRogue(final Rogue receiver);
}

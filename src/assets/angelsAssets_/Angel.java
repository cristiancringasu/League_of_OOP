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

    /**
     * Angel spawn, observers notified.
     */
    public void setSpawned() {
        spawned = 1;
        setChanged();
        notifyObservers(1);
    }

    /**
     * Angel kill / revive, observers notified.
     */
    public void majorPlayerInterraction(final Player affected) {
        setChanged();
        notifyObservers(affected);
    }

    /**
     * Angel position is returned.
     * @return angel pos
     */
    public IntegerTulep getPosition() {
        return position;
    }

    /**
     * Not used.
     * Return angel activation round.
     */
    public int getTriggerRound() {
        return triggerRound;
    }

    public abstract String getName();

    public abstract String getAction();

    public abstract void applyKnight(Knight receiver);

    public abstract void applyPyromancer(Pyromancer receiver);

    public abstract void applyWizard(Wizard receiver);

    public abstract void applyRogue(Rogue receiver);
}

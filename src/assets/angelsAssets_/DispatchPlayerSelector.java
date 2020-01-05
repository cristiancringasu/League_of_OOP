package assets.angelsAssets_;

import assets.playerAssets_.implementedPlayers.Knight;
import assets.playerAssets_.implementedPlayers.Pyromancer;
import assets.playerAssets_.implementedPlayers.Rogue;
import assets.playerAssets_.implementedPlayers.Wizard;

public final class DispatchPlayerSelector {
    private DispatchPlayerSelector() {

    }

    public static void selectApply(final Knight receiver, final Angel angel) {
        angel.applyKnight(receiver);
    }

    public static void selectApply(final Pyromancer receiver, final Angel angel) {
        angel.applyPyromancer(receiver);
    }

    public static void selectApply(final Wizard receiver, final Angel angel) {
        angel.applyWizard(receiver);
    }

    public static void selectApply(final Rogue receiver, final Angel angel) {
        angel.applyRogue(receiver);
    }
}

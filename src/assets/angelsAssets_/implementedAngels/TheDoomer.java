package assets.angelsAssets_.implementedAngels;

import assets.angelsAssets_.Angel;
import assets.playerAssets_.implementedPlayers.Knight;
import assets.playerAssets_.implementedPlayers.Pyromancer;
import assets.playerAssets_.implementedPlayers.Rogue;
import assets.playerAssets_.implementedPlayers.Wizard;
import helpers.IntegerTulep;

import static helpers.Constants.DOOMER_HP;
import static helpers.Constants.SW_KNIGHT_HP;
import static helpers.Constants.SW_PYROMANCER_HP;
import static helpers.Constants.SW_ROGUE_HP;
import static helpers.Constants.SW_WIZARD_HP;

public final class TheDoomer extends Angel {
    public TheDoomer(final IntegerTulep position, final int triggerRound) {
        super(position, triggerRound);
    }

    @Override
    public String getName() {
        return "TheDoomer";
    }

    @Override
    public String getAction() {
        return " hit ";
    }

    @Override
    public void applyKnight(final Knight receiver) {
        if (receiver.getHp() <= 0) {
            return;
        }
        receiver.setHp(DOOMER_HP);
        majorPlayerInterraction(receiver);
    }

    @Override
    public void applyPyromancer(final Pyromancer receiver) {
        if (receiver.getHp() <= 0) {
            return;
        }
        receiver.setHp(DOOMER_HP);
        majorPlayerInterraction(receiver);
    }

    @Override
    public void applyWizard(final Wizard receiver) {
        if (receiver.getHp() <= 0) {
            return;
        }
        receiver.setHp(DOOMER_HP);
        majorPlayerInterraction(receiver);
    }

    @Override
    public void applyRogue(final Rogue receiver) {
        if (receiver.getHp() <= 0) {
            return;
        }
        receiver.setHp(DOOMER_HP);
        majorPlayerInterraction(receiver);
    }


}

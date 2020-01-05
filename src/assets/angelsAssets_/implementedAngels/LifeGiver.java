package assets.angelsAssets_.implementedAngels;

import assets.angelsAssets_.Angel;
import assets.playerAssets_.implementedPlayers.Knight;
import assets.playerAssets_.implementedPlayers.Pyromancer;
import assets.playerAssets_.implementedPlayers.Rogue;
import assets.playerAssets_.implementedPlayers.Wizard;
import helpers.IntegerTulep;

import static helpers.Constants.DK_KNIGHT_HP;
import static helpers.Constants.DK_PYROMANCER_HP;
import static helpers.Constants.DK_ROGUE_HP;
import static helpers.Constants.DK_WIZARD_HP;
import static helpers.Constants.LG_KNIGHT_HP;
import static helpers.Constants.LG_PYROMANCER_HP;
import static helpers.Constants.LG_ROGUE_HP;
import static helpers.Constants.LG_WIZARD_HP;

public final class LifeGiver extends Angel {
    public LifeGiver(final IntegerTulep position, final int triggerRound) {
        super(position, triggerRound);
    }

    @Override
    public String getName() {
        return "LifeGiver";
    }

    @Override
    public String getAction() {
        return " helped ";
    }


    @Override
    public void applyKnight(final Knight receiver) {
        if (receiver.getHp() <= 0) {
            return;
        }
        receiver.receiveHP(LG_KNIGHT_HP);
    }

    @Override
    public void applyPyromancer(final Pyromancer receiver) {
        if (receiver.getHp() <= 0) {
            return;
        }
        receiver.receiveHP(LG_PYROMANCER_HP);
    }

    @Override
    public void applyWizard(final Wizard receiver) {
        if (receiver.getHp() <= 0) {
            return;
        }
        receiver.receiveHP(LG_WIZARD_HP);
    }

    @Override
    public void applyRogue(final Rogue receiver) {
        if (receiver.getHp() <= 0) {
            return;
        }
        receiver.receiveHP(LG_ROGUE_HP);
    }


}

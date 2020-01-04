package assets.angelsAssets_.implementedAngels;

import assets.angelsAssets_.Angel;
import assets.playerAssets_.implementedPlayers.Knight;
import assets.playerAssets_.implementedPlayers.Pyromancer;
import assets.playerAssets_.implementedPlayers.Rogue;
import assets.playerAssets_.implementedPlayers.Wizard;
import helpers.IntegerTulep;

import static helpers.Constants.LG_KNIGHT_HP;
import static helpers.Constants.LG_PYROMANCER_HP;
import static helpers.Constants.LG_ROGUE_HP;
import static helpers.Constants.LG_WIZARD_HP;
import static helpers.Constants.XA_KNIGHT_XP;
import static helpers.Constants.XA_PYROMANCER_XP;
import static helpers.Constants.XA_ROGUE_XP;
import static helpers.Constants.XA_WIZARD_XP;

public final class XPAngel extends Angel {
    public XPAngel(final IntegerTulep position, final int triggerRound) {
        super(position, triggerRound);
    }

    @Override
    public void applyKnight(final Knight receiver) {
        if (receiver.getHp() <= 0) {
            return;
        }
        receiver.receiveXP(XA_KNIGHT_XP);
    }

    @Override
    public void applyPyromancer(final Pyromancer receiver) {
        if (receiver.getHp() <= 0) {
            return;
        }
        receiver.receiveXP(XA_PYROMANCER_XP);
    }

    @Override
    public void applyWizard(final Wizard receiver) {
        if (receiver.getHp() <= 0) {
            return;
        }
        receiver.receiveXP(XA_WIZARD_XP);
    }

    @Override
    public void applyRogue(final Rogue receiver) {
        if (receiver.getHp() <= 0) {
            return;
        }
        receiver.receiveXP(XA_ROGUE_XP);
    }


}

package assets.angelsAssets_.implementedAngels;

import assets.angelsAssets_.Angel;
import assets.playerAssets_.implementedPlayers.Knight;
import assets.playerAssets_.implementedPlayers.Pyromancer;
import assets.playerAssets_.implementedPlayers.Rogue;
import assets.playerAssets_.implementedPlayers.Wizard;
import helpers.IntegerTulep;

import static helpers.Constants.DA_KNIGHT_MODIFICATION;
import static helpers.Constants.DA_PYROMANCER_MODIFICATION;
import static helpers.Constants.DA_ROGUE_MODIFICATION;
import static helpers.Constants.DA_WIZARD_MODIFICATION;
import static helpers.Constants.DK_KNIGHT_HP;
import static helpers.Constants.DK_PYROMANCER_HP;
import static helpers.Constants.DK_ROGUE_HP;
import static helpers.Constants.DK_WIZARD_HP;
import static helpers.Constants.FIRST_ABILITY;
import static helpers.Constants.SECOND_ABILITY;

public final class DarkAngel extends Angel {
    public DarkAngel(final IntegerTulep position, final int triggerRound) {
        super(position, triggerRound);
    }

    @Override
    public void applyKnight(final Knight receiver) {
        if (receiver.getHp() <= 0) {
            return;
        }
        receiver.receiveDamage(DK_KNIGHT_HP);
    }

    @Override
    public void applyPyromancer(final Pyromancer receiver) {
        if (receiver.getHp() <= 0) {
            return;
        }
        receiver.receiveDamage(DK_PYROMANCER_HP);
    }

    @Override
    public void applyWizard(final Wizard receiver) {
        if (receiver.getHp() <= 0) {
            return;
        }
        receiver.receiveDamage(DK_WIZARD_HP);
    }

    @Override
    public void applyRogue(final Rogue receiver) {
        if (receiver.getHp() <= 0) {
            return;
        }
        receiver.receiveDamage(DK_ROGUE_HP);
    }


}

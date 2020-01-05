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

public final class DarkAngel extends Angel {
    public DarkAngel(final IntegerTulep position, final int triggerRound) {
        super(position, triggerRound);
    }

    @Override
    public String getName() {
        return "DarkAngel";
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
        receiver.receiveDamage(DK_KNIGHT_HP);
        if (receiver.getHp() <= 0) {
            this.majorPlayerInterraction(receiver);
        }
    }

    @Override
    public void applyPyromancer(final Pyromancer receiver) {
        if (receiver.getHp() <= 0) {
            return;
        }
        receiver.receiveDamage(DK_PYROMANCER_HP);
        if (receiver.getHp() <= 0) {
            this.majorPlayerInterraction(receiver);
        }
    }

    @Override
    public void applyWizard(final Wizard receiver) {
        if (receiver.getHp() <= 0) {
            return;
        }
        receiver.receiveDamage(DK_WIZARD_HP);
        if (receiver.getHp() <= 0) {
            this.majorPlayerInterraction(receiver);
        }
    }

    @Override
    public void applyRogue(final Rogue receiver) {
        if (receiver.getHp() <= 0) {
            return;
        }
        receiver.receiveDamage(DK_ROGUE_HP);
        if (receiver.getHp() <= 0) {
            this.majorPlayerInterraction(receiver);
        }
    }


}

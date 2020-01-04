package assets.angelsAssets_.implementedAngels;

import assets.angelsAssets_.Angel;
import assets.playerAssets_.implementedPlayers.Knight;
import assets.playerAssets_.implementedPlayers.Pyromancer;
import assets.playerAssets_.implementedPlayers.Rogue;
import assets.playerAssets_.implementedPlayers.Wizard;
import helpers.IntegerTulep;

import static helpers.Constants.DR_KNIGHT_HP;
import static helpers.Constants.DR_KNIGHT_MODIFICATION;
import static helpers.Constants.DR_PYROMANCER_HP;
import static helpers.Constants.DR_PYROMANCER_MODIFICATION;
import static helpers.Constants.DR_ROGUE_HP;
import static helpers.Constants.DR_ROGUE_MODIFICATION;
import static helpers.Constants.DR_WIZARD_HP;
import static helpers.Constants.DR_WIZARD_MODIFICATION;
import static helpers.Constants.FIRST_ABILITY;
import static helpers.Constants.GB_KNIGHT_HP;
import static helpers.Constants.GB_KNIGHT_MODIFICATION;
import static helpers.Constants.GB_PYROMANCER_HP;
import static helpers.Constants.GB_PYROMANCER_MODIFICATION;
import static helpers.Constants.GB_ROGUE_HP;
import static helpers.Constants.GB_ROGUE_MODIFICATION;
import static helpers.Constants.GB_WIZARD_HP;
import static helpers.Constants.GB_WIZARD_MODIFICATION;
import static helpers.Constants.SECOND_ABILITY;

public final class GoodBoy extends Angel {
    public GoodBoy(final IntegerTulep position, final int triggerRound) {
        super(position, triggerRound);
    }

    @Override
    public void applyKnight(final Knight receiver) {
        if (receiver.getHp() <= 0) {
            return;
        }
        receiver.setSelfModifiers(FIRST_ABILITY,GB_KNIGHT_MODIFICATION);
        receiver.setSelfModifiers(SECOND_ABILITY,GB_KNIGHT_MODIFICATION);
        receiver.receiveHP(GB_KNIGHT_HP);
    }

    @Override
    public void applyPyromancer(final Pyromancer receiver) {
        if (receiver.getHp() <= 0) {
            return;
        }
        receiver.setSelfModifiers(FIRST_ABILITY,GB_PYROMANCER_MODIFICATION);
        receiver.setSelfModifiers(SECOND_ABILITY,GB_PYROMANCER_MODIFICATION);
        receiver.receiveHP(GB_PYROMANCER_HP);
    }

    @Override
    public void applyWizard(final Wizard receiver) {
        if (receiver.getHp() <= 0) {
            return;
        }
        receiver.setSelfModifiers(FIRST_ABILITY,GB_WIZARD_MODIFICATION);
        receiver.setSelfModifiers(SECOND_ABILITY,GB_WIZARD_MODIFICATION);
        receiver.receiveHP(GB_WIZARD_HP);
    }

    @Override
    public void applyRogue(final Rogue receiver) {
        if (receiver.getHp() <= 0) {
            return;
        }
        receiver.setSelfModifiers(FIRST_ABILITY,GB_ROGUE_MODIFICATION);
        receiver.setSelfModifiers(SECOND_ABILITY,GB_ROGUE_MODIFICATION);
        receiver.receiveHP(GB_ROGUE_HP);
    }


}

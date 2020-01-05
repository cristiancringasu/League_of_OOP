package assets.angelsAssets_.implementedAngels;

import assets.angelsAssets_.Angel;
import assets.playerAssets_.Player;
import assets.playerAssets_.implementedPlayers.Knight;
import assets.playerAssets_.implementedPlayers.Pyromancer;
import assets.playerAssets_.implementedPlayers.Rogue;
import assets.playerAssets_.implementedPlayers.Wizard;
import helpers.IntegerTulep;

import static helpers.Constants.DA_KNIGHT_MODIFICATION;
import static helpers.Constants.DA_PYROMANCER_MODIFICATION;
import static helpers.Constants.DA_ROGUE_MODIFICATION;
import static helpers.Constants.DA_WIZARD_MODIFICATION;
import static helpers.Constants.FIRST_ABILITY;
import static helpers.Constants.SECOND_ABILITY;

public final class DamageAngel extends Angel {
    public DamageAngel(final IntegerTulep position, final int triggerRound) {
        super(position, triggerRound);
    }

    @Override
    public String getName() {
        return "DamageAngel";
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
        receiver.setSelfModifiers(FIRST_ABILITY,DA_KNIGHT_MODIFICATION);
        receiver.setSelfModifiers(SECOND_ABILITY,DA_KNIGHT_MODIFICATION);
    }

    @Override
    public void applyPyromancer(final Pyromancer receiver) {
        if (receiver.getHp() <= 0) {
            return;
        }
        receiver.setSelfModifiers(FIRST_ABILITY,DA_PYROMANCER_MODIFICATION);
        receiver.setSelfModifiers(SECOND_ABILITY,DA_PYROMANCER_MODIFICATION);
    }

    @Override
    public void applyWizard(final Wizard receiver) {
        if (receiver.getHp() <= 0) {
            return;
        }
        receiver.setSelfModifiers(FIRST_ABILITY,DA_WIZARD_MODIFICATION);
        receiver.setSelfModifiers(SECOND_ABILITY,DA_WIZARD_MODIFICATION);
    }

    @Override
    public void applyRogue(final Rogue receiver) {
        if (receiver.getHp() <= 0) {
            return;
        }
        receiver.setSelfModifiers(FIRST_ABILITY,DA_ROGUE_MODIFICATION);
        receiver.setSelfModifiers(SECOND_ABILITY,DA_ROGUE_MODIFICATION);
    }


}

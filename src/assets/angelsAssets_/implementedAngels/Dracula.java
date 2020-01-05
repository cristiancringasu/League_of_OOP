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
import static helpers.Constants.SECOND_ABILITY;

public final class Dracula extends Angel {
    public Dracula(final IntegerTulep position, final int triggerRound) {
        super(position, triggerRound);
    }

    @Override
    public String getName() {
        return "Dracula";
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
        receiver.setSelfModifiers(FIRST_ABILITY, DR_KNIGHT_MODIFICATION);
        receiver.setSelfModifiers(SECOND_ABILITY, DR_KNIGHT_MODIFICATION);
        receiver.receiveDamage(DR_KNIGHT_HP);
        if (receiver.getHp() <= 0) {
            this.majorPlayerInterraction(receiver);
        }
    }

    @Override
    public void applyPyromancer(final Pyromancer receiver) {
        if (receiver.getHp() <= 0) {
            return;
        }
        receiver.setSelfModifiers(FIRST_ABILITY, DR_PYROMANCER_MODIFICATION);
        receiver.setSelfModifiers(SECOND_ABILITY, DR_PYROMANCER_MODIFICATION);
        receiver.receiveDamage(DR_PYROMANCER_HP);
        if (receiver.getHp() <= 0) {
            this.majorPlayerInterraction(receiver);
        }
    }

    @Override
    public void applyWizard(final Wizard receiver) {
        if (receiver.getHp() <= 0) {
            return;
        }
        receiver.setSelfModifiers(FIRST_ABILITY, DR_WIZARD_MODIFICATION);
        receiver.setSelfModifiers(SECOND_ABILITY, DR_WIZARD_MODIFICATION);
        receiver.receiveDamage(DR_WIZARD_HP);
        if (receiver.getHp() <= 0) {
            this.majorPlayerInterraction(receiver);
        }
    }

    @Override
    public void applyRogue(final Rogue receiver) {
        if (receiver.getHp() <= 0) {
            return;
        }
        receiver.setSelfModifiers(FIRST_ABILITY, DR_ROGUE_MODIFICATION);
        receiver.setSelfModifiers(SECOND_ABILITY, DR_ROGUE_MODIFICATION);
        receiver.receiveDamage(DR_ROGUE_HP);
        if (receiver.getHp() <= 0) {
            this.majorPlayerInterraction(receiver);
        }
    }


}

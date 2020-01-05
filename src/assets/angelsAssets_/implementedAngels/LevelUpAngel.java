package assets.angelsAssets_.implementedAngels;

import assets.angelsAssets_.Angel;
import assets.playerAssets_.implementedPlayers.Knight;
import assets.playerAssets_.implementedPlayers.Pyromancer;
import assets.playerAssets_.implementedPlayers.Rogue;
import assets.playerAssets_.implementedPlayers.Wizard;
import helpers.IntegerTulep;
import static helpers.Constants.FIRST_ABILITY;
import static helpers.Constants.LV_KNIGHT_MODIFICATION;
import static helpers.Constants.LV_PYROMANCER_MODIFICATION;
import static helpers.Constants.LV_ROGUE_MODIFICATION;
import static helpers.Constants.LV_WIZARD_MODIFICATION;
import static helpers.Constants.SECOND_ABILITY;

public final class LevelUpAngel extends Angel {
    public LevelUpAngel(final IntegerTulep position, final int triggerRound) {
        super(position, triggerRound);
    }

    @Override
    public String getName() {
        return "LevelUpAngel";
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
        receiver.setSelfModifiers(FIRST_ABILITY, LV_KNIGHT_MODIFICATION);
        receiver.setSelfModifiers(SECOND_ABILITY, LV_KNIGHT_MODIFICATION);
        receiver.forcedLevelUp();
    }

    @Override
    public void applyPyromancer(final Pyromancer receiver) {
        if (receiver.getHp() <= 0) {
            return;
        }
        receiver.setSelfModifiers(FIRST_ABILITY, LV_PYROMANCER_MODIFICATION);
        receiver.setSelfModifiers(SECOND_ABILITY, LV_PYROMANCER_MODIFICATION);
        receiver.forcedLevelUp();
    }

    @Override
    public void applyWizard(final Wizard receiver) {
        if (receiver.getHp() <= 0) {
            return;
        }
        receiver.setSelfModifiers(FIRST_ABILITY, LV_WIZARD_MODIFICATION);
        receiver.setSelfModifiers(SECOND_ABILITY, LV_WIZARD_MODIFICATION);
        receiver.forcedLevelUp();
    }

    @Override
    public void applyRogue(final Rogue receiver) {
        if (receiver.getHp() <= 0) {
            return;
        }
        receiver.setSelfModifiers(FIRST_ABILITY, LV_ROGUE_MODIFICATION);
        receiver.setSelfModifiers(SECOND_ABILITY, LV_ROGUE_MODIFICATION);
        receiver.forcedLevelUp();
    }


}

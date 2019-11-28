package gameAssets.abilityAssets;

import gameAssets.abilityAssets.implementedAbilities.knightAbilities.Execute;
import gameAssets.abilityAssets.implementedAbilities.knightAbilities.Slam;
import gameAssets.abilityAssets.implementedAbilities.pyromancerAbilities.Fireblast;
import gameAssets.abilityAssets.implementedAbilities.pyromancerAbilities.Ignite;
import gameAssets.abilityAssets.implementedAbilities.rogueAbilities.Backstab;
import gameAssets.abilityAssets.implementedAbilities.rogueAbilities.Paralysis;
import gameAssets.abilityAssets.implementedAbilities.wizardAbilities.Deflect;
import gameAssets.abilityAssets.implementedAbilities.wizardAbilities.Drain;
import gameAssets.mapAssets.GameMap;
import gameAssets.playerAssets.Player;
import gameAssets.playerAssets.implementedPlayers.Knight;
import gameAssets.playerAssets.implementedPlayers.Pyromancer;
import gameAssets.playerAssets.implementedPlayers.Rogue;
import gameAssets.playerAssets.implementedPlayers.Wizard;
import helpers.IntegerTulep;

import java.util.HashMap;

public class AbilityApplier { //Follows a visitor Pattern
    private static AbilityApplier instance = null;

    private AbilityApplier() {}

    public static AbilityApplier getInstance() {
        if(instance == null)
            instance = new AbilityApplier();

        return instance;
    }

    public void apply(Rogue transmitter, Player receiver,
                      GameMap gameMap, IntegerTulep position,
                      HashMap<Player, PerpetualEffects> overtimeEffects, int stabsCounter) {

        Backstab.getInstance().setStabsCounter(stabsCounter);
        Backstab.getInstance().applyAbility(transmitter,receiver,gameMap,position,overtimeEffects);
        Backstab.getInstance().setStabsCounter(-1);

        Paralysis.getInstance().applyAbility(transmitter,receiver,gameMap,position,overtimeEffects);
    }

    public void apply(Wizard transmitter, Player receiver,
                      GameMap gameMap, IntegerTulep position,
                      HashMap<Player, PerpetualEffects> overtimeEffects, int receivedDamage) {

        Drain.getInstance().applyAbility(transmitter,receiver,gameMap,position,overtimeEffects);

        Deflect.getInstance().setReceivedDamage(receivedDamage);
        Deflect.getInstance().applyAbility(transmitter,receiver,gameMap,position,overtimeEffects);
        Deflect.getInstance().setReceivedDamage(-1);
    }

    public void apply(Knight transmitter, Player receiver,
                      GameMap gameMap, IntegerTulep position,
                      HashMap<Player, PerpetualEffects> overtimeEffects) {

        Execute.getInstance().applyAbility(transmitter,receiver,gameMap,position,overtimeEffects);
        Slam.getInstance().applyAbility(transmitter,receiver,gameMap,position,overtimeEffects);
    }

    public void apply(Pyromancer transmitter, Player receiver,
                      GameMap gameMap, IntegerTulep position,
                      HashMap<Player, PerpetualEffects> overtimeEffects) {

        Fireblast.getInstance().applyAbility(transmitter,receiver,gameMap,position,overtimeEffects);
        Ignite.getInstance().applyAbility(transmitter,receiver,gameMap,position,overtimeEffects);
    }

}

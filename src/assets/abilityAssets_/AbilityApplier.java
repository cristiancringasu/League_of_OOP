package assets.abilityAssets_;

import assets.abilityAssets_.implementedAbilities.knightAbilities.Execute;
import assets.abilityAssets_.implementedAbilities.knightAbilities.Slam;
import assets.abilityAssets_.implementedAbilities.pyromancerAbilities.Fireblast;
import assets.abilityAssets_.implementedAbilities.pyromancerAbilities.Ignite;
import assets.abilityAssets_.implementedAbilities.rogueAbilities.Backstab;
import assets.abilityAssets_.implementedAbilities.rogueAbilities.Paralysis;
import assets.abilityAssets_.implementedAbilities.wizardAbilities.Deflect;
import assets.abilityAssets_.implementedAbilities.wizardAbilities.Drain;
import assets.mapAssets_.GameMap;
import assets.playerAssets_.Player;
import assets.playerAssets_.implementedPlayers.Knight;
import assets.playerAssets_.implementedPlayers.Pyromancer;
import assets.playerAssets_.implementedPlayers.Rogue;
import assets.playerAssets_.implementedPlayers.Wizard;
import helpers.IntegerTulep;

import java.util.HashMap;

public final class AbilityApplier { //Follows a visitor Pattern
    private static AbilityApplier instance = null;

    private AbilityApplier() {

    }

    public static AbilityApplier getInstance() {
        if (instance == null) {
            instance = new AbilityApplier();
        }
        return instance;
    }

    public void apply(final Rogue transmitter, final Player receiver,
                      final GameMap gameMap, final IntegerTulep position,
                      final HashMap<Player, PerpetualEffects> overtimeEffects,
                      final int stabsCounter) {

        Backstab.getInstance().setStabsCounter(stabsCounter);
        Backstab.getInstance().applyAbility(transmitter, receiver,
                              gameMap, position, overtimeEffects);
        Backstab.getInstance().setStabsCounter(-1);

        Paralysis.getInstance().applyAbility(transmitter, receiver,
                               gameMap, position, overtimeEffects);
    }

    public void apply(final Wizard transmitter, final Player receiver,
                      final GameMap gameMap, final IntegerTulep position,
                      final HashMap<Player, PerpetualEffects> overtimeEffects,
                      final int receivedDamage) {

        Drain.getInstance().applyAbility(transmitter, receiver, gameMap, position, overtimeEffects);

        Deflect.getInstance().setReceivedDamage(receivedDamage);
        Deflect.getInstance().applyAbility(transmitter, receiver,
                             gameMap, position, overtimeEffects);
        Deflect.getInstance().setReceivedDamage(-1);
        transmitter.prepareDamage(-1);
    }

    public void apply(final Knight transmitter, final Player receiver,
                      final GameMap gameMap, final IntegerTulep position,
                      final HashMap<Player, PerpetualEffects> overtimeEffects) {

        Execute.getInstance().applyAbility(transmitter, receiver,
                             gameMap, position, overtimeEffects);
        Slam.getInstance().applyAbility(transmitter, receiver, gameMap, position, overtimeEffects);
    }

    public void apply(final Pyromancer transmitter, final Player receiver,
                      final GameMap gameMap, final IntegerTulep position,
                      final HashMap<Player, PerpetualEffects> overtimeEffects) {

        Fireblast.getInstance().applyAbility(transmitter, receiver,
                               gameMap, position, overtimeEffects);
        Ignite.getInstance().applyAbility(transmitter, receiver,
                            gameMap, position, overtimeEffects);
    }

}

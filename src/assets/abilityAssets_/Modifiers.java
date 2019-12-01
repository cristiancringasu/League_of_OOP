package assets.abilityAssets_;

import assets.mapAssets_.GameMap;
import assets.mapAssets_.LandType;
import assets.playerAssets_.Player;
import assets.playerAssets_.PlayerType;
import helpers.IntegerTulep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static helpers.Constants.BACKSTAB_KNIGHT;
import static helpers.Constants.BACKSTAB_PYROMANCER;
import static helpers.Constants.BACKSTAB_ROGUE;
import static helpers.Constants.BACKSTAB_WIZARD;
import static helpers.Constants.DEFLECT_KNIGHT;
import static helpers.Constants.DEFLECT_PYROMANCER;
import static helpers.Constants.DEFLECT_ROGUE;
import static helpers.Constants.DEFLECT_WIZARD;
import static helpers.Constants.DRAIN_KNIGHT;
import static helpers.Constants.DRAIN_PYROMANCER;
import static helpers.Constants.DRAIN_ROGUE;
import static helpers.Constants.DRAIN_WIZARD;
import static helpers.Constants.EXECUTE_KNIGHT;
import static helpers.Constants.EXECUTE_PYROMANCER;
import static helpers.Constants.EXECUTE_ROGUE;
import static helpers.Constants.EXECUTE_WIZARD;
import static helpers.Constants.FIREBLAST_KNIGHT;
import static helpers.Constants.FIREBLAST_PYROMANCER;
import static helpers.Constants.FIREBLAST_ROGUE;
import static helpers.Constants.FIREBLAST_WIZARD;
import static helpers.Constants.IGNITE_KNIGHT;
import static helpers.Constants.IGNITE_PYROMANCER;
import static helpers.Constants.IGNITE_ROGUE;
import static helpers.Constants.IGNITE_WIZARD;
import static helpers.Constants.KNIGHT_LAND;
import static helpers.Constants.NO_BONUS_LAND;
import static helpers.Constants.PARALYSIS_KNIGHT;
import static helpers.Constants.PARALYSIS_PYROMANCER;
import static helpers.Constants.PARALYSIS_ROGUE;
import static helpers.Constants.PARALYSIS_WIZARD;
import static helpers.Constants.PYROMANCER_VOLCANIC;
import static helpers.Constants.ROGUE_WOODS;
import static helpers.Constants.SLAM_KNIGHT;
import static helpers.Constants.SLAM_PYROMANCER;
import static helpers.Constants.SLAM_ROGUE;
import static helpers.Constants.SLAM_WIZARD;
import static helpers.Constants.WIZARD_DESERT;

public final class Modifiers {
    private static Modifiers instance = null;

    private HashMap<PlayerType, HashMap<LandType, Float>> landModifiers;
    //PlayerType -> Effectivness on each Land (LandType -> Double)

    private HashMap<PlayerType, ArrayList<HashMap<PlayerType, Float>>> raceModifiers;
    //PlayerType -> Ability(index = INTEGER) ->
    //-> Effectivness on each PlayerType (PlayerType -> Double)

    private Modifiers() {
        //instance = new Modifiers();
        landModifiers = new HashMap<>();
        raceModifiers = new HashMap<>();
        this.setLandModifiers();
        this.setRaceModifiers();
    }

    private void setLandModifiers() {
        HashMap<LandType, Float> knightLModifiers = new HashMap<>();
        knightLModifiers.put(LandType.Land, KNIGHT_LAND);
        knightLModifiers.put(LandType.Volcanic, NO_BONUS_LAND);
        knightLModifiers.put(LandType.Desert, NO_BONUS_LAND);
        knightLModifiers.put(LandType.Woods, NO_BONUS_LAND);
        landModifiers.put(PlayerType.Knight, knightLModifiers);

        HashMap<LandType, Float> pyromancerLModifiers = new HashMap<>();
        pyromancerLModifiers.put(LandType.Land, NO_BONUS_LAND);
        pyromancerLModifiers.put(LandType.Volcanic, PYROMANCER_VOLCANIC);
        pyromancerLModifiers.put(LandType.Desert, NO_BONUS_LAND);
        pyromancerLModifiers.put(LandType.Woods, NO_BONUS_LAND);
        landModifiers.put(PlayerType.Pyromancer, pyromancerLModifiers);

        HashMap<LandType, Float> wizardLModifiers = new HashMap<>();
        wizardLModifiers.put(LandType.Land, NO_BONUS_LAND);
        wizardLModifiers.put(LandType.Volcanic, NO_BONUS_LAND);
        wizardLModifiers.put(LandType.Desert, WIZARD_DESERT);
        wizardLModifiers.put(LandType.Woods, NO_BONUS_LAND);
        landModifiers.put(PlayerType.Wizard, wizardLModifiers);

        HashMap<LandType, Float> rogueLModifiers = new HashMap<>();
        rogueLModifiers.put(LandType.Land, NO_BONUS_LAND);
        rogueLModifiers.put(LandType.Volcanic, NO_BONUS_LAND);
        rogueLModifiers.put(LandType.Desert, NO_BONUS_LAND);
        rogueLModifiers.put(LandType.Woods, ROGUE_WOODS);
        landModifiers.put(PlayerType.Rogue, rogueLModifiers);
    }

    private void setRaceModifiers() {
        //Knight Abillities:
        HashMap<PlayerType, Float> execute = new HashMap<>();
        execute.put(PlayerType.Knight, EXECUTE_KNIGHT);
        execute.put(PlayerType.Pyromancer, EXECUTE_PYROMANCER);
        execute.put(PlayerType.Rogue, EXECUTE_ROGUE);
        execute.put(PlayerType.Wizard, EXECUTE_WIZARD);

        HashMap<PlayerType, Float> slam = new HashMap<>();
        slam.put(PlayerType.Knight, SLAM_KNIGHT);
        slam.put(PlayerType.Pyromancer, SLAM_PYROMANCER);
        slam.put(PlayerType.Rogue, SLAM_ROGUE);
        slam.put(PlayerType.Wizard, SLAM_WIZARD);

        raceModifiers.put(PlayerType.Knight, new ArrayList<>(Arrays.asList(execute, slam)));

        //Pyromancer Abillities:
        HashMap<PlayerType, Float> fireblast = new HashMap<>();
        fireblast.put(PlayerType.Knight, FIREBLAST_KNIGHT);
        fireblast.put(PlayerType.Pyromancer, FIREBLAST_PYROMANCER);
        fireblast.put(PlayerType.Rogue, FIREBLAST_ROGUE);
        fireblast.put(PlayerType.Wizard, FIREBLAST_WIZARD);

        HashMap<PlayerType, Float> ignite = new HashMap<>();
        ignite.put(PlayerType.Knight, IGNITE_KNIGHT);
        ignite.put(PlayerType.Pyromancer, IGNITE_PYROMANCER);
        ignite.put(PlayerType.Rogue, IGNITE_ROGUE);
        ignite.put(PlayerType.Wizard, IGNITE_WIZARD);

        raceModifiers.put(PlayerType.Pyromancer, new ArrayList<>(Arrays.asList(fireblast, ignite)));

        //Rogue Abillities:
        HashMap<PlayerType, Float> backstab = new HashMap<>();
        backstab.put(PlayerType.Knight, BACKSTAB_KNIGHT);
        backstab.put(PlayerType.Pyromancer, BACKSTAB_PYROMANCER);
        backstab.put(PlayerType.Rogue, BACKSTAB_ROGUE);
        backstab.put(PlayerType.Wizard, BACKSTAB_WIZARD);

        HashMap<PlayerType, Float> paralysis = new HashMap<>();
        paralysis.put(PlayerType.Knight, PARALYSIS_KNIGHT);
        paralysis.put(PlayerType.Pyromancer, PARALYSIS_PYROMANCER);
        paralysis.put(PlayerType.Rogue, PARALYSIS_ROGUE);
        paralysis.put(PlayerType.Wizard, PARALYSIS_WIZARD);

        raceModifiers.put(PlayerType.Rogue, new ArrayList<>(Arrays.asList(backstab, paralysis)));

        //Wizard Abillities:
        HashMap<PlayerType, Float> drain = new HashMap<>();
        drain.put(PlayerType.Knight, DRAIN_KNIGHT);
        drain.put(PlayerType.Pyromancer, DRAIN_PYROMANCER);
        drain.put(PlayerType.Rogue, DRAIN_ROGUE);
        drain.put(PlayerType.Wizard, DRAIN_WIZARD);

        HashMap<PlayerType, Float> deflect = new HashMap<>();
        deflect.put(PlayerType.Knight, DEFLECT_KNIGHT);
        deflect.put(PlayerType.Pyromancer, DEFLECT_PYROMANCER);
        deflect.put(PlayerType.Rogue, DEFLECT_ROGUE);
        deflect.put(PlayerType.Wizard, DEFLECT_WIZARD);

        raceModifiers.put(PlayerType.Wizard, new ArrayList<>(Arrays.asList(drain, deflect)));
    }

    public HashMap<PlayerType, HashMap<LandType, Float>> getLandModifiers() {
        return landModifiers;
    }

    public HashMap<PlayerType, ArrayList<HashMap<PlayerType, Float>>> getRaceModifiers() {
        return raceModifiers;
    }

    public Float getModifiers(final Player sender, final Player receiver,
                              final GameMap gameMap, final int abilityID) {

               return
                landModifiers.get(sender.getType()).get(gameMap.getMapCell(sender.getPosition()))
                * raceModifiers.get(sender.getType()).get(abilityID).get(receiver.getType());
    }

    public Float getModifiersWPOS(final Player sender, final Player receiver,
                                  final GameMap gameMap, final IntegerTulep position,
                                  final int abilityID) {

        return landModifiers.get(sender.getType()).get(gameMap.getMapCell(position))
                * raceModifiers.get(sender.getType()).get(abilityID).get(receiver.getType());
    }

    public static Modifiers getInstance() {
        if (instance == null) {
            instance = new Modifiers();
        }
        return instance;
    }
}

package gameAssets.abilityAssets;

import gameAssets.mapAssets.GameMap;
import gameAssets.mapAssets.LandType;
import gameAssets.playerAssets.Player;
import gameAssets.playerAssets.PlayerType;
import helpers.IntegerTulep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Modifiers {
    public static Modifiers instance = null;

    private HashMap<PlayerType, HashMap<LandType, Float>> landModifiers;
    //PlayerType -> Effectivness on each Land (LandType -> Double)

    private HashMap<PlayerType, ArrayList<HashMap<PlayerType, Float>>> raceModifiers;
    //PlayerType -> Ability(index = INTEGER) ->
    //-> Effectivness on each PlayerType (PlayerType -> Double)

    private Modifiers () {
        //instance = new Modifiers();
        landModifiers = new HashMap<>();
        raceModifiers = new HashMap<>();
        this.setLandModifiers();
        this.setRaceModifiers();
    }

    private void setLandModifiers() {
        HashMap<LandType, Float> knightLModifiers = new HashMap<>();
        knightLModifiers.put(LandType.Land, 1.15f);
        knightLModifiers.put(LandType.Volcanic, 1.0f);
        knightLModifiers.put(LandType.Desert, 1.0f);
        knightLModifiers.put(LandType.Woods, 1.0f);
        landModifiers.put(PlayerType.Knight, knightLModifiers);

        HashMap<LandType, Float> pyromancerLModifiers = new HashMap<>();
        knightLModifiers.put(LandType.Land, 1.0f);
        knightLModifiers.put(LandType.Volcanic, 1.25f);
        knightLModifiers.put(LandType.Desert, 1.0f);
        knightLModifiers.put(LandType.Woods, 1.0f);
        landModifiers.put(PlayerType.Pyromancer, pyromancerLModifiers);

        HashMap<LandType, Float> wizardLModifiers = new HashMap<>();
        knightLModifiers.put(LandType.Land, 1.0f);
        knightLModifiers.put(LandType.Volcanic, 1.0f);
        knightLModifiers.put(LandType.Desert, 1.10f);
        knightLModifiers.put(LandType.Woods, 1.0f);
        landModifiers.put(PlayerType.Wizard, wizardLModifiers);

        HashMap<LandType, Float> rogueLModifiers = new HashMap<>();
        knightLModifiers.put(LandType.Land, 1.0f);
        knightLModifiers.put(LandType.Volcanic, 1.0f);
        knightLModifiers.put(LandType.Desert, 1.0f);
        knightLModifiers.put(LandType.Woods, 1.15f);
        landModifiers.put(PlayerType.Rogue, rogueLModifiers);
    }

    private void setRaceModifiers() {
        //Knight Abillities:
        HashMap<PlayerType, Float> execute = new HashMap<>();
        execute.put(PlayerType.Knight, 1.0f);
        execute.put(PlayerType.Pyromancer, 1.1f);
        execute.put(PlayerType.Rogue, 1.15f);
        execute.put(PlayerType.Wizard, 0.8f);

        HashMap<PlayerType, Float> slam = new HashMap<>();
        slam.put(PlayerType.Knight, 1.2f);
        slam.put(PlayerType.Pyromancer, 0.9f);
        slam.put(PlayerType.Rogue, 0.8f);
        slam.put(PlayerType.Wizard, 1.05f);

        raceModifiers.put(PlayerType.Knight, new ArrayList<>(Arrays.asList(execute, slam)));

        //Pyromancer Abillities:
        HashMap<PlayerType, Float> fireblast = new HashMap<>();
        fireblast.put(PlayerType.Knight, 1.2f);
        fireblast.put(PlayerType.Pyromancer, 0.9f);
        fireblast.put(PlayerType.Rogue, 0.8f);
        fireblast.put(PlayerType.Wizard, 1.05f);

        HashMap<PlayerType, Float> ignite = new HashMap<>();
        ignite.put(PlayerType.Knight, 1.2f);
        ignite.put(PlayerType.Pyromancer, 0.9f);
        ignite.put(PlayerType.Rogue, 0.8f);
        ignite.put(PlayerType.Wizard, 1.05f);

        raceModifiers.put(PlayerType.Pyromancer, new ArrayList<>(Arrays.asList(fireblast, ignite)));

        //Rogue Abillities:
        HashMap<PlayerType, Float> backstab = new HashMap<>();
        backstab.put(PlayerType.Knight, 0.9f);
        backstab.put(PlayerType.Pyromancer, 1.25f);
        backstab.put(PlayerType.Rogue, 1.2f);
        backstab.put(PlayerType.Wizard, 1.25f);

        HashMap<PlayerType, Float> paralysis = new HashMap<>();
        paralysis.put(PlayerType.Knight, 0.8f);
        paralysis.put(PlayerType.Pyromancer, 1.2f);
        paralysis.put(PlayerType.Rogue, 0.9f);
        paralysis.put(PlayerType.Wizard, 1.25f);

        raceModifiers.put(PlayerType.Rogue, new ArrayList<>(Arrays.asList(backstab, paralysis)));

        //Wizard Abillities:
        HashMap<PlayerType, Float> drain = new HashMap<>();
        drain.put(PlayerType.Knight, 1.2f);
        drain.put(PlayerType.Pyromancer, 0.9f);
        drain.put(PlayerType.Rogue, 0.8f);
        drain.put(PlayerType.Wizard, 1.05f);

        HashMap<PlayerType, Float> deflect = new HashMap<>();
        deflect.put(PlayerType.Knight, 1.4f);
        deflect.put(PlayerType.Pyromancer, 1.3f);
        deflect.put(PlayerType.Rogue, 1.2f);
        deflect.put(PlayerType.Wizard, 0.0f);

        raceModifiers.put(PlayerType.Rogue, new ArrayList<>(Arrays.asList(drain, deflect)));
    }

    public HashMap<PlayerType, HashMap<LandType, Float>> getLandModifiers() {
        return landModifiers;
    }

    public HashMap<PlayerType, ArrayList<HashMap<PlayerType, Float>>> getRaceModifiers() {
        return raceModifiers;
    }

    public Float getModifiers(Player sender, Player receiver,
                              GameMap gameMap, int abilityID) {

               return landModifiers.get(sender.getType()).get(gameMap.getMapCell(sender.getPosition()))
                * raceModifiers.get(sender.getType()).get(abilityID).get(receiver.getType());
    }

    public Float getModifiersW_POS(Player sender, Player receiver,
                              GameMap gameMap, IntegerTulep position, int abilityID) {

        return landModifiers.get(sender.getType()).get(gameMap.getMapCell(position))
                * raceModifiers.get(sender.getType()).get(abilityID).get(receiver.getType());
    }

    public static Modifiers getInstance() {
        if (instance == null)
            instance = new Modifiers();

        return instance;
    }
}

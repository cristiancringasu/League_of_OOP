package helpers;

public final class Constants {
    // add/delete any constants you think you may use
    private Constants() {
    }
    public static final int CONSTANT = 0;
    public static final int NULL_INTEGER = -1;

    public static final int BASE_XP = 250;
    public static final int LEVEL_UP_XP = 50;

    public static final int STEP_XP_KILL = 200;
    public static final int MULTIPLIER_XP_KILL = 40;

    public static final int ROGUE_HP = 600;
    public static final int ROGUE_INITIAL_HP = 600;
    public static final int ROGUE_LEVELING_HP = 40;
    public static final int STAB_MAGIC = 3;

    public static final int KNIGHT_HP = 900;
    public static final int KNIGHT_INITIAL_HP = 900;
    public static final int KNIGHT_LEVELING_HP = 80;

    public static final int PYROMANCER_HP = 500;
    public static final int PYROMANCER_INITIAL_HP = 500;
    public static final int PYROMANCER_LEVELING_HP = 50;

    public static final int WIZARD_HP = 400;
    public static final int WIZARD_INITIAL_HP = 400;
    public static final int WIZARD_LEVELING_HP = 30;

    //LAND_MODIFIERS
    public static final float NO_BONUS_LAND = 1.0f;
    public static final float ROGUE_WOODS = 1.15f;
    public static final float WIZARD_DESERT = 1.10f;
    public static final float KNIGHT_LAND = 1.15f;
    public static final float PYROMANCER_VOLCANIC = 1.25f;


    //RACE_KNIGHT
    public static final float EXECUTE_KNIGHT = 1.0f;
    public static final float EXECUTE_PYROMANCER = 1.1f;
    public static final float EXECUTE_ROGUE = 1.15f;
    public static final float EXECUTE_WIZARD = 0.8f;

    public static final float SLAM_KNIGHT = 1.2f;
    public static final float SLAM_PYROMANCER = 0.9f;
    public static final float SLAM_ROGUE = 0.8f;
    public static final float SLAM_WIZARD = 1.05f;


    //RACE_PYROMANCER
    public static final float FIREBLAST_KNIGHT = 1.2f;
    public static final float FIREBLAST_PYROMANCER = 0.9f;
    public static final float FIREBLAST_ROGUE = 0.8f;
    public static final float FIREBLAST_WIZARD = 1.05f;

    public static final float IGNITE_KNIGHT = 1.2f;
    public static final float IGNITE_PYROMANCER = 0.9f;
    public static final float IGNITE_ROGUE = 0.8f;
    public static final float IGNITE_WIZARD = 1.05f;


    //RACE_ROGUE
    public static final float BACKSTAB_KNIGHT = 0.9f;
    public static final float BACKSTAB_PYROMANCER = 1.25f;
    public static final float BACKSTAB_ROGUE = 1.2f;
    public static final float BACKSTAB_WIZARD = 1.25f;

    public static final float PARALYSIS_KNIGHT = 0.8f;
    public static final float PARALYSIS_PYROMANCER = 1.2f;
    public static final float PARALYSIS_ROGUE = 0.9f;
    public static final float PARALYSIS_WIZARD = 1.25f;


    //RACE_WIZARD
    public static final float DRAIN_KNIGHT = 1.2f;
    public static final float DRAIN_PYROMANCER = 0.9f;
    public static final float DRAIN_ROGUE = 0.8f;
    public static final float DRAIN_WIZARD = 1.05f;

    public static final float DEFLECT_KNIGHT = 1.4f;
    public static final float DEFLECT_PYROMANCER = 1.3f;
    public static final float DEFLECT_ROGUE = 1.2f;
    public static final float DEFLECT_WIZARD = 0.0f;
}

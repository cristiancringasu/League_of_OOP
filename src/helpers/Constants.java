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

    public static final int FIRST_ABILITY = 0;
    public static final int SECOND_ABILITY = 0;

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


    //__________________________ANGELS___________________________\\
    //DAMAGE_ANGEL
    public static final float  DA_KNIGHT_MODIFICATION = -0.15f;
    public static final float  DA_PYROMANCER_MODIFICATION = -0.20f;
    public static final float  DA_ROGUE_MODIFICATION = -0.30f;
    public static final float  DA_WIZARD_MODIFICATION = -0.40f;

    //DARK_ANGEL
    public static final int  DK_KNIGHT_HP = 40;
    public static final int  DK_PYROMANCER_HP = 30;
    public static final int  DK_ROGUE_HP = 10;
    public static final int  DK_WIZARD_HP = 20;

    //DRACULA
    public static final float  DR_KNIGHT_MODIFICATION = -0.15f;
    public static final float  DR_PYROMANCER_MODIFICATION = -0.20f;
    public static final float  DR_ROGUE_MODIFICATION = -0.30f;
    public static final float  DR_WIZARD_MODIFICATION = -0.40f;

    public static final int  DR_KNIGHT_HP = 40;
    public static final int  DR_PYROMANCER_HP = 30;
    public static final int  DR_ROGUE_HP = 10;
    public static final int  DR_WIZARD_HP = 20;

    //GOOD_BOY
    public static final float  GB_KNIGHT_MODIFICATION = 0.4f;
    public static final float  GB_PYROMANCER_MODIFICATION = 0.5f;
    public static final float  GB_ROGUE_MODIFICATION = 0.4f;
    public static final float  GB_WIZARD_MODIFICATION = 0.3f;

    public static final int  GB_KNIGHT_HP = 20;
    public static final int  GB_PYROMANCER_HP = 30;
    public static final int  GB_ROGUE_HP = 40;
    public static final int  GB_WIZARD_HP = 50;

    //LEVEL_UP_ANGEL
    public static final float  LV_KNIGHT_MODIFICATION = 0.1f;
    public static final float  LV_PYROMANCER_MODIFICATION = 0.2f;
    public static final float  LV_ROGUE_MODIFICATION = 0.15f;
    public static final float  LV_WIZARD_MODIFICATION = 0.25f;

    //LIFE_GIVER
    public static final int  LG_KNIGHT_HP = 100;
    public static final int  LG_PYROMANCER_HP = 80;
    public static final int  LG_ROGUE_HP = 90;
    public static final int  LG_WIZARD_HP = 120;

    //SMALL_ANGEL
    public static final float  SM_KNIGHT_MODIFICATION = 0.1f;
    public static final float  SM_PYROMANCER_MODIFICATION = 0.15f;
    public static final float  SM_ROGUE_MODIFICATION = 0.04f;
    public static final float  SM_WIZARD_MODIFICATION = 0.1f;

    public static final int  SM_KNIGHT_HP = 10;
    public static final int  SM_PYROMANCER_HP = 15;
    public static final int  SM_ROGUE_HP = 20;
    public static final int  SM_WIZARD_HP = 25;

    //SPAWNER
    public static final int  SW_KNIGHT_HP = 200;
    public static final int  SW_PYROMANCER_HP = 150;
    public static final int  SW_ROGUE_HP = 180;
    public static final int  SW_WIZARD_HP = 120;

    //THE_DOOMER
    public static final int  DOOMER_HP = 0;

    //XP_ANGEL
    public static final int  XA_KNIGHT_XP = 45;
    public static final int  XA_PYROMANCER_XP = 50;
    public static final int  XA_ROGUE_XP = 40;
    public static final int  XA_WIZARD_XP = 60;
}

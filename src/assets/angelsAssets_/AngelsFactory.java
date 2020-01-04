package assets.angelsAssets_;

import assets.angelsAssets_.implementedAngels.DamageAngel;
import assets.angelsAssets_.implementedAngels.DarkAngel;
import assets.angelsAssets_.implementedAngels.Dracula;
import assets.angelsAssets_.implementedAngels.GoodBoy;
import assets.angelsAssets_.implementedAngels.LevelUpAngel;
import assets.angelsAssets_.implementedAngels.LifeGiver;
import assets.angelsAssets_.implementedAngels.SmallAngel;
import assets.angelsAssets_.implementedAngels.Spawner;
import assets.angelsAssets_.implementedAngels.TheDoomer;
import assets.angelsAssets_.implementedAngels.XPAngel;
import assets.playerAssets_.Player;
import assets.playerAssets_.implementedPlayers.Knight;
import assets.playerAssets_.implementedPlayers.Pyromancer;
import assets.playerAssets_.implementedPlayers.Rogue;
import assets.playerAssets_.implementedPlayers.Wizard;
import helpers.IntegerTulep;


public final class AngelsFactory {
    private static AngelsFactory instance = null;
    //private final ArrayList<Player> playersById;

    private AngelsFactory() {
        //playersById = new ArrayList<>();
    }

    public static AngelsFactory getInstance() {
        if (instance == null) {
            instance = new AngelsFactory();
        }
        return instance;
    }

    public Angel newAngel(final String a, final IntegerTulep position, final int round) {
        switch (a) {
            case "DamageAngel":
                return new DamageAngel(position,round);
            case "DarkAngel":
                return new DarkAngel(position,round);
            case "Dracula":
                return new Dracula(position,round);
            case "GoodBoy":
                return new GoodBoy(position,round);
            case "LevelUpAngel":
                return new LevelUpAngel(position,round);
            case "LifeGiver":
                return new LifeGiver(position,round);
            case "SmallAngel":
                return new SmallAngel(position,round);
            case "Spawner":
                return new Spawner(position,round);
            case "TheDoomer":
                return new TheDoomer(position,round);
            case "XPAngel":
                return new XPAngel(position,round);
            default : break;
        }
        return null;
    }
}

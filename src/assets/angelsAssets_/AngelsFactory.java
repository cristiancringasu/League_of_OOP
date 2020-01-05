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
import assets.observerAssets_.GreatMagician;
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
        Angel newAngel = null;
        switch (a) {
            case "DamageAngel":
                newAngel = new DamageAngel(position, round);
                break;
            case "DarkAngel":
                newAngel = new DarkAngel(position, round);
                break;
            case "Dracula":
                newAngel = new Dracula(position, round);
                break;
            case "GoodBoy":
                newAngel = new GoodBoy(position, round);
                break;
            case "LevelUpAngel":
                newAngel = new LevelUpAngel(position, round);
                break;
            case "LifeGiver":
                newAngel = new LifeGiver(position, round);
                break;
            case "SmallAngel":
                newAngel = new SmallAngel(position, round);
                break;
            case "Spawner":
                newAngel = new Spawner(position, round);
                break;
            case "TheDoomer":
                newAngel = new TheDoomer(position, round);
                break;
            case "XPAngel":
                newAngel = new XPAngel(position, round);
                break;
            default : break;
        }
        if (newAngel != null) {
            newAngel.addObserver(GreatMagician.getInstance());
        }
        return newAngel;
    }
}

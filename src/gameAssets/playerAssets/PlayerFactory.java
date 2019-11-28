package gameAssets.playerAssets;

import gameAssets.playerAssets.implementedPlayers.Knight;
import gameAssets.playerAssets.implementedPlayers.Pyromancer;
import gameAssets.playerAssets.implementedPlayers.Rogue;
import gameAssets.playerAssets.implementedPlayers.Wizard;
import helpers.IntegerTulep;


public class PlayerFactory {
    private static PlayerFactory instance = null;
    //private final ArrayList<Player> playersById;

    private PlayerFactory() {
        //playersById = new ArrayList<>();
    }

    public static PlayerFactory getInstance() {
        if (instance == null) {
            instance = new PlayerFactory();
        }
        return instance;
    }

    /*
    public void addPlayer(Character p, IntegerTulep position) {
        switch (p) {
            case 'W':
                playersById.add(new Wizard(position));
                break;
            case 'R':
                playersById.add(new Rogue(position));
                break;
            case 'P':
                playersById.add(new Pyromancer(position));
                break;
            case 'K':
                playersById.add(new Knight(position));
                break;
            default : break;
        }
    }

    public Player getPlayer(int index) {
        return playersById.get(index);
    }

    public ArrayList<Player> getAllPlayers() {
        return playersById;
    }

     */

    public Player newPlayer(Character p, IntegerTulep position) {
        switch (p) {
            case 'W':
                return new Wizard(position);
            case 'R':
                return new Rogue(position);
            case 'P':
                return new Pyromancer(position);
            case 'K':
                return new Knight(position);
            default : break;
        }
        return null;
    }
}

package assets.playerAssets_;

import assets.observerAssets_.GreatMagician;
import assets.playerAssets_.implementedPlayers.Knight;
import assets.playerAssets_.implementedPlayers.Pyromancer;
import assets.playerAssets_.implementedPlayers.Rogue;
import assets.playerAssets_.implementedPlayers.Wizard;
import helpers.IntegerTulep;


public final class PlayerFactory {
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

    public Player newPlayer(final Character p, final IntegerTulep position) {
        Player newPlayer = null;
        switch (p) {
            case 'W':
                newPlayer = new Wizard(position);
                break;
            case 'R':
                newPlayer = new Rogue(position);
                break;
            case 'P':
                newPlayer = new Pyromancer(position);
                break;
            case 'K':
                newPlayer = new Knight(position);
                break;
            default : break;
        }
        if (newPlayer != null) {
            newPlayer.addObserver(GreatMagician.getInstance());
        }
        return newPlayer;
    }
}

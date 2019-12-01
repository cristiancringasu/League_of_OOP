package assets.mapAssets_;

import helpers.IntegerTulep;

public final class GameMap {
    private static GameMap instance = null;
    private LandType[][] map;
    private IntegerTulep size;

    private GameMap(final IntegerTulep size) {
        this.size = size;
        this.map = new LandType[size.getFirst()][size.getSecond()];
    }

    public static GameMap initInstance(final IntegerTulep size) {
        if (instance == null) {
            instance = new GameMap(size);
        }
        return instance;
    }

    public static GameMap getInstance() {
        return instance;
    }

    public LandType[][] getMap() {
        return map;
    }

    public void setMap(final LandType[][] map) {
        this.map = map;
    }

    public IntegerTulep getSize() {
        return size;
    }

    public void setSize(final IntegerTulep size) {
        this.size = size;
    }

    public LandType parseLandType(final Character l) {
        switch (l) {
            case 'L':
                return LandType.Land;
            case 'V':
                return LandType.Volcanic;
            case 'D':
                return LandType.Desert;
            case 'W':
                return LandType.Woods;
            default : break;
        }
        return null;
    }

    public void setMapCell(final IntegerTulep position, final LandType type) {
        this.map[position.getFirst()][position.getSecond()] = type;
    }

    public void setMapCellCharacter(final IntegerTulep position, final Character l) {
        LandType type = parseLandType(l);
        this.map[position.getFirst()][position.getSecond()] = type;
    }

    public LandType getMapCell(final IntegerTulep position) {
        return this.map[position.getFirst()][position.getSecond()];
    }
}

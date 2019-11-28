package gameAssets.mapAssets;

import helpers.IntegerTulep;

public final class GameMap {
    private static GameMap instance = null;
    private LandType[][] map;
    private IntegerTulep size;

    private GameMap(IntegerTulep size) {
        this.size = size;
        this.map = new LandType[size.getFirst()][size.getSecond()];
    }

    public static GameMap initInstance(IntegerTulep size) {
        if(instance == null)
            instance = new GameMap(size);
        return instance;
    }

    public static GameMap getInstance() {
        return instance;
    }

    public LandType[][] getMap() {
        return map;
    }

    public void setMap(LandType[][] map) {
        this.map = map;
    }

    public IntegerTulep getSize() {
        return size;
    }

    public void setSize(IntegerTulep size) {
        this.size = size;
    }

    public LandType parseLandType(Character l) {
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

    public void setMapCell(IntegerTulep position, LandType type) {
        this.map[position.getFirst()][position.getSecond()] = type;
    }

    public void setMapCellCharacter(IntegerTulep position, Character l) {
        LandType type = parseLandType(l);
        this.map[position.getFirst()][position.getSecond()] = type;
    }

    public LandType getMapCell(IntegerTulep position) {
        return this.map[position.getFirst()][position.getSecond()];
    }
}

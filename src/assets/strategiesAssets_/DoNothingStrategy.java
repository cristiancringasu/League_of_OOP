package assets.strategiesAssets_;

import assets.playerAssets_.Player;

public class DoNothingStrategy implements PlayerStrategy {
    @Override
    public void applyStrategy(Player invoker) {
        return;
    }
}

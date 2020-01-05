package assets.strategiesAssets_;

import assets.playerAssets_.Player;

public final class DoNothingStrategy implements PlayerStrategy {
    @Override
    public void applyStrategy(final Player invoker) {
        return;
    }
}

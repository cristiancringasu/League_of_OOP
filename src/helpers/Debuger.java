package helpers;

public final class Debuger {
    private static Debuger instance = null;

    private Debuger() {
    }

    public static Debuger getInstance() {
        if (instance == null) {
            instance = new Debuger();
        }

        return instance;
    }
}

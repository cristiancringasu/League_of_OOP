package helpers;

import java.util.Comparator;

public final class IntegerTulepComparator implements Comparator<IntegerTulep> {
    private static IntegerTulepComparator instance = null;

    private IntegerTulepComparator() {
    }

    public static IntegerTulepComparator getInstance() {
        if (instance == null) {
            instance = new IntegerTulepComparator();
        }

        return instance;
    }

    public int compare(final IntegerTulep it1, final IntegerTulep it2) {
        return it2.getFirst() - it1.getFirst();
    }
}

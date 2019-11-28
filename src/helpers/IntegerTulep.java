package helpers;

import java.util.Objects;

public final class IntegerTulep {
    private int a;
    private int b;

    public IntegerTulep(final int a, final int b) {
        this.a = a;
        this.b = b;
    }

    public int getFirst() {
        return a;
    }

    public void setFirst(final int value) {
        a = value;
    }

    public int getSecond() {
        return b;
    }

    public void setSecond(final int value) {
        b = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof IntegerTulep)) {
            return false;
        }
        IntegerTulep that = (IntegerTulep) o;
        return a == that.a &&
                b == that.b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }
}

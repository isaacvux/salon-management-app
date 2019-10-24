package salon.util;

import java.io.Serializable;

public class DoubleWrapper implements Serializable {
    private double value;

    public DoubleWrapper(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}

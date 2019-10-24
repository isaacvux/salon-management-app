package salon.util;

import java.io.Serializable;

public class IntWrapper implements Serializable {
    private int value;

    public IntWrapper(int value){
        this.value = value;
    }

    public IntWrapper(){}

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

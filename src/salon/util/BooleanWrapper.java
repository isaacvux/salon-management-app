package salon.util;

import java.io.Serializable;

public class BooleanWrapper implements Serializable {
    private boolean flag;

    public BooleanWrapper(boolean flag) {
        this.flag = flag;
    }

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}

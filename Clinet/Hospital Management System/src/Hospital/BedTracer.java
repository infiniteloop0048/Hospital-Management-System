package Hospital;

import java.io.Serializable;

public class BedTracer implements Serializable {

     boolean[] alocateBed={true,true,true,true};

    public boolean[] getAlocateBed() {
        return alocateBed;
    }

    public void setAlocateBed(boolean[] alocateBed) {
        this.alocateBed = alocateBed;
    }
}

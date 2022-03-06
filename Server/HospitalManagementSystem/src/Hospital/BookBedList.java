package Hospital;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class BookBedList implements Serializable {
    List<BookedBed> bedList=new ArrayList<>();

    public List<BookedBed> getBedList() {
        return bedList;
    }

    public void setBedList(List<BookedBed> bedList) {
        this.bedList = bedList;
    }
}

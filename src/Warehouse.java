import java.util.ArrayList;

public class Warehouse {
    private ArrayList<BikePart> parts;


public Warehouse(){
    this.parts = new ArrayList();
}
public void addPart(String info){
    BikePart newP = new BikePart(info);
    this.parts.add(newP);
}
}















package sharpieset;

import java.util.ArrayList;
import java.util.List;

public class SharpieSet {
    List<Sharpie> listOfSharpies = new ArrayList<>();

    public void add(Sharpie sharpie) {
        listOfSharpies.add(sharpie);
    }

    public int countUsable() {
        int usableCount = 0;
        for (Sharpie sharpie : listOfSharpies) {
            if (sharpie.getInkAmount() > 0) {
                usableCount++;
            }
        }
        return usableCount;
    }

    public int getSharpiesCount() {
        return listOfSharpies.size();
    }

    public void removeTrash() {
        // option 1
        List<Sharpie> usableSharpies = new ArrayList<>();
        for (Sharpie sharpie : listOfSharpies) {
            if (sharpie.getInkAmount() > 0) {
                usableSharpies.add(sharpie);
            }
        }
        this.listOfSharpies = usableSharpies;
    }
}
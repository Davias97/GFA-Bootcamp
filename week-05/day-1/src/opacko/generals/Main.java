package opacko.generals;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<General> generals = new ArrayList<>();
        General general1 = new RomeEmpireGeneral("Nero Claudius Drusus", 60);
        General general2 = new GreekGeneral("Leonidas", 20);
        generals.add(general2);
        generals.add(general1);
        Fight fight = new Fight(generals);
        System.out.println(fight.forTheEmpire());

    }
}

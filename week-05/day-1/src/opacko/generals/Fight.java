package opacko.generals;

import opacko.generals.General;

import java.util.ArrayList;
import java.util.List;

public class Fight {

        protected List<General> generals;

    public Fight(List<General> generals) {
        this.generals = generals;
    }


    public List<RomeEmpireGeneral> forTheEmpire() {
        List<RomeEmpireGeneral> romeGenerals = new ArrayList<>();
        for (General general : generals) {
            if (general instanceof  RomeEmpireGeneral && general.getMotivationLevel() == 2) {
                romeGenerals.add((RomeEmpireGeneral) general);
            }
        }
        return romeGenerals;
    }
}
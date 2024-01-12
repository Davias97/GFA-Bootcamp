package opacko.generals;

public class General {
    protected String name;
    protected int motivation;

    public General() {

    }
    public General(String name, int motivation) {
        this.name = name;
        this.motivation = motivation;
    }

    public int getMotivationLevel() {
        if (this.motivation <= 25) {
            return 0;
        } else if (this.motivation < 40) {
            return 1;
        } else {
            return 2;
        }
    }

    public int punch(General general) {
        double damage;
        if (this.motivation > 1) {
            damage = this.motivation / 1.5;
            general.bePunched((int) damage);
        } else {
            throw new IllegalArgumentException("Generals motivation is less than 1");
        }
        return (int) damage;
    }

    public void bePunched(int damage) {
        damage = (int) Math.ceil(damage / ((double) motivation / 2));
        this.motivation -= damage;
    }

    @Override
    public String toString() {
        if (getMotivationLevel() == 0) {
            return name + " is not motivated anymore.";
        } else if (getMotivationLevel() == 1) {
            return name + " is motivated.";
        } else {
            return name + " is well motivated.";
        }
    }
}

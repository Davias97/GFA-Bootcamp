package animal;

public class Animal {

    int hunger = 50;
    int thirst = 50;

    public void eat() {
        this.hunger = hunger - 1;
    }

    public void drink() {

        this.thirst = thirst - 1;
    }

    public void play() {
        this.hunger = hunger + 1;
        this.thirst = thirst + 1;
    }
}

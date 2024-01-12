package sharpieset;

public class Main {
    public static void main(String[] args) {
        Sharpie lol = new Sharpie("blue", 100);
        Sharpie blazeIt = new Sharpie("green", 420);
        Sharpie devil = new Sharpie("black", 666);

        SharpieSet sharpieSet = new SharpieSet();
        sharpieSet.add(lol);
        sharpieSet.add(blazeIt);
        sharpieSet.add(devil);

        for (int i = 0; i < 10; i++) {
            devil.use();
        }

        System.out.println(sharpieSet.getSharpiesCount());

        sharpieSet.removeTrash();

        System.out.println(sharpieSet.getSharpiesCount());
    }
}
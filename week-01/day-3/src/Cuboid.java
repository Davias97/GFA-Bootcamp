public class Cuboid {
    public static void main(String[] args) {
        // Write a program that stores 3 sides of a cuboid as variables (doubles)
        // The program should write the surface area and volume of the cuboid.
        //
        // Set the 3 sides to 10.4, 13.5, 8.2 and your program should
        // produce the following output:
        //
        // Surface Area: 672.76
        // Volume: 1151.28
        double side1 = 10.4;
        double side2 = 13.5;
        double side3= 8.2;

        System.out.println("Surface Area: "+ ((2*side1*side2)+(2*side1*side3)+(2*side2*side3)));
        System.out.println("Volume: "+ (side1*side2*side3));
    }
}
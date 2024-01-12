package com.greenfoxacademy.music;

public class Violin extends StringedInstrument {

    String violinSound = "Screech";
    public Violin(int i) {
        numberOfStrings = i;
        nameOfTheInstrument = "Violin";
    }
    public Violin() {
        numberOfStrings = 4;
        nameOfTheInstrument = "Violin";
    }
    public void play() {
        System.out.println(nameOfTheInstrument + ", a " + numberOfStrings + "-stringed instrument that goes " + violinSound);
    }
}

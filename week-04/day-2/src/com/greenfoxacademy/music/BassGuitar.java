package com.greenfoxacademy.music;

public class BassGuitar extends StringedInstrument{

    String bguitarSound = "Duum-duum-duum";

    public BassGuitar(int i) {
        numberOfStrings = i;
        nameOfTheInstrument = "Bass Guitar";
    }
    public BassGuitar() {
        numberOfStrings = 4;
        nameOfTheInstrument = "Bass Guitar";
    }
    public void play() {
        System.out.println(nameOfTheInstrument + ", a " + numberOfStrings + "-stringed instrument that goes " + bguitarSound);
    }
}

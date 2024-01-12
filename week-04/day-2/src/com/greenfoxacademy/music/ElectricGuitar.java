package com.greenfoxacademy.music;

public class ElectricGuitar extends StringedInstrument {

    String eguitarSound = "Twang";

    public ElectricGuitar(int i) {
        numberOfStrings = i;
        nameOfTheInstrument = "Electric Guitar";
    }
    public ElectricGuitar() {
        numberOfStrings = 6;
        nameOfTheInstrument = "Electric Guitar";
    }
    public void play() {
        System.out.println(nameOfTheInstrument + ", a " + numberOfStrings + "-stringed instrument that goes " + eguitarSound);
    }
}


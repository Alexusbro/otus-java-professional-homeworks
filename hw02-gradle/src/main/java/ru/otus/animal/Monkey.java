package ru.otus.animal;

public class Monkey extends Animal{
    private String species;
    private String name;

    public Monkey(String name) {
        this.species = "monkey";
        this.name = name;
    }

    @Override
    public String getSpecies() {
        return species;
    }

    @Override
    public String getName() {
        return name;
    }
}

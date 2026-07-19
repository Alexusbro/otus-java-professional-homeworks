package ru.otus.animal;

public class Dog extends Animal{
    private String species;
    private String name;

    public Dog(String name) {
        this.species = "Dog";
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

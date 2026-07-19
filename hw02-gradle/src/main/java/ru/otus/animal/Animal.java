package ru.otus.animal;

public abstract class Animal {
    abstract String getSpecies();

    abstract String getName();

    String describe() {
        return getSpecies() + " " + getName();
    }

    @Override
    public String toString() {
        return describe();
    }
}
package ru.otus.animal;

public class Tiger extends Animal {
    private String species;
    private String name;

    public Tiger(String name) {
        this.species = "tiger";
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

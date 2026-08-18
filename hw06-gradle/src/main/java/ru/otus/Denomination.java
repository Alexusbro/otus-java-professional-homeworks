package ru.otus;

public enum Denomination {
    TEN(10),
    FIFTY(50),
    HUNDRED(100),
    FIVE_HUNDRED(500);

    private final int nominal;

    Denomination(int nominal) {
        this.nominal = nominal;
    }

    public int getNominal() {
        return nominal;
    }
}

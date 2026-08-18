package ru.otus;

public class Cell {
    private final Denomination denomination;
    private int countBanknote;

    public Cell(Denomination denomination, int countBanknote) {
        this.denomination = denomination;
        this.countBanknote = countBanknote;
    }

    public Denomination getDenomination() {
        return denomination;
    }

    public int getCountBanknote() {
        return countBanknote;
    }

    public int getBalanceCell() {
        return denomination.getNominal() * countBanknote;
    }

    public void addCash(int count) {
        if (count < 0 ) {
            throw new IllegalArgumentException("нельзя внести отрицательную сумму");
        }
        countBanknote += count;
    }

    public void getBanknote(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("сумма для снятия не может быть отрицательной");
        }

        if (countBanknote < count) {
            throw new IllegalStateException("недостаточно денег в ячейке");
        }

        countBanknote -= count;
    }
}

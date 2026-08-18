package ru.otus;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CashProvider implements Provider{

    @Override
    public void putBanknote(Map<Denomination, Integer> collectBanknotes, Map<Denomination, Cell> cellMap) {
        for (Map.Entry<Denomination, Integer> entry : collectBanknotes.entrySet()) {
            Cell cell = cellMap.get(entry.getKey());
            if (cell == null) {
                throw new IllegalStateException("нет ячейки для номинала " + entry.getKey());
            }
            cell.addCash(entry.getValue());
        }
    }

    @Override
    public Map<Denomination, Integer> decreaseCountBanknote(int cashToGet, Map<Denomination, Cell> cellMap) {
        Map<Denomination, Integer> cellsToGet = banknoteSelector(cashToGet, cellMap);
        for (Map.Entry<Denomination, Integer> entry : cellsToGet.entrySet()) {
            Cell cell = cellMap.get(entry.getKey());
            cell.getBanknote(entry.getValue());
        }
        return cellsToGet;
    }

    public Map<Denomination, Integer> banknoteSelector(int cashToGet, Map<Denomination, Cell> cellMap) {
        Map<Denomination, Integer> banknotesToGet = new HashMap<>();
        int remainingCash = cashToGet;
        List<Cell> sortedCells = cellMap.values().stream().sorted((Comparator.comparingInt((Cell cell) -> cell.getDenomination().getNominal()).reversed())).toList();
        for (Cell cell : sortedCells) {
            int countBanknoteToGet = remainingCash / cell.getDenomination().getNominal();
            countBanknoteToGet = Math.min(countBanknoteToGet, cell.getCountBanknote());
            banknotesToGet.put(cell.getDenomination(), countBanknoteToGet);
            remainingCash -= countBanknoteToGet * cell.getDenomination().getNominal();
        }
        if (remainingCash != 0) {
            throw new IllegalStateException("нет возможности выдать указанную сумму");
        }
        return banknotesToGet;
    }

}

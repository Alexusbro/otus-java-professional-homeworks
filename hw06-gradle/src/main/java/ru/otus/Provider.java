package ru.otus;

import java.util.Map;

public interface Provider {
    public void putBanknote(Map<Denomination, Integer> collectBanknotes, Map<Denomination, Cell> cellMap);
    public Map<Denomination, Integer> decreaseCountBanknote(int cashToGet, Map<Denomination, Cell> cellMap);

}

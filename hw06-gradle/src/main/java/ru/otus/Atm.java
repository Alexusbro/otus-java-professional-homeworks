package ru.otus;

import java.util.HashMap;
import java.util.Map;

public class Atm {
    private final Map<Denomination, Cell> cellMap;
    private final Provider provider;

    public Atm(Provider provider) {
        AtmInit atmInit = new AtmInit();
        this.provider = provider;
        cellMap = atmInit.init();

    }

    public int getBalance() {
        int balance = 0;
        balance = cellMap.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getNominal() * entry.getValue().getCountBanknote())
                .sum();
        return balance;
    }

    public void addCash(Map<Denomination, Integer> collectBanknotes) {
        provider.putBanknote(collectBanknotes, cellMap);
    }

    public Map<Denomination, Integer> getCash(int cashToGet) {
        return provider.decreaseCountBanknote(cashToGet, cellMap);
    }
}

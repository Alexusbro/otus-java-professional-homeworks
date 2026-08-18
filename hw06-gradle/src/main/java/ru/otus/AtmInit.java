package ru.otus;

import java.util.HashMap;
import java.util.Map;

public class AtmInit {
    public Map<Denomination, Cell> init() {
        Map<Denomination, Cell> cellMap = new HashMap<>();
        cellMap.put(Denomination.TEN, new Cell(Denomination.TEN, 20));
        cellMap.put(Denomination.FIFTY, new Cell(Denomination.FIFTY, 10));
        cellMap.put(Denomination.HUNDRED, new Cell(Denomination.HUNDRED, 10));
        cellMap.put(Denomination.FIVE_HUNDRED, new Cell(Denomination.FIVE_HUNDRED, 1));
        return cellMap;
    }

}

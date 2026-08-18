package ru.otus;

public class App {
    public static void main(String[] args) {
    Atm atm = new Atm(new CashProvider());
        System.out.println(atm.getBalance());
    }
}

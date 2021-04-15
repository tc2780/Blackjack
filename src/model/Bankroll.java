package model;

public class Bankroll {

    private double amount;

    public Bankroll(double amount) {
        this.amount = amount;
    }

    public void withdraw(double bet) {
        amount -= bet;
    }

    public void deposit(double bet) {
        amount += bet;
    }

    public double getAmount() {
        return amount;
    }

    public String toString() {
        return "" + amount;
    }
}

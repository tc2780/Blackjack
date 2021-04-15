package model;

public class Card {

    private String number;
    private String suit;

    public Card(String number, String suit) {
        this.number = number;
        this.suit = suit;
    }

    //returns value of cards, Ace is 11
    public int getCardValue() {
        if (number.equals("2")) {
            return 2;
        }
        if (number.equals("3")) {
            return 3;
        }
        if (number.equals("4")) {
            return 4;
        }
        if (number.equals("5")) {
            return 5;
        }
        if (number.equals("6")) {
            return 6;
        }
        if (number.equals("7")) {
            return 7;
        }
        if (number.equals("8")) {
            return 8;
        }
        if (number.equals("9")) {
            return 9;
        }
        if (number.equals("A")) {
            return 11;
        }
        return 10;
    }

    public String getNumber() {
        return number;
    }

    public String toString() {
        return number + suit;
    }
}

package model;

import java.util.ArrayList;

public class Hand {

    private ArrayList<Card> hand;

    public Hand() {
        hand = new ArrayList<Card>();
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public Card getCard(int x) {
        return hand.get(x);

    }

    public void removeCard(int x) {
        hand.remove(x);
    }

    public int getNumCards() {
        return hand.size();
    }

    //returns total of cards in the hand
    public int getTotal() {
        int sum = 0;
        boolean containsAce = false;
        for (int i = 0; i < hand.size(); i++) {
            sum += hand.get(i).getCardValue();
            if (hand.get(i).getNumber().equals("A")) {
                containsAce = true;
            }
        }
        //if sum is over 21 and there is an Ace, then Ace acts as 1 and not 11
        if (sum > 21 && containsAce) {
            sum -= 10;
        }
        return sum;
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < hand.size(); i++) {
            str += hand.get(i) + " ";
        }
        return str;
    }
}

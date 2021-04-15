package model;

import java.util.ArrayList;
import java.util.Random;

public class Deck {

    private ArrayList<Card> stack;
    private static int currentCardNumb = 0;

    public Deck() {
        stack = new ArrayList<Card>();

        String[] suits = {"S", "H", "C", "D"};
        String[] numbers = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        //fills deck with all possible cards, 52
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                stack.add(new Card(numbers[j], suits[i]));
            }
        }
    }

    public String toString() {
        String str = "";
        for (int i = currentCardNumb; i < 52; i++) {
            str += stack.get(i).toString() + " ";
        }
        return str;
    }

    //returns a random card, removes it from current spot and moves it to front of array,
    // updates the currentCardNumb so it doesnt use choose index numbers of cards that
    // have already been used
    public Card drawCard() {
        // checks if all 52 cards have been used, if yes then reshuffles cards
        if (currentCardNumb == 52) {
            System.out.println();
            System.out.println("You have run out of cards. Reshuffling.");
            this.shuffle();
        }
        Random random = new Random();
        int rand = random.nextInt(52 - currentCardNumb) + currentCardNumb;
        Card next = stack.get(rand);
        stack.remove(rand);
        stack.add(0, next);
        currentCardNumb++;
        return next;
    }

    // shuffles by setting the currentCardNumb to 0
    // makes all cards available for use again
    public void shuffle() {
        currentCardNumb = 0;
    }
}

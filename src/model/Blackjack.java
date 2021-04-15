package model;

import java.util.Scanner;

public class Blackjack {
    private Hand playerHand;
    private Hand dealerHand;
    private Deck deck;
    private Bankroll bankroll;
    private Scanner console;
    private double bet = 0;

    public Blackjack() {
        console = new Scanner(System.in);
        deck = new Deck();
        playerHand = new Hand();
        dealerHand = new Hand();
        bankroll = new Bankroll(100);
    }

    public void playGame() {
        System.out.println("Starting bankroll: " + bankroll);
        String newGame = "y";
        //keeps looping if player wants to play another round
        while (newGame.equals("y")) {
            dealNewCards();
            if (bankroll.getAmount() == 0) {
                System.out.println("You have lost all your money.");
                break;
            }
            getBet();
            //Prints out first cards of player and hand in each game--dealer only has 1 face up card
            System.out.println("Player: " + playerHand + "(" + playerHand.getTotal() + ")");
            System.out.println("Dealer: X " + dealerHand.getCard(1));
            playTurn();
            dealerTurn();
            checkWinner();
            System.out.print("Play again? (Y/N): ");
            newGame = console.nextLine().toLowerCase();
            //asks user to enter y or n if they entered something different
            while (!newGame.equals("y") && !newGame.equals("n")) {
                System.out.print("Please enter Y/N: ");
                newGame = console.nextLine().toLowerCase();
            }
            deck.shuffle();
            System.out.println("---------------");
        }
        System.out.println("Thanks for playing!");
        System.out.println("Ending bankroll: " + bankroll.getAmount());
    }

    public void playTurn() {
        //loops again if user hits
        while (true) {
            System.out.print("Hit or stand? ");
            String next = console.nextLine().toLowerCase();
            //checks if user has entered hit/stand. if not, asks user to enter again until it is
            while (!next.equals("hit") && !next.equals("stand")) {
                System.out.print("Please enter hit or stand: ");
                next = console.nextLine().toLowerCase();
            }
            //if user enters hit, card gets added to hand and total is printed out
            if (next.equals("hit")) {
                playerHand.addCard(deck.drawCard());
                System.out.println(playerHand + "(" + playerHand.getTotal() + ")");
                //checks if hand total is over 21, if it is, player busts and loop breaks
                if (playerHand.getTotal() > 21) {
                    System.out.println("Player busts!");
                    break;
                }
            }
            //if user enters stand, the loop breaks and the game continues
            if (next.equals("stand")) {
                break;
            }
        }
    }

    public void dealerTurn() {
        System.out.print("Enter for dealer turn...");
        String enter = console.nextLine();
        //checks if user has pressed enter, if not, asks again until entered
        while (!enter.equals("")) {
            System.out.print("Please enter to continue.");
            enter = console.nextLine();
        }
        //dealer hits until total is 17 or over
        //dealer hand gets a card, total is printed out
        while (enter.equals("") && dealerHand.getTotal() < 17) {
            System.out.println("Dealer: " + dealerHand + "(" + dealerHand.getTotal() + ")");
            System.out.println("Dealer's hand has value " + dealerHand.getTotal() + ".");
            System.out.println("Dealer hits.");
            dealerHand.addCard(deck.drawCard());
            System.out.print("Enter to continue...");
            enter = console.nextLine();
            while (!enter.equals("")) {
                System.out.print("Please enter to continue. ");
                enter = console.nextLine();
            }
        }
        System.out.println("Dealer: " + dealerHand + "(" + dealerHand.getTotal() + ")");
        //checks if dealer busts-if not, dealer stands
        if (dealerHand.getTotal() > 21) {
            System.out.println("Dealer busts!");
        } else {
            System.out.println("Dealer stands.");
        }
    }

    //asks for a new bet, checks if bet is over bankroll amount
    public void getBet() {
        System.out.print("What is your bet? ");
        bet = console.nextDouble();
        //String x="";
        //while(bet>bankroll.getAmount())
        //{
        //    System.out.println("You cannot bet that much.");
        // System.out.print("Please enter a new bet: ");
        // bet=console.nextDouble();
        // }
        //while(bet>bankroll.getAmount())
        //{
        //    System.out.print("You bet over your current bankroll. Losing will result in debt. Continue? Y/N: ");
        //    x=console.nextLine().toLowerCase();
        //    if(x.equals("y"))
        //    {
        //        break;
        //    }
        //    System.out.print("Please enter a new bet: ");
        //    bet=console.nextDouble();
        // }
    }

    public void checkWinner() {
        if (playerHand.getTotal() > 21) {
            System.out.println("Dealer wins.");
            bankroll.withdraw(bet);
        } else if (dealerHand.getTotal() > 21 || playerHand.getTotal() > dealerHand.getTotal()) {
            System.out.println("Player win!");
            bankroll.deposit(bet);
        } else if (dealerHand.getTotal() > playerHand.getTotal()) {
            System.out.println("Dealer wins. ");
            bankroll.withdraw(bet);
        } else if (playerHand.getTotal() == dealerHand.getTotal()) {
            System.out.println("Player pushes.");
        }
        System.out.println("Current bankroll: " + bankroll.getAmount());
    }

    //removes all current cards from hand and adds 2 cards to player and dealer hands
    public void dealNewCards() {
        for (int i = playerHand.getNumCards() - 1; i >= 0; i--) {
            playerHand.removeCard(0);
        }
        for (int j = dealerHand.getNumCards() - 1; j >= 0; j--) {
            dealerHand.removeCard(0);
        }
        playerHand.addCard(deck.drawCard());
        playerHand.addCard(deck.drawCard());
        dealerHand.addCard(deck.drawCard());
        dealerHand.addCard(deck.drawCard());
    }
}

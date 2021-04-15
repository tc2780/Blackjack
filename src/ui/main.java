package ui;

import model.Blackjack;

public class main {

    public static void main(String[] args) {
        Blackjack game = new Blackjack();
        game.playGame();
        // Scanner console = new Scanner(System.in);
        //  while(true)
        // {
        //     System.out.print("Hit or stand? ");
        //     String next=console.nextLine().toLowerCase();
        //     //checks if user has entered hit/stand. if not, asks user to enter again until it is
        //     while(!next.equals("hit") && !next.equals("stand"))
        //     {
        //         System.out.print("Please enter hit or stand: ");
        //         next=console.nextLine().toLowerCase();
        //     }
        //     if(next.equals("hit"))
        //     {
        //         // playerHand.addCard(deck.drawCard());
        //         // System.out.println(playerHand+"("+playerHand.getTotal()+")");
        //         // if(playerHand.getTotal()>21)
        //         // {
        //         //     System.out.println("Player busts!");
        //         //     break;
        //         // }
        //     }
        //     if(next.equals("stand"))
        //     {
        //         break;
        //     }
        // }

        //System.out.println("Hello world!");
        //Card one = new Card("10", "J");
        //System.out.println(one);

        //Deck deck= new Deck();
        //System.out.println(deck);

        //Bankroll bank=new Bankroll(100.00);

        //System.out.println(bank);
        //bank.deposit(20);
        //System.out.println(bank);
        //bank.withdraw(30);
        //System.out.println(bank);
        //for(int i=0; i<53; i++)
        //{
        //    System.out.print(deck.drawCard()+" ");
        //}

        //deck.shuffle();
        //System.out.println(deck);
        //System.out.println(deck.drawCard());
        //System.out.println(deck);

        //System.out.println(deck.drawCard());
        //System.out.println(deck);

        //Hand player = new Hand();

        //player.addCard(new Card("2", "D"));
        //System.out.println(deck);
        //System.out.println(player);
        //System.out.println();
        //player.addCard(new Card("10", "S"));
        //player.addCard(new Card("10", "D"));
        //player.addCard(new Card("A", "D"));
        //System.out.println(player);
        //System.out.println(player.getTotal());

    }
}


// 2. TOP - Brainstorm top level considerations:
// - What will the game look like?
// - What are the rules?
// A can be either 11 or 1-depends on rest of hand
// - What needs to happen?
// place a bet
// player given 2 cards
// dealer has 1 known and 1 unknown card
// then player hits until stands
// busts if over 21
// have total value in brackets next to cards
// dealer goes--card, then total value
// unknown card flipped
// until 17. if over 17 must stand
// check who wins
// state current bankroll
// asks to play again
// loops until player says n
// state end bankroll
// - What does the user do?
// place a bet
// hit/stand/push
// - How does the user win?
// get under/equal to 21
// if dealer exceeds 21
// if both under, player>dealer
// if equal-push-no one wins
// if both bust-player loses

// 3. DOWN - Brainstorm classes needed:
// - Break the game down into logical chunks.
// - When is a new class required?
// - What class will you start coding when this process is complete?

// classes:
// card
// suit n number
// deck--holds all 52 cards
// when created--add all possible cards to an arraylist
// draw card--random number--match it to card in list
// bankroll
// has deposit n withdraw
// get current balance
// hand ---holds cards in arraylist
// draw card--from deck--adds card to list
// get total--adds values of cards
// a is the weird one
// blackjack class--call on it to play
// check who wins method--compares player vs comp values
// have a method for the comp turn--hit/stand---<17
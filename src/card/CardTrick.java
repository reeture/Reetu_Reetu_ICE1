/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author srinivsi
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Card {
    private String suit;
    private String value;

    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value + " of " + suit;
    }
}

class MagicHand {
    private List<Card> cards;

    public MagicHand() {
        cards = new ArrayList<>();
    }

    public void fillHand() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] values = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"};

        List<Card> deck = new ArrayList<>();
        for (String suit : suits) {
            for (String value : values) {
                deck.add(new Card(suit, value));
            }
        }

        Random random = new Random();
        for (int i = 0; i < 7; i++) {
            int index = random.nextInt(deck.size());
            cards.add(deck.remove(index));
        }
    }

    public Card pickCard() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pick a card from the magic hand:");
        System.out.print("Enter the suit (Hearts, Diamonds, Clubs, Spades): ");
        String suit = scanner.nextLine();
        System.out.print("Enter the value (1-13): ");
        String value = scanner.nextLine();
        return new Card(suit, value);
    }

    public boolean searchCard(Card userCard) {
        for (Card card : cards) {
            if (card.getSuit().equalsIgnoreCase(userCard.getSuit()) && card.getValue().equalsIgnoreCase(userCard.getValue())) {
                return true;
            }
        }
        return false;
    }
}

public class CardTrick  {
    public static void main(String[] args) {
        MagicHand magicHand = new MagicHand();
        magicHand.fillHand();

        System.out.println("Magic hand filled with 7 random cards.");

        Card userCard = magicHand.pickCard();

        boolean foundMatch = magicHand.searchCard(userCard);
        if (foundMatch) {
            System.out.println("Congratulations! You found a match!");
        } else {
            System.out.println("Sorry, no match found.");
        }
    }
}
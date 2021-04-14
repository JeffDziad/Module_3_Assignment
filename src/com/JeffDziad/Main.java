package com.JeffDziad;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Deck deck = new Deck();
        List<Card> hand = new ArrayList<Card>();
        Scanner keyboard = new Scanner(System.in);
        boolean cont = true;

        do{
            hand.clear();
            hand.add(deck.getCard(randNum()));
            hand.add(deck.getCard(randNum()));
            hand.add(deck.getCard(randNum()));
            hand.add(deck.getCard(randNum()));
            hand.add(deck.getCard(randNum()));

            Hand handObj = new Hand(hand);

            System.out.println("------------------------------------------");
            for (Card card : handObj.getHand()) {
                System.out.println(card);
            }

            System.out.println("------------------------------------------");
            System.out.println("Matching Faces: " + handObj.matchingFaces());
            System.out.println("Four of a kind: " + handObj.fourOfAKind());
            System.out.println("Three of a kind: " + handObj.threeOfAKind());
            System.out.println("Straight Flush: " + handObj.straightFlush());
            System.out.println("Flush: " + handObj.flush());
            System.out.println("Straight: " + handObj.straight());
            System.out.println("Royal Flush: " + handObj.royalFlush());
            System.out.println("------------------------------------------");

            System.out.print("Enter 'end' to close program, or press ENTER to randomize cards: ");
            String input = keyboard.nextLine();
            if(input.toUpperCase().equals("END")) {
                cont = false;
            }

        }while(cont);

    }

    public static int randNum() {
        Random rand = new Random();
        int n = rand.nextInt(53);
        return n;
    }
}

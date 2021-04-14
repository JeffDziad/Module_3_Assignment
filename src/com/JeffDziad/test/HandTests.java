package com.JeffDziad.test;

import com.JeffDziad.Card;
import com.JeffDziad.Deck;
import com.JeffDziad.Hand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HandTests {

    Deck deck = new Deck();
    List<Card> hand = new ArrayList<Card>();
    Hand handObj;

    @BeforeEach
    void runIt() {
        hand.add(deck.getCard(2));
        hand.add(deck.getCard(3));
        hand.add(deck.getCard(4));
        hand.add(deck.getCard(5));
        hand.add(deck.getCard(6));
        handObj = new Hand(hand);
    }

    @Test
    void straight() {
        assertTrue(handObj.straight());
    }

    @Test
    void straightFlush() {
        assertTrue(handObj.straightFlush());
    }

    @Test
    void fourOfAKind() {
        assertTrue(handObj.fourOfAKind());
    }

    @Test
    void threeOfAKind() {
        assertTrue(handObj.threeOfAKind());
    }

    @Test
    void royalFlush() {
        assertTrue(handObj.royalFlush());
    }
}
package com.JeffDziad.test;

import com.JeffDziad.Card;
import com.JeffDziad.Deck;
import com.JeffDziad.Hand;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class HandTest {

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

    @org.junit.jupiter.api.Test
    void straight() {
        assertTrue(handObj.straight());
    }

    @org.junit.jupiter.api.Test
    void straightFlush() {
        assertTrue(handObj.straightFlush());
    }




}
package com.JeffDziad;

import java.util.*;
import java.util.stream.Collectors;

public class Hand {

    List<Card> hand;

    List<String> facesInOrder = new ArrayList<>();

    String[] possibleFaces = {"Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};

    List<String> possibleHands = new ArrayList<String>();

    public Hand(List<Card> hand) {
        this.hand = sortHand(hand);
        populateFacesInOrder();
        matchingFaces();
        flush();
        straight();
        straightFlush();
        fourOfAKind();
        threeOfAKind();
        royalFlush();
    }

    public List<Card> sortHand(List<Card> hand) {
        return hand.stream().sorted(Comparator.comparingInt(Card::getScore)).collect(Collectors.toList());
    }

    public void populateFacesInOrder() {
        for(Card card : hand) {
            facesInOrder.add(card.getFace());
        }
    }

    public List<Card> getHand() {
        return hand;
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

    public boolean matchingFaces() {
        String firstFace = hand.get(0).getSuit();
        for(Card card : hand) {
            if (!(card.getSuit().equals(firstFace))) {
                return false;
            }
        }
        return true;
    }

    public boolean flush() {
        return matchingFaces();
    }

    public boolean straight() {
        int firstScore = hand.get(0).getScore();
        for(int i = 1; i < 5; i++) {
            if (hand.get(i).getScore() != firstScore + 1) {
                return false;
            }
            firstScore = hand.get(i).getScore();
        }
        return true;
    }

    public boolean straightFlush() {
        int firstScore = hand.get(0).getScore();
        if(matchingFaces()){
            for(int i = 1; i < 5; i++) {
                if (hand.get(i).getScore() != firstScore + 1) {
                    return false;
                }
                firstScore = hand.get(i).getScore();
            }
        }else{
            return false;
        }
        return true;
    }

    public boolean fourOfAKind() {
        List<String> faces = new ArrayList<String>();
        for(Card card : hand) {
            faces.add(card.getFace());
        }
        for (String possibleFace : possibleFaces) {
            int count = 0;
            String search = possibleFace;
            for (String face : faces) {
                if (face.equals(search)) {
                    count++;
                }
            }
            if (count >= 4) {
                return true;
            }
        }
        return false;
    }

    public boolean threeOfAKind() {
        List<String> faces = new ArrayList<String>();
        for(Card card : hand) {
            faces.add(card.getFace());
        }
        for (String possibleFace : possibleFaces) {
            int count = 0;
            String search = possibleFace;
            for (String face : faces) {
                if (face.equals(search)) {
                    count++;
                }
            }
            if (count >= 3) {
                return true;
            }
        }
        return false;
    }

    public boolean royalFlush() {
        int firstScore = hand.get(0).getScore();
        if(firstScore == 10) {
            if(matchingFaces()) {
                for(int i = 1; i < 5; i++) {
                    if(hand.get(i).getScore() != firstScore + 1) {
                        return false;
                    }
                    firstScore = hand.get(i).getScore();
                }
            }else {
                return false;
            }
        }else {
            return false;
        }
        return true;
    }

}


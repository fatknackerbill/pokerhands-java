package com.andy.pokerhands.rules;

import com.andy.pokerhands.*;

import java.util.List;

public class Straight extends Rule {
    @Override
    public boolean matches(List<Card> cards) {
        return RulesEngine.consecutiveCards(cards);
    }

    @Override
    public Ranking getRanking() {
        return Ranking.STRAIGHT;
    }

    @Override
    public WinResult compareTwoHands(Hand hand1, Hand hand2) {
        Card hand1HighestCard = hand1.getHighestCard();
        Card hand2HighestCard = hand2.getHighestCard();
        int i = hand1HighestCard.compareTo(hand2HighestCard);
        Hand winningHand = i > 0 ? hand1 : hand2;

        WinResult winResult = new WinResult();
        winResult.setWinningHand(winningHand.getColour(), getRanking());
        winResult.setWinningItem(winningHand.getHighestCard().getCardValue().toString());
        return winResult;
    }

}

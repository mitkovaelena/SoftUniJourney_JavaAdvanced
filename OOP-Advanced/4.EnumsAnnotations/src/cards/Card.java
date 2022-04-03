package cards;

public class Card implements Comparable<Card>{
    private CardRank rank;
    private CardSuit suit;

    public Card(String rank, String suit) {
        this.rank = Enum.valueOf(CardRank.class, rank);
        this.suit = Enum.valueOf(CardSuit.class, suit);
    }

    public CardRank getRank() {
        return rank;
    }

    public CardSuit getSuit() {
        return suit;
    }

    public int getValue(){
        return this.rank.getValue() + this.suit.getValue();
    }

    @Override
    public int compareTo(Card c) {
        return c.getValue() - this.getValue();
    }

    @Override
    public String toString() {
        return String.format("%s of %s.", this.getRank(), this.getSuit(), this.getValue());
    }
}

public enum Suit {


    Club(0), Diamond(1), Heart(2), Spade(3);

    private int value;


    private Suit(int v) {
        value = v;
    }


    public int getValue() {
        return value;
    }


    public static Suit getSuitFromValue(int value) {


        for (Suit suit : Suit.values()) {

            if (suit.value == value) {

                return suit;
            }

        }

        return null;

    }


}


public abstract class Card {


    protected int value;
    protected Suit suit;


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }


    public Card(Suit suit, int value) {

        this.suit = suit;
        this.value = value;

    }


    public abstract int values();
}


public class Deck<T extends Card> {


    public static void main(String[] args) {

        Deck<Card> deck = new Deck<Card>();

        deck.shuffler();
    }


    private List<T> cards;
    private int usedCard = 0;
    private Random random;

    private int remainingCars() {

        return cards.size() - usedCard;
    }

    public List<T> getCards() {
        return cards;
    }

    public void setCards(List<T> cards) {
        this.cards = cards;
    }


    public void shuffler() {

        for (int i = 0; i < cards.size(); i++) {


            int j = i + random.nextInt(cards.size() - i);

            swap(cards, i, j);
        }
    }

    private void swap(List<T> cards, int i, int j) {

        T card = cards.get(i);

        cards.set(i, cards.get(j));

        cards.set(j, card);
    }


    public T[] dealHand(int num) {
        return null;
    }

    public T dealCard() {
        return null;
    }

}

public class Hand<T extends Card> {

    private List<T> cardList;


    public int score() {
        int score = 0;
        for (T card : cardList) {
            score += card.value;

        }
        return score;

    }


    public void addCard(T card) {
        cardList.add(card);

    }


}
public class BlackJackCard extends Card {

    public BlackJackCard(Suit suit, int value) {
        super(suit, value);
    }


    @Override
    public int values() {
        if (isAce()) return 1;
        else if (value >= 11 && value <= 13) return 10;
        else return value;

    }

    public boolean isAce() {

        return value == 1;
    }

    public int minValue() {
        if (isAce()) return 1;
        else return value;

    }


    public int maxValue() {
        if (isAce()) return 11;
        else return value;

    }


    public boolean isFaceCard() {
        return value >= 11 && value <= 13;

    }


}

public class BlackJackHand extends Hand<BlackJackCard> {


    public int score() {
        ArrayList<Integer> scores = possibleScores();
        int maxUnder = Integer.MIN_VALUE;
        int minOver = Integer.MAX_VALUE;
        for (int score : scores) {
            if (score > 21 && score < minOver) {
                minOver = score;

            } else if (score <= 21 && score > maxUnder) {
                maxUnder = score;

            }
        }
        return maxUnder == Integer.MIN_VALUE ? minOver : maxUnder;

    }


    private ArrayList<Integer> possibleScores() {
        return null;
    }


    public boolean busted() {
        return score() > 21;
    }


    public boolean is21() {
        return score() == 21;
    }


    public boolean isBlackJack() {
        return false;
    }


}

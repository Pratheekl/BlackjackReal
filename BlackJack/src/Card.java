/**
 * Created by 1227927 on 11/26/2018.
 */
public class Card
{
    private int suit;
    private int rank;

    private final String[] ranks = {"", "", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    private final String[] suits = {"♥", "♦", "♣", "♠"}; // alt 3-6

    /**
     * Precondition: 0 <= suit <= 3
     *               2 <= rank <= 14
     * @param suit
     * @param rank
     */
    public Card(int rank, int suit)
    {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * 2-9 --> face values
     * 10-k --> 10
     * A --> 11
     *
     * @return blackjack value of the card
     */
    public int getValue()
    {
        if(rank < 10) // Ace
            return rank;
        else if(rank >= 10 && rank < 14)  //10 and all face cards
            return 10;
        else
            return 11;
    }

    /**
     *
     * @return a String representation of this Card
     *          in the format of {rank}{suit}
     *          Example:    2♠
     *                      J♣
     */
    @Override
    public String toString()
    {
      return ranks[rank] + suits[suit];
    }
}

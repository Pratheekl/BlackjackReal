import java.util.Arrays;

/**
 * Created by 1227927 on 11/26/2018.
 */
public class Deck
{
    private Card[] cards;

    public Deck()
    {
        cards = new Card[52];

        int i = 0;
        for (int rank = 2; rank < 15; rank++)
            for (int suit = 0; suit < 4; suit++)
                cards[i++] = new Card(rank, suit);
    }

    public void shuffle()
    {
        Card[] scrambled = new Card[52];
        int randy;

        for (int i = 0; i < 52; i++)
        {
            randy = (int)(Math.random() * 52);
            while(cards[randy] == null)
            {
                randy = (int)(Math.random() * 52);
            }
            scrambled[i] = cards[randy];
            cards[randy] = null;
        }

        cards = scrambled;
    }

    /**
     * Removes and returns cards[0]
     * Precondition: cards.length > 0
     * Postcondition: cards.length--
     * @return
     */
    public Card deal()
    {
        Card[] cardsTemp = new Card[cards.length - 1];
        Card tempCard = cards[0];

        for (int i = 0; i < cardsTemp.length; i++)
            cardsTemp[i] = cards[i + 1];

        cards = cardsTemp;
        return tempCard;
    }

    @Override
    public String toString()
    {
        return "Deck{" +
                "cards=" + Arrays.toString(cards) +
                '}';
    }
}

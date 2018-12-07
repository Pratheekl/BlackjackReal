import java.util.Arrays;

/**
 * Created by 1227927 on 11/27/2018.
 */
public class Hand
{
    private Card[] cards;

    public Hand()
    {
        cards = new Card[0];
    }

    /**
     *Adds card to cards
     * @param card
     */
    public void hit(Card card)
    {
        Card[] temp = new Card[cards.length + 1];
        for (int i = 0; i < cards.length; i++)
        {
            temp[i] = cards[i];
        }
        temp[temp.length - 1/*cards.length*/] = card;
        cards = temp;
    }

    public int getValue()
    {
        int sum = 0, aceCount = 0;

        for (Card card: cards)
        {
            sum += card.getValue();
            if(card.getValue() == 11)
                aceCount++;
        }

        while(sum > 21 && aceCount > 0)
        {
            sum -= 10;
            aceCount--;
        }

        return sum;
    }

    public Card[] getCards()
    {
        return cards;
    }

    public boolean isBusted()
    {
        return getValue() > 21;
    }
    public boolean isBlackjac()
    {
        return getValue() == 21;
    }

    @Override
    public String toString()
    {
        return Arrays.toString(cards);
    }
}
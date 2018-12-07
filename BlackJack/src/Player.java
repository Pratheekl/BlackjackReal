/**
 * Created by 1227927 on 11/29/2018.
 */
public class Player
{
    private String name;
    private int money;
    private Hand hand;

    public Player(String name, int money)
    {
        this.name = name;
        this.money = money;
        hand = new Hand();
    }

    public int getMoney()
    {
        return money;
    }

    public void setMoney(int money)
    {
        this.money = money;
    }

    public Hand getHand()
    {
        return hand;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public String toString()
    {
        return name + ": " + hand + " $" + money;
    }
}

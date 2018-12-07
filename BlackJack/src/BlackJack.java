import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by 1227927 on 11/29/2018.
 */
public class BlackJack
{
    private Player[] players;
    private Player dealer;
    private Deck deck;
    private int bet;
    Scanner arc = new Scanner(System.in);

    public BlackJack(int tableValue)
    {
        deck = new Deck();
        deck.shuffle();

        dealer = new Player("Dealer", 0);

        players = new Player[1];
        players[0] = dealer;

        this.bet = tableValue;
    }

    /**
     * Adds a player to the beginning of an array
     * @param player
     */
    protected void addPlayer(Player player)
    {
        Player[] temp = new Player[players.length + 1];

        for (int i = 0; i < players.length; i++)
            temp[i+1] = players[i];

        temp[0] = player;

        players = temp;
    }

    public void playRound()
    {
        //take everybody's money
        for (Player player: players)
        {
            if(player != dealer)
            {
                player.setMoney(player.getMoney() - bet);
                dealer.setMoney(dealer.getMoney() + bet);
            }

        }

        // deal cards
        for (int i = 0; i < 2; i++)
            for (Player player : players)
                player.getHand().hit(deck.deal());

        //show cards
        for (Player player : players)
        {
            if(player != dealer)
                System.out.println(player);

        }

        //show dealer card
        System.out.println("Dealer " + dealer.getHand().getCards()[0]);

        //take turns
        for (Player player : players)
        {
            if (player != dealer)
                playerTurn(player);
        }

        dealerTurn();

        payOut();

    }

    /**
     * Precondition _ don't be monchee
     * @param player
     */
    public void playerTurn(Player player)
    {
        System.out.println("\n-- " + player.getName() + "'s turn --");
        System.out.println(player.getHand());


        while(true)
        {
            System.out.println("Choose One: ");
            System.out.println("1 - hit \n2 - stand");

            int choice = arc.nextInt();
            if(choice == 1)
            {
                player.getHand().hit(deck.deal());
                System.out.println(player.getHand());
            }

            else if(choice == 2)
                break;

            if(player.getHand().isBusted())
            {
                System.out.println(player.getName() + " RIP");
                break;
            }

            if(player.getHand().isBlackjac())
            {
                System.out.println(player.getName() + " got the biggest W");
                break;
            }
        }
    }

    public void dealerTurn()
    {
        System.out.println("\n-- " + dealer.getName() + "'s turn --");
        System.out.println(dealer.getHand());

        while(dealer.getHand().getValue() < 17)
        {
            dealer.getHand().hit(deck.deal());
            System.out.println(dealer.getHand());
        }

        if(dealer.getHand().isBlackjac())
            System.out.println(dealer.getName() + " got BLACKJACK");
        if(dealer.getHand().isBusted())
            System.out.println(dealer.getName() + " took a massive L");
    }

    public void payOut()
    {
        for (Player player: players)
        {
            if (player != dealer)
            {
                int change = 0;

                if (!player.getHand().isBusted())
                {
                    if (player.getHand().isBlackjac())
                        change = (int) (bet * 2.5);

                    if (!dealer.getHand().isBusted())
                    {
                        if (player.getHand().getValue() == dealer.getHand().getValue())
                            change = (int) (bet);
                        else if (player.getHand().getValue() > dealer.getHand().getValue())
                            change = bet * 2;
                    }
                }

                player.setMoney((player.getMoney() + change));
                System.out.println(player.getName() + ": $" + player.getMoney());
            }
        }
    }

    @Override
    public String toString()
    {
        return "BlackJack{" +
                "players=" + Arrays.toString(players) +
                '}';//
    }
}

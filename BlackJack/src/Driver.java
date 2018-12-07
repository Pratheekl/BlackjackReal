/**
 * Created by 1227927 on 11/26/2018.
 */
public class Driver
{
    public static void main(String[] args)
    {
        int bet = 69;

        BlackJack blackJack = new BlackJack(bet);
        blackJack.addPlayer(new Player("Jimmy", bet * 10));
        blackJack.addPlayer(new Player("John D Rockefeller", bet * 15));
        blackJack.addPlayer(new Player("Elon Musk", bet * 20));
        blackJack.addPlayer(new Player("Mansu Musa", bet * 30));

        blackJack.playRound();
    }
}

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Main client class for starting/initialising the program/game.
 */
public class DemoGame {


    public static void main(String[] args){
        /**
         * The 3 objects, board, players, and diceRolls.
         */
        List<Field> board = new ArrayList<>();
        List<Player> players = new ArrayList<>();
        List<Integer> diceRolls = new ArrayList<>();
        int position = 0;
        int rollDice = 0;
        Player firstLoser = null;

        try {
            board = ReadFile.readFields("input.txt");
            players = ReadFile.readPlayers("input.txt");
            diceRolls = ReadFile.readDice("dice.txt");
            if(players.isEmpty()) throw new IllegalArgumentException("Player list is empty.");
            if(board.isEmpty()) throw new IllegalArgumentException("Board list is empty.");
            if(diceRolls.isEmpty()) throw new IllegalArgumentException("Dice is not thrown.");

            while (true) {
                Player currentPlayer = null;
                currentPlayer = players.get(position % players.size());
                currentPlayer.move(diceRolls.get(rollDice % diceRolls.size()), board);
                if (currentPlayer==null) throw new IllegalArgumentException();
                else if (currentPlayer.isBankrupt()) {
                if(firstLoser == null) { firstLoser = currentPlayer; }
                else if(firstLoser != currentPlayer){ System.out.println("\n" + currentPlayer.getName() + " is the second loser."); break; }
                }
                position++;
                rollDice++;
            }

        } catch (IllegalArgumentException | IOException ex) { System.out.println(ex.getMessage()); }


        // white box testing
        System.out.println("\n--------------- 3 Tests Below ---------------");

        // testing isBankrupt() method
        Player player = new Tactical("ABC");
        player.payMoney(11000);
        if (player.isBankrupt()) System.out.println("\nSuccessful. Bankruptcy.");
        else System.out.println("Fail.");


        // testing if careful player buys property if not enough money
        Player player2 = new Careful("ABC");
        player2.payMoney(9999);
        Property property = new Property();

        player2.buyProperty(property);
        if (property.getOwner() == null) System.out.println("Successful. Did not buy.");
        else System.out.println("Fail.");


        // testing if lucky will increase player money
        Player player3 = new Greedy("ABC");
        Lucky lucky = new Lucky(9999);
        int money = player3.money;

        lucky.doStep(player3);
        if (player3.money == 19999) System.out.println("Successful. Money increased.");
        else System.out.println("Fail.");
    }
}
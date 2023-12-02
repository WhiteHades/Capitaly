import java.util.List;

/**
 * Player (on the board). The superclass for the 3 tactics of players.
 */
public class Player {
    /**
     * The name of the player.
     */
    protected String name;

    /**
     * The starting money of the player, 10 000
     */
    protected int money = 10000;

    /**
     * The starting position of the player on the board, 0
     */
    protected int position = 0;

    /**
     * Constructor. New player with his name.
     * @param name The name of the player.
     */
    public Player(String name) { this.name  = name; }
    public String getName() { return name; }

    /**
     * The player will gain money, if stepping on the lucky field.
     * @param amount The amount he will gain.
     */
    public void getMoney(int amount) { if (amount < 0) throw new IllegalArgumentException("\nNegative money is " +
            "invalid."); money += amount; }

    /**
     * The player will lose money, if stepping on the service field.
     * @param amount The amount he will lose.
     */
    public void payMoney(int amount) { if (amount < 0) throw new IllegalArgumentException("\nNegative money is " +
            "invalid."); money -= amount; }

    public boolean isBankrupt() { return money < 0; }

    /**
     * Unimplemented method, to be implemented in the subclasses.
     * @param property The input property type.
     */
    public void buyProperty(Property property) {}

    /**
     * Unimplemented method, to be implemented in the subclasses.
     * @param property The input property type.
     */
    public void buildHouse(Property property) {}

    /**
     * Unimplemented method, to be implemented in the subclasses.
     * @param property The input property type.
     */
    public void payOwner(Property property) {}

    /**
     * Unimplemented method, to be implemented in the subclasses.
     * @param field The input field type.
     */
    public void strategyPl(Field field) {}


    /**
     * If the board is not empty, it calculates the new position by
     * adding the dice number and then taking the remainder when dividing by the board size (for looping back
     * to the start after reaching the end of the board). After that, the strategyPL method of the player’s
     * specific tactic is called.
     * @param dice the number on the dice.
     * @param board the board where the game is played.
     */
    public void move(int dice, List<Field> board) {
        if(!board.isEmpty()) position = (position + dice) % board.size();
        strategyPl(board.get(position));
    }
}

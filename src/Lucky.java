/**
 * Lucky field (on the board). Players can earn money.
 */
public class Lucky extends Field {
    /**
     * The amount players will earn.
     */
    private int amount;

    /**
     * Constructor. New Lucky field with the amount.
     * @param amount The amount of money the player will earn/gain.
     */
    public Lucky(int amount) { this.amount = amount; }

    /**
     * Implements the steps that are done when a player lands on said field.
     * @param player The player who lands on said field. In this case, gain money.
     */
    @Override
    public void doStep(Player player) { player.getMoney(amount); }
}

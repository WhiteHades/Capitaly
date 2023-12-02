/**
 * Service field (on the board). Players can lose money.
 */
public class Service extends Field {
    /**
     * The amount players will lose.
     */
    private int amount;

    /**
     * Constructor. New Lucky field with the amount.
     * @param amount The amount of money the player will earn/gain.
     */
    public Service(int amount) { this.amount = amount; }

    /**
     * Implements the steps that are done when a player lands on said field.
     * @param player The player who lands on said field. In this case, lose money.
     */
    @Override
    public void doStep(Player player) { player.payMoney(amount); }
}
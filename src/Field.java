/**
 * Field (on the board). The abstract super class for the 3 fields.
 */
abstract class Field {
    /**
     * Implements the steps that are done when a player lands on said field.
     * @param player The player who lands on said field.
     */
    public abstract void doStep(Player player);
}
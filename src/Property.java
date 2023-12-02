/**
 * Property field (on the board). Players can buy a property and build houses.
 */
public class Property extends Field {
    /**
     * Sets and initialises the owner to null.
     */
    private Player owner = null;

    /**
     * Sets the hasHouse to false, i.e., the default value.
     */
    private boolean hasHouse = false;

    public void setHasHouse(boolean hasHouse) { this.hasHouse = hasHouse; }
    public void setOwner(Player owner) { this.owner = owner; }
    public Player getOwner() { return owner; }
    public boolean hasHouse() { return hasHouse; }

    /**
     * Implements the steps that are done when a player lands on said field.
     * @param player The player who lands on said field.
     */
    @Override
    public void doStep(Player player) {
        if(owner == null) player.buyProperty(this);
        else if(player != owner) player.payOwner(this);
        else player.buildHouse(this);
    }
}
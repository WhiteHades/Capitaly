/**
 * Careful (on the board). The subclass of Player.
 */
public class Careful extends Player {
    /**
     * Constructor. New Careful player with his name.
     * @param name The name of the player.
     */
    public Careful(String name) { super(name); }

    /**
     * : If property has a house, player pays 2000 (to the owner), if not, 500.
     * @param property
     */
    @Override
    public void payOwner(Property property) { payMoney(property.hasHouse() ? 2000 : 500); }

    /**
     * Implements careful tactic (using this keyword). Uses these methods.
     * @param field
     */
    @Override
    public void strategyPl(Field field) { field.doStep(this); }

    /**
     * If he has double the money of 4000, pays it for building house.
     * @param property
     */
    @Override
    public void buildHouse(Property property) { if (money/2 >= 4000) { property.setHasHouse(true); payMoney(4000); } }

    /**
     * If he has double the money of 1000, pays it for buying property.
     * @param property
     */
    @Override
    public void buyProperty(Property property) { if ((money/2) >= 1000) { property.setOwner(this); payMoney(1000); } }
}
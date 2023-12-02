/**
 * Tactical (on the board). The subclass of Player.
 */
public class Tactical extends Player {
    /**
     * The default value of the skipNextChange is false.
     */
    protected boolean skipNextChange = false;

    /**
     * Constructor. New Tactical player with his name.
     * @param name The name of the player.
     */
    public Tactical(String name) { super(name); }

    /**
     * If property has a house, player pays 2000 (to the owner), if not, 500.
     * @param property
     */
    @Override
    public void payOwner(Property property) { payMoney(property.hasHouse() ? 2000 : 500); }

    /**
     * Implements tactical strategy (using this keyword). Uses these methods.
     * Skips every alternate chance of buying any property or building house.
     * @param field
     */
    @Override
    public void strategyPl(Field field) { if (!skipNextChange) field.doStep(this); skipNextChange = !skipNextChange; }

    /**
     * If he has more than 4000, pays it for building the house.
     * @param property
     */
    @Override
    public void buildHouse(Property property) { if (money >= 4000) { property.setHasHouse(true); payMoney(4000); } }


    /**
     * If he has more than 1000, pays it for buying the property.
     * @param property
     */
    @Override
    public void buyProperty(Property property) { if (money >= 1000) { property.setOwner(this); payMoney(1000); } }
}
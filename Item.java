/**
* This is the item class for the starfish collectable. 
* @author  Lucy Auger, Megan Li, Sophia Silovsky
* @version 1.0
* @since   2024-05-09
*/
public class Item {
    private String name;
    private ItemType type;
    private int quantity;

    /**
     * Item Constructor
     * @param name
     * @param type
     * @param quantity
     */
    public Item(String name, ItemType type, int quantity) {
        this.name = name;
        this.type = type;
        this.quantity = quantity;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public ItemType getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }
}


// Enum to represent different types of items
enum ItemType {
    STARFISH
}
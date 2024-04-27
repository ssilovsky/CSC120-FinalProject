public class Item {
    private String name;
    private ItemType type;

    public Item(String name, ItemType type) {
        this.name = name;
        this.type = type;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public ItemType getType() {
        return type;
    }
}

// Enum to represent different types of items
enum ItemType {
    WEAPON,
    ARMOR,
    CONSUMABLE,
    CROWN,
    SEAWEED,
    ROCK
}
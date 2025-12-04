package Model.Item;

import Model.Entities.Combatant;
import Model.Entities.Player.Player;

import java.io.Serializable;

public abstract class Item implements Serializable {
    protected String name;
    protected String description;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public abstract void use(Combatant user, Combatant target);
    public abstract boolean isConsumable();

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}

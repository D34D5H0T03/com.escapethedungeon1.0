package Game.Combat.ActionManager;

import Model.Entities.Combatant;
import Model.Item.Item;

public class ItemManager {
    public static boolean useItemInCombat(Combatant user, Item item, Combatant target) {
        if (item == null) {
            System.out.println("No item selected!");
            return false;
        }

        if (!user.hasItem(item)) {
            System.out.println(user.getName() + " doesn't have " + item.getName() + "!");
            return false;
        }

        System.out.println(user.getName() + " uses " + item.getName() + "!");

        user.useItem(item, target);

        return true;
    }
}

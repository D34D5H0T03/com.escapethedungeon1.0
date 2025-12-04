package Model.Ability.Spell;

import Model.Ability.Castable;
import Model.Entities.Combatant;
import Model.Entities.Player.Player;

import java.io.Serializable;

public abstract class Spell implements Serializable, Castable {
    protected String name;
    protected int mpCost;
    protected String description;

    public abstract void cast(Combatant caster, Combatant target, boolean isCritical);
    public abstract boolean isRequiresAttackRoll();

    public Spell(String name, String description, int mpCost) {
        this.name = name;
        this.mpCost = mpCost;
        this.description = description;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getMpCost() {
        return mpCost;
    }

    @Override
    public String getDescription() {
        return description;
    }

}

package Model.Ability.Spell.OffensiveSpell;

import Model.Ability.Spell.Spell;
import Model.Entities.Combatant;
import Model.Entities.Player.Player;

public class OffensiveSpell extends Spell {

    private int damage;

    public OffensiveSpell(OffensiveSpellType type){
        super(type.getName(), type.getDescription(), type.getMpCost());
        this.damage = type.getDamage();
    }

    @Override
    public void cast(Combatant caster, Combatant target) {
        if (caster.getMp() < mpCost) {
            System.out.println("NOT ENOUGH MP");
            return;
        }
        caster.setMp(caster.getMp() - mpCost);

        if(target != null){
            target.setHp(Math.max(0, target.getHp() - damage));
        }
    }

    public int getDamage() {
        return damage;
    }
}

package Model.Ability.Spell.OffensiveSpell;

import Model.Ability.Spell.Spell;
import Model.Entities.Combatant;

public class OffensiveSpell extends Spell {

    private int damage;

    public OffensiveSpell(OffensiveSpellType type){
        super(type.getName(), type.getDescription(), type.getMpCost());
        this.damage = type.getDamage();
    }

    @Override
    public void cast(Combatant caster, Combatant target, boolean isCritical) { //for out of combat casting
        if (caster.getMp() < mpCost) {
            System.out.println("NOT ENOUGH MP");
            return;
        }
        caster.setMp(caster.getMp() - mpCost);

        if(isCritical){
            damage *= 2;
        }

        if(target != null){
            target.setHp(Math.max(0, target.getHp() - damage));
        }
    }

    public boolean isRequiresAttackRoll(){
        return true;
    }

    public int getDamage() {
        return damage;
    }
}

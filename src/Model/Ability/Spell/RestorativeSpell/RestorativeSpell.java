package Model.Ability.Spell.RestorativeSpell;

import Model.Ability.Spell.Spell;
import Model.Entities.Combatant;
import Model.Entities.Player.Player;

public class RestorativeSpell extends Spell {
    private final int hpRestore;
    private final int mpRestore;

    public RestorativeSpell(RestorativeSpellType type) {
        super(type.getName(), type.getDescription(), type.getMpCost());
        this.hpRestore = type.getHpRestore();
        this.mpRestore = type.getMpRestore();
    }

    @Override
    public void cast(Combatant caster, Combatant target){
        if(caster.getMp() < mpCost){
            System.out.println("NOT ENOUGH MP");
            return;
        }
        caster.setMp(caster.getMp() - mpCost);

        if (hpRestore > 0) {
            int newHp = target.getHp() + hpRestore;
            target.setHp(Math.min(newHp, target.getMaxHP()));
            System.out.println(target.getName() + " recovered " + hpRestore + " HP!");
        }

        if (mpRestore > 0) {
            int newMp = target.getMp() + mpRestore;
            target.setMp(Math.min(newMp, target.getMaxMP()));
            System.out.println(target.getName() + " recovered " + mpRestore + " MP!");
        }
    }

    public int getHpRestore() {
        return hpRestore;
    }

    public int getMpRestore() {
        return mpRestore;
    }
}

package Model.Entities.Boss.HumanoidBoss;

import Model.Ability.Castable;
import Model.Ability.Spell.Spell;
import Model.Entities.Boss.Boss;
import Model.Entities.Stats;
import Model.Equipments.Armours.Armour;
import Model.Equipments.Weapons.Weapon;
import Model.Item.Item;
import Model.Item.RestorativeItems.RestorativeItemType;
import Util.Factory;

import java.util.ArrayList;
import java.util.Random;

public class HumanoidBoss extends Boss {
    private HumanoidBossType type;
    private ArrayList<Spell> availableSpells;
    private ArrayList<Item> inventory;
    private Weapon mainHand;
    private Armour bodyArmour;

    private final int[] stats = new int[6];

    public HumanoidBoss(HumanoidBossType type) {
        super(type.getName(), type.getMaxHP(), type.getMaxMP(), type.getArmourClass(),type.getInitiativeBonus(),
                type.getAccuracy(), type.getLevel(), type.getSouls());
        this.type = type;

        int[] base = type.getStats();
        for (Stats stat : Stats.values()) {
            stats[stat.getIndex()] = base[stat.getIndex()];
        }

        this.availableSpells = new ArrayList<>();
        this.inventory = new ArrayList<>();

        this.mainHand = Factory.createWeapon(type.getWeaponType());
        this.bodyArmour = Factory.createArmour(type.getArmourType());

        for (Castable ability : type.getStartingAbilities()) {
            Spell spell = Factory.createSpell(ability);
            if (spell != null) {
                availableSpells.add(spell);
            }
        }

        this.inventory.add(Factory.createRestorativeItem(RestorativeItemType.HEALING_POTION));
        this.inventory.add(Factory.createRestorativeItem(RestorativeItemType.HEALING_POTION));
    }

    @Override
    public String getDescription() {
        return type.getDescription();
    }

    public int getStat(Stats stat) {
        return stats[stat.getIndex()];
    }

    public int getStatModifier(Stats stat) {
        return (getStat(stat) - 10) / 2;
    }

    @Override
    public int getArmourClass() {
        int baseAC = bodyArmour.getArmourClass();
        int dexMod = getStatModifier(Stats.DEXTERITY);
        return baseAC + dexMod;
    }

    @Override
    public int getAccuracy() {
        return accuracy + getStatModifier(Stats.DEXTERITY);
    }

    public int calculateWeaponDamage(Random rand) {
        int primaryDamage = rand.nextInt(mainHand.getPrimaryDamage()) + 1;
        int secondaryDamage = rand.nextInt(mainHand.getSecondaryDamage()) + 1;
        Stats scalingStat = mainHand.getScalingStat();
        int statMod = getStatModifier(scalingStat);

        return primaryDamage + secondaryDamage + statMod;
    }

    public HumanoidBossType getType() {
        return type;
    }

    public int[] getStats() {
        return stats;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public ArrayList<Spell> getAvailableSpells() {
        return availableSpells;
    }

    public Weapon getMainHand() {
        return mainHand;
    }

    public Armour getBodyArmour() {
        return bodyArmour;
    }
}

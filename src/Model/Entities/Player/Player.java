package Model.Entities.Player;

import Model.Ability.Castable;
import Model.Entities.Combatant;
import Model.Entities.Stats;
import Model.Equipments.Armours.Armour;
import Model.Equipments.Weapons.Weapon;
import Model.Item.Item;
import Model.Item.RestorativeItems.RestorativeItemType;
import Model.Ability.Spell.Spell;
import Util.Factory;

import java.util.ArrayList;
import java.util.Arrays;

public class Player implements Combatant {
    private static final int MAX_INVENTORY_SIZE = 20;

    private final PlayerType type;
    private String name;

    private int hp;
    private int maxHP;
    private int mp;
    private int maxMP;
    private int armourClass;
    private int accuracy;
    private int initiativeBonus;
    private int spellSlots;
    private int level;
    private int souls;

    private final int[] STATS = new int[6];
    private final ArrayList<Item> inventory = new ArrayList<>();
    private final ArrayList<Spell> availableSpells = new ArrayList<>();

    private Weapon mainHand;
    private Armour bodyArmour;

    public Player(PlayerType type, String name) {
        this.type = type;
        this.name = name;

        int[] base = type.getBaseStats();
        for (Stats stat : Stats.values()) {
            STATS[stat.getIndex()] = base[stat.getIndex()];
        }

        //hp/mp with modifiers ||FOR STAT BONUS||
        this.maxHP = type.getBaseMaxHp() + getModifier(Stats.CONSTITUTION);
        this.hp = maxHP;
        this.maxMP = type.getBaseMaxMp() + getModifier(Stats.WISDOM);
        this.mp = maxMP;

        this.accuracy = type.getBaseAccuracy();
        this.spellSlots = type.getSpellSlots();
        this.initiativeBonus = type.getInitiativeBonus();

        //equipment
        this.mainHand = new Weapon(type.getWeapon());
        this.bodyArmour = new Armour(type.getArmour());
        this.armourClass = bodyArmour.getArmourClass();

        //spells and skill ||ADD SKILLS||
        for (Castable ability : type.getStartingAbilities()) {
            Spell spell = Factory.createSpell(ability);
            if (spell != null) {
                availableSpells.add(spell);
            }
        }

        for (int i = 0; i < 3; i++) {
            inventory.add(Factory.createRestorativeItem(RestorativeItemType.HEALING_POTION));
        }
        if (type == PlayerType.CLERIC || type == PlayerType.MAGE) {
            for (int i = 0; i < 2; i++) {
                inventory.add(Factory.createRestorativeItem(RestorativeItemType.MAGIC_POTION));
            }
        }
    }


    public int getStat(Stats stat) {
        return STATS[stat.getIndex()];
    }

    private void addToStat(Stats stat, int amount) {
        STATS[stat.getIndex()] += amount;
    }

    public int getModifier(Stats stat) {
        return (getStat(stat) - 10) / 2;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHp() {
        return hp;
    }

    @Override
    public int getMaxHP() {
        return maxHP;
    }

    @Override
    public void setHp(int hp) {
        this.hp = Math.max(0, Math.min(hp, maxHP));
    }

    @Override
    public int getMp() {
        return mp;
    }

    @Override
    public int getMaxMP() {
        return maxMP;
    }

    @Override
    public void setMp(int mp) {
        this.mp = Math.max(0, Math.min(mp, maxMP));
    }

    @Override
    public int getArmourClass() {
        return armourClass;
    }

    @Override
    public int getInitiativeBonus() {
        return initiativeBonus;
    }

    @Override
    public boolean isAlive() {
        return hp > 0;
    }

    @Override
    public void applyDamage(int amount) {
        hp = Math.max(0, hp - amount);
    }

    @Override
    public void applyHealing(int amount) {
        hp = Math.min(maxHP, hp + amount);
    }


    public int getLevel() {
        return level;
    }
    public int getSouls() {
        return souls;
    }
    public void addSouls(int amount) {
        souls += amount;
    }

    public boolean levelUp(Stats bonusStat) {
        if (level >= 10) return false;
        if (souls < 100 * level) return false;

        souls -= 100 * level;
        level++;

        // Class bonuses
        int[] bonuses = type.getLevelUpBonuses();
        for (Stats stat : Stats.values()) {
            addToStat(stat, bonuses[stat.getIndex()]);
        }

        // Player choice
        addToStat(bonusStat, 1);

        // HP/MP growth
        maxHP += 10 + getModifier(Stats.CONSTITUTION);
        maxMP += 5 + getModifier(Stats.WISDOM);

        hp = maxHP;
        mp = maxMP;

        return true;
    }


    public int getWeaponDamageMin(java.util.Random rand) {
        if (mainHand == null) return 5;
        int primary = rand.nextInt(mainHand.getPrimaryDamage()) + 1;
        int secondary = rand.nextInt(mainHand.getSecondaryDamage()) + 1;
        Stats scalingStat = mainHand.getScalingStat();
        return primary + secondary + getModifier(scalingStat);
    }

    public PlayerType getType() {
        return type;
    }

    @Override
    public int getAccuracy() {
        return accuracy;
    }

    public int getSpellSlots() {
        return spellSlots;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public int[] getSTATS() {
        return STATS;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public void setMaxMP(int maxMP) {
        this.maxMP = maxMP;
    }

    public void setArmourClass(int armourClass) {
        this.armourClass = armourClass;
    }

    @Override
    public String toString() {
        return "Player{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", hp=" + hp +
                ", maxHP=" + maxHP +
                ", mp=" + mp +
                ", maxMP=" + maxMP +
                ", armourClass=" + armourClass +
                ", accuracy=" + accuracy +
                ", initiativeBonus=" + initiativeBonus +
                ", spellSlots=" + spellSlots +
                ", level=" + level +
                ", souls=" + souls +
                ", STATS=" + Arrays.toString(STATS) +
                ", inventory=" + inventory +
                ", availableSpells=" + availableSpells +
                ", mainHand=" + mainHand +
                ", bodyArmour=" + bodyArmour +
                '}';
    }
}
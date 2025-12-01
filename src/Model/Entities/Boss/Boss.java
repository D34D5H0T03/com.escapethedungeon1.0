package Model.Entities.Boss;

import Model.Entities.Combatant;

public abstract class Boss implements Combatant {
    protected String name;
    protected int hp;
    protected int maxHP;
    protected int mp;
    protected int maxMP;
    protected int armourClass;
    protected int initiativeBonus;
    protected int accuracy;
    protected int level;
    protected int souls;

    public Boss(String name, int maxHP, int maxMP, int armourClass, int initiativeBonus, int accuracy, int level, int souls) {
        this.name = name;
        this.maxHP = maxHP;
        this.hp = maxHP;
        this.maxMP = maxMP;
        this.mp = maxMP;
        this.armourClass = armourClass;
        this.initiativeBonus = initiativeBonus;
        this.accuracy = accuracy;
        this.level = level;
        this.souls = souls;
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
    public int getAccuracy() {
        return accuracy;
    }

    @Override
    public boolean isAlive() {
        return hp > 0;
    }

    @Override
    public void applyDamage(int amount) {
        this.hp = Math.max(0, hp - amount);
    }

    @Override
    public void applyHealing(int amount) {
        this.hp = Math.min(maxHP, hp + amount);
    }

    public int getInitiativeBonus() {
        return initiativeBonus;
    }

    public int getLevel() {
        return level;
    }
    public int getSouls() {
        return souls;
    }

    public abstract String getDescription();
}
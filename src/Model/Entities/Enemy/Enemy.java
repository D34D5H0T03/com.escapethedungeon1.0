package Model.Entities.Enemy;

import Model.Entities.Combatant;

public class Enemy implements Combatant {
    private EnemyType type;
    private String name;
    private int hp;
    private int maxHP;
    private int mp;
    private int maxMP;
    private int armourClass;
    private int accuracy;
    private int level;
    private int damageMin;
    private int damageMax;
    private int souls;

    public Enemy(EnemyType type, int level) {
        if (level < 1) throw new IllegalArgumentException("Level must be >= 1");

        this.name = type.getName();
        this.type = type;
        this.level = level;

        this.maxHP = type.getMaxHP() + type.getHpPerLevel() * (level - 1);
        this.hp = this.maxHP;
        this.maxMP = type.getMaxMP();
        this.mp = type.getMp();

        this.armourClass = type.getArmourClass();
        this.accuracy = type.getAccuracy();
        this.damageMin = type.getDamageMin();

        this.damageMax = (level >= type.getUpgradeLevel() && type.getUpgradeLevel() > 0)
                ? type.getUpgradedDamageMax()
                : type.getBaseDamageMax();


        this.souls = type.getBaseSouls() + type.getSoulsPerLevel() * (level - 1);
    }

    public EnemyType getType() {
        return type;
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
        this.mp = mp;
    }

    public void setMaxMP(int maxMP) {
        this.maxMP = maxMP;
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
    public String getName() {
        return name;
    }

    @Override
    public int getArmourClass() {
        return armourClass;
    }

    @Override
    public int getInitiativeBonus(){ //for the combatant interface, fodder enemies dont have initiative bonus
        return 0;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public int getLevel() {
        return level;
    }

    public int getDamageMin() {
        return damageMin;
    }

    public int getDamageMax() {
        return damageMax;
    }

    public int getSouls() {
        return souls;
    }

    @Override
    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public void setArmourClass(int armourClass) {
        this.armourClass = armourClass;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public void setDamageMin(int damageMin) {
        this.damageMin = damageMin;
    }

    public void setDamageMax(int damageMax) {
        this.damageMax = damageMax;
    }

    public void setSouls(int souls) {
        this.souls = souls;
    }

    @Override
    public boolean isAlive(){
        return (hp > 0);
    }

    @Override
    public void applyDamage(int amount){
        this.hp -= amount;
    }

    @Override
    public void applyHealing(int amount){
        this.hp += amount;
    }


}

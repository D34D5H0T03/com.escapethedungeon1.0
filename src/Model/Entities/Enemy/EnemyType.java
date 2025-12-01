package Model.Entities.Enemy;

public enum EnemyType {
    UNDEAD_GUARD("Undead Guard", 65, 65,
            10, 10, 15,
            15, 8, 4,
            10, 12, 5,
            60, 20),

    SKELETON_SOLDIER(
            "Skeleton Soldier",
            40, 40, 5,5,
            10, 13, 10,
            6, 8, 10,
            5, 50, 15
    );

    private final String name;
    private final int maxHP;
    private final int hp;
    private final int maxMP;
    private final int mp;
    private final int hpPerLevel;
    private final int armourClass;
    private final int accuracy;
    private final int damageMin;
    private final int baseDamageMax;
    private final int upgradedDamageMax;
    private final int upgradeLevel;
    private final int baseSouls;
    private final int soulsPerLevel;

    EnemyType(String name, int maxHP, int hp, int maxMP, int mp, int hpPerLevel, int armourClass, int accuracy,
              int damageMin, int baseDamageMax, int upgradedDamageMax, int upgradeLevel,
              int baseSouls, int soulsPerLevel) {
        this.name = name;
        this.maxHP = maxHP;
        this.hp = hp;
        this.maxMP = maxMP;
        this.mp = mp;
        this.hpPerLevel = hpPerLevel;
        this.armourClass = armourClass;
        this.accuracy = accuracy;
        this.damageMin = damageMin;
        this.baseDamageMax = baseDamageMax;
        this.upgradedDamageMax = upgradedDamageMax;
        this.upgradeLevel = upgradeLevel;
        this.baseSouls = baseSouls;
        this.soulsPerLevel = soulsPerLevel;
    }

    public String getName() {
        return name;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getArmourClass() {
        return armourClass;
    }

    public int getHpPerLevel() {
        return hpPerLevel;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public int getBaseDamageMax() {
        return baseDamageMax;
    }

    public int getDamageMin() {
        return damageMin;
    }

    public int getUpgradedDamageMax() {
        return upgradedDamageMax;
    }

    public int getUpgradeLevel() {
        return upgradeLevel;
    }

    public int getBaseSouls() {
        return baseSouls;
    }

    public int getSoulsPerLevel() {
        return soulsPerLevel;
    }

    public int getHp() {
        return hp;
    }

    public int getMaxMP() {
        return maxMP;
    }

    public int getMp() {
        return mp;
    }
}

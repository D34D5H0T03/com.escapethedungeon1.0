package Model.Entities.Boss.NonHumanoidBoss;

public enum NonHumanoidBossType {
    ABYSSAL_HORROR(
            "Abyssal Horror",
            300,
            50,
            18,
            12,
            9,
            8,
            1200,
            "A formless entity from the void, its very presence warps reality around it.",
            12,
            18,
            true,
            10
    );

    private final String name;
    private final int maxHP;
    private final int maxMP;
    private final int armourClass;
    private final int accuracy;
    private final int initiativeBonus;
    private final int level;
    private final int souls;
    private final String description;
    private final int damageMin;
    private final int damageMax;
    private final boolean canRegenerate;
    private final int regenerationRate;

    NonHumanoidBossType(String name, int maxHP, int maxMP, int armourClass, int accuracy, int initiativeBonus,
                        int level, int souls, String description, int damageMin, int damageMax,
                        boolean canRegenerate, int regenerationRate) {
        this.name = name;
        this.maxHP = maxHP;
        this.maxMP = maxMP;
        this.armourClass = armourClass;
        this.accuracy = accuracy;
        this.initiativeBonus = initiativeBonus;
        this.level = level;
        this.souls = souls;
        this.description = description;
        this.damageMin = damageMin;
        this.damageMax = damageMax;
        this.canRegenerate = canRegenerate;
        this.regenerationRate = regenerationRate;
    }

    public String getName() {
        return name;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getMaxMP() {
        return maxMP;
    }

    public int getArmourClass() {
        return armourClass;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public int getInitiativeBonus() {
        return initiativeBonus;
    }

    public int getSouls() {
        return souls;
    }

    public int getLevel() {
        return level;
    }

    public String getDescription() {
        return description;
    }

    public int getDamageMin() {
        return damageMin;
    }

    public int getDamageMax() {
        return damageMax;
    }

    public boolean isCanRegenerate() {
        return canRegenerate;
    }

    public int getRegenerationRate() {
        return regenerationRate;
    }
}

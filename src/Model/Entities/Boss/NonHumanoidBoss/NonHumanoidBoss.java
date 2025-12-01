package Model.Entities.Boss.NonHumanoidBoss;

import Model.Entities.Boss.Boss;

import java.util.Random;

public class NonHumanoidBoss extends Boss {
    private NonHumanoidBossType type;
    private int damageMin;
    private int damageMax;
    private boolean canRegenerate;
    private int regenerationRate;

    public NonHumanoidBoss(NonHumanoidBossType type) {
        super(type.getName(), type.getMaxHP(), type.getMaxMP(), type.getArmourClass(), type.getInitiativeBonus(),
                type.getAccuracy(), type.getLevel(), type.getSouls());
        this.type = type;
        this.damageMin = type.getDamageMin();
        this.damageMax = type.getDamageMax();
        this.canRegenerate = type.isCanRegenerate();
        this.regenerationRate = type.getRegenerationRate();
    }

    @Override
    public String getDescription() {
        return type.getDescription();
    }

    public int calculateDamage(Random rand) {
        int baseDamage = rand.nextInt(damageMax - damageMin + 1) + damageMin;
        return baseDamage + level;
    }

    public NonHumanoidBossType getType() {
        return type;
    }

    public int getDamageMin() {
        return damageMin;
    }

    public boolean isCanRegenerate() {
        return canRegenerate;
    }

    public int getDamageMax() {
        return damageMax;
    }

    public int getRegenerationRate() {
        return regenerationRate;
    }

    public void setDamageMax(int damageMax) {
        this.damageMax = damageMax;
    }

    public void setDamageMin(int damageMin) {
        this.damageMin = damageMin;
    }

    public void setRegenerationRate(int regenerationRate) {
        this.regenerationRate = regenerationRate;
    }
}
